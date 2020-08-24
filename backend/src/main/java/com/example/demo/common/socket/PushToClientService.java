package com.example.demo.common.socket;

import com.example.demo.protobuf.SocketPush.SocketPushMessage;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import javax.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

@NoArgsConstructor
@Service
public class PushToClientService extends BinaryWebSocketHandler {

    @Value("${demo.socket-server.protocol:ws}")
    private String socketServerProtocol;

    @Value("${demo.socket-server.address:localhost}")
    private String socketServerAddress;

    @Value("${demo.socket-server.port:4444}")
    private int socketServerPort;

    private String socketServerUrl;

    // TODO: this is not thread safe
    WebSocketSession session = null;

    @PostConstruct
    public void afterConstructInit() throws ExecutionException, InterruptedException {
        this.socketServerUrl =
                String.format(
                        "%s://%s:%s/", socketServerProtocol, socketServerAddress, socketServerPort);
        this.session = getSession();
    }

    public void pushToClient(SocketPushMessage message) throws IOException {
        session.sendMessage(new BinaryMessage(message.toByteArray()));
    }

    private WebSocketSession getSession() throws InterruptedException, ExecutionException {
        return new StandardWebSocketClient()
                .doHandshake(this, new WebSocketHttpHeaders(), URI.create(socketServerUrl))
                .get();
    }

    public void closeConnectionWithSocketServer() throws IOException {
        if (session == null && session.isOpen()) {
            return;
        }

        session.close();
    }
}
