package com.example.demo.network;

import com.example.demo.protobuf.SocketPush.SocketPushMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AsyncCommunicationService {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessageToSocketServer(SocketPushMessage message) {
        rabbitTemplate.convertAndSend(AyncCommunicationCreateExchangeService.PUSH_NOTIFICATION_EXCHANGE, "", message);
    }

}
