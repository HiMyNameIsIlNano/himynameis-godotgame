package com.example.demo.common.socket;

import com.example.demo.domain.player.Player;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import lombok.experimental.UtilityClass;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@UtilityClass
public class SocketConnectionHolder {

    private ConcurrentMap<Integer, WebSocketSession> sessionCache = new ConcurrentHashMap<>();

    public void cachePlayerConnection(
            String socketServerUrl, WebSocketHandler handler, Player player)
            throws ExecutionException, InterruptedException {
        if (sessionCache == null) {
            return;
        }

        WebSocketSession playerWebSocketSession = sessionCache.get(player.getPlayerId());
        if (playerWebSocketSession != null && playerWebSocketSession.isOpen()) {
            return;
        }

        synchronized (SocketConnectionHolder.class) {
            sessionCache.putIfAbsent(player.getPlayerId(), getNewSession(socketServerUrl, handler));
        }
    }

    private WebSocketSession getNewSession(String socketServerUrl, WebSocketHandler handler)
            throws InterruptedException, ExecutionException {
        return new StandardWebSocketClient()
                .doHandshake(handler, new WebSocketHttpHeaders(), URI.create(socketServerUrl))
                .get();
    }

    public void closePlayerConnection(Player player) throws IOException {
        WebSocketSession playerWebSocketSession = getPlayerConnection(player);
        if (playerWebSocketSession == null) {
            return;
        }

        playerWebSocketSession.close();
    }

    public WebSocketSession getPlayerConnection(Player player) {
        if (sessionCache == null) {
            return null;
        }

        WebSocketSession playerWebSocketSession =
                sessionCache.getOrDefault(player.getPlayerId(), null);
        if (playerWebSocketSession == null) {
            return null;
        }

        if (!playerWebSocketSession.isOpen()) {
            sessionCache = null;
            return null;
        }

        return playerWebSocketSession;
    }
}
