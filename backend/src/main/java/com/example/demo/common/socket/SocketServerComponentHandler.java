package com.example.demo.common.socket;

import com.example.demo.protobuf.SocketPush.SocketPushMessage;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import javax.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
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

    private WebSocketSession session = null;

    @PostConstruct
    public void afterConstructInit() {
        this.socketServerUrl =
                String.format(
                        "%s://%s:%s/", socketServerProtocol, socketServerAddress, socketServerPort);
    }

    public void connectToSocketServer() throws ExecutionException, InterruptedException {
        if (session != null && session.isOpen()) {
            return;
        }

        synchronized (this) {
            session = createOrGetSession();
        }
    }

    private WebSocketSession createOrGetSession() throws InterruptedException, ExecutionException {
        return new StandardWebSocketClient()
                .doHandshake(this, new WebSocketHttpHeaders(), URI.create(socketServerUrl))
                .get();
    }

    @Retryable(
            value = {IOException.class, ExecutionException.class, InterruptedException.class},
            maxAttempts = 5,
            backoff = @Backoff(10000L)
    )
    public void sendMessageWithRetryIfServerOffline(SocketPushMessage message)
            throws IOException, ExecutionException, InterruptedException {
        connectToSocketServer();
        session.sendMessage(new BinaryMessage(message.toByteArray()));
    }

    public void closeConnectionWithSocketServer() throws IOException {
        if (session == null) {
            return;
        }

        if (!session.isOpen()) {
            session = null;
            return;
        }

        session.close();
    }
}
