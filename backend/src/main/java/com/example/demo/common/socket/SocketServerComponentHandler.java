package com.example.demo.common.socket;

import com.example.demo.domain.player.Player;
import com.example.demo.protobuf.SocketPush.SocketPushMessage;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

@NoArgsConstructor
@Component
@Slf4j
public class SocketServerComponentHandler extends BinaryWebSocketHandler {

    @Value("${demo.socket-server.protocol:ws}")
    private String socketServerProtocol;

    @Value("${demo.socket-server.address:localhost}")
    private String socketServerAddress;

    @Value("${demo.socket-server.port:4444}")
    private int socketServerPort;

    private String socketServerUrl;

    @PostConstruct
    public void afterConstructInit() {
        this.socketServerUrl =
                String.format(
                        "%s://%s:%s/", socketServerProtocol, socketServerAddress, socketServerPort);
    }

    public void connectToSocketServer(Player player)
            throws ExecutionException, InterruptedException {
        SocketConnectionHolder.cachePlayerConnection(socketServerUrl, this, player);
    }

    @Retryable(
            value = {IOException.class, ExecutionException.class, InterruptedException.class},
            maxAttempts = 5,
            backoff = @Backoff(10000L))
    public void sendMessageToPlayerWithRetryIfServerOffline(Player player)
            throws IOException, ExecutionException, InterruptedException {
        connectToSocketServer(player);

        SocketPushMessage pushMessage =
                SocketPushMessage.newBuilder()
                        .setPlayerId(player.getPlayerId())
                        .setText("Random Text")
                        .build();

        WebSocketSession playerWebSocketSession =
                SocketConnectionHolder.getPlayerConnection(player);
        playerWebSocketSession.sendMessage(new BinaryMessage(pushMessage.toByteArray()));
    }

    public void closeConnectionWithSocketServer(Player player) throws IOException {
        SocketConnectionHolder.closePlayerConnection(player);
    }
}
