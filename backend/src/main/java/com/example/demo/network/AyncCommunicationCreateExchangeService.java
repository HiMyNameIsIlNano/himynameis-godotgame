package com.example.demo.network;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Service
public class AyncCommunicationCreateExchangeService {

    private final RabbitAdmin rabbitAdmin;

    public static String PUSH_NOTIFICATION_EXCHANGE = "push-notification";

    @PostConstruct
    private void createExchanges() {
        rabbitAdmin.declareExchange(ExchangeBuilder.directExchange(PUSH_NOTIFICATION_EXCHANGE).build());
    }
}
