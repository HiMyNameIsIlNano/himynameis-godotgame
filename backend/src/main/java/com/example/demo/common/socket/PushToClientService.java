package com.example.demo.common.socket;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@NoArgsConstructor
@Service
public class PushToClientService extends TextWebSocketHandler {

    private static final String WEBSOCKET_SERVER_URL = "ws://127.0.0.1:4444/";

    private WebSocketSession session;

    public void pushToClient(String text)
            throws IOException, ExecutionException, InterruptedException {
        if (session == null) {
            doConnect();
        }

        this.session.sendMessage(new TextMessage(text));
    }

    private void doConnect() throws InterruptedException, ExecutionException {
        this.session =
                new StandardWebSocketClient()
                        .doHandshake(
                                this, new WebSocketHttpHeaders(), URI.create(WEBSOCKET_SERVER_URL))
                        .get();
    }
}
