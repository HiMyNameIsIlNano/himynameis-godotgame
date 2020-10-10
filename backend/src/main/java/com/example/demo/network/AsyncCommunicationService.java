package com.example.demo.network;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AsyncCommunicationService {

    private final RabbitTemplate rabbitTemplate;
    public void sendMessageToSocketServer() {
        // rabbitTemplate.convertAndSend(AyncCommunicationCreateExchangeService.PUSH_NOTIFICATION_EXCHANGE, "", message);
    }

}
