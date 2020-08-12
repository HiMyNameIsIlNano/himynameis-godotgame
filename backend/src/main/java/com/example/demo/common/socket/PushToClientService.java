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

    @PostConstruct
    public void afterConstructInit() {
        this.socketServerUrl =
                String.format(
                        "%s://%s:%s/", socketServerProtocol, socketServerAddress, socketServerPort);
    }

    public void pushToClient(SocketPushMessage message)
            throws IOException, ExecutionException, InterruptedException {
        WebSocketSession session = getSession();
        session.sendMessage(new BinaryMessage(message.toByteArray()));
        session.close();
    }

    private WebSocketSession getSession() throws InterruptedException, ExecutionException {
        // TODO: at the moment the socket connection is not reused by the client. Therefore a new
        // one is reopened every time
        return new StandardWebSocketClient()
                .doHandshake(this, new WebSocketHttpHeaders(), URI.create(socketServerUrl))
                .get();
    }

    public void closeConnectionWithServerSocket() {
        // TODO: at the moment the socket connection is not reused by the client. Therefore every time a new
        // one is opened it is also closed in the same "transaction"
    }
}
