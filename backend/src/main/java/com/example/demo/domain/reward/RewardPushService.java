package com.example.demo.domain.reward;

import com.example.demo.grpc.messageq.api.MessageQueueApiService;
import com.example.demo.protobuf.RewardProto.RewardResponse;
import com.google.protobuf.Any;
import com.messageq.api.actions.QueueMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RewardPushService {

    @Value("${demo.messageq.exchanges.push-notification.rewards.exchange-name}")
    private String pushNotificationExchangeName;

    @Value("${demo.messageq.exchanges.push-notification.rewards.routing-key}")
    private String pushNotificationRoutingKey;

    private final MessageQueueApiService messageQueueApiService;

    public void pushLevelClearRewardToMessageQueue(RewardResponse response) {
        QueueMessage queueMessage =
                QueueMessage.newBuilder()
                        .setType("RewardResponse")
                        .setPayload(PackPayload(response))
                        .build();

        messageQueueApiService.pushMessage(
                pushNotificationExchangeName, pushNotificationRoutingKey, queueMessage);
    }

    private Any PackPayload(RewardResponse response) {
        return Any.pack(response);
    }
}
