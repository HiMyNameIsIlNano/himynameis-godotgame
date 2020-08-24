package com.example.demo.controller.socket;

import com.example.demo.common.socket.PushToClientService;
import com.example.demo.protobuf.SocketPush.SocketPushMessage;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/socket")
public class SocketController {

    private final PushToClientService pushToClientService;

    @PostMapping("/push")
    public void testConnection() throws IOException, ExecutionException, InterruptedException {
        SocketPushMessage pushMessage =
                SocketPushMessage.newBuilder().setPlayerId(4).setText("Random Text").build();

        pushToClientService.pushToClient(pushMessage);
    }

    @PostMapping("/close")
    public void closeConnection() throws IOException {
        pushToClientService.closeConnectionWithSocketServer();
    }
}
