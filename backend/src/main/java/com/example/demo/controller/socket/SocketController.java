package com.example.demo.controller.socket;

import com.example.demo.common.socket.SocketServerComponentHandler;
import com.example.demo.domain.player.Player;
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

    private final SocketServerComponentHandler socketServerComponentHandler;

    @PostMapping("/connect")
    public void connect() throws ExecutionException, InterruptedException {
        socketServerComponentHandler.connectToSocketServer(new Player(1000));
    }

    @PostMapping("/push")
    public void pushMessage() throws IOException, ExecutionException, InterruptedException {
        socketServerComponentHandler.sendMessageToPlayerWithRetryIfServerOffline(new Player(1000));
    }

    @PostMapping("/close")
    public void closeConnection() throws IOException {
        socketServerComponentHandler.closeConnectionWithSocketServer(new Player(1000));
    }
}
