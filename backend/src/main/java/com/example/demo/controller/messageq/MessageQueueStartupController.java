package com.example.demo.controller.messageq;

import com.example.demo.network.MessageQueueStartupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
