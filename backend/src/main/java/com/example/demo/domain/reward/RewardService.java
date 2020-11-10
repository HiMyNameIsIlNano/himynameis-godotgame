package com.example.demo.domain.reward;

import com.example.demo.grpc.messageq.api.MessageQueueApiService;
import com.example.demo.protobuf.RewardProto.RewardDTO;
import com.example.demo.protobuf.RewardProto.RewardRequest.BoxType;
import com.example.demo.protobuf.reward.RewardResponseFactory;
import com.google.protobuf.Any;
import com.messageq.api.actions.QueueMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RewardService {

    @Value("${demo.messageq.exchanges.push-notification.exchange-name}")
    private String pushNotificationExchangeName;

    @Value("${demo.messageq.exchanges.push-notification.routing-key}")
    private String pushNotificationRoutingKey;

    private final MessageQueueApiService messageQueueApiService;

    private final RewardResponseFactory rewardResponseFactory;

    public List<RewardDTO> generateOnBoxOccupiedRewardsDTO(BoxType boxType, int level) {
        List<RewardDTO> result = new ArrayList<>();

        // TODO: use json defined values for this to make sense...
        switch (boxType) {
            case RED -> result.add(rewardResponseFactory.toRewardDTO("reward.coins.silver", -1 * level));
            case BLUE -> result.add(rewardResponseFactory.toRewardDTO("reward.coins.silver", level));
            case GREEN -> result.add(rewardResponseFactory.toRewardDTO("reward.coins.silver", 2 * level));
        }

        return result;
    }

    public List<RewardDTO> generateOnLevelClearedRewardDTO(int level) {
        pushLevelClearRewardToMessageQueue();
        return List.of(rewardResponseFactory.toRewardDTO("reward.diamonds", 2 * level));
    }

    private void pushLevelClearRewardToMessageQueue() {
        QueueMessage queueMessage = QueueMessage.newBuilder()
                .setType("RewardResponse")
                .setMessage(getRewards())
                .build();

        messageQueueApiService.pushMessage(pushNotificationExchangeName, pushNotificationRoutingKey, queueMessage);
    }

    private Any getRewards() {
        List<RewardDTO> rewards = List.of(rewardResponseFactory.toRewardDTO("reward.coins.gold", 1));
        return Any.pack(rewardResponseFactory.toRewardResponse(rewards));
    }

}
