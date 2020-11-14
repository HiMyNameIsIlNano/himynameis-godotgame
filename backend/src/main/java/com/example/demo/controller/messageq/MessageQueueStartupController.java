package com.example.demo.controller.messageq;

import com.example.demo.grpc.messageq.startup.MessageQueueStartupService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("enable-rest")
@RequiredArgsConstructor
@RestController
@RequestMapping("/message-queue")
public class MessageQueueStartupController {

    private final MessageQueueStartupService messageQueueStartupService;

    @PostMapping("/connect")
    public void connect() {
        messageQueueStartupService.buildMessagePushQueueExchange();
    }
}
