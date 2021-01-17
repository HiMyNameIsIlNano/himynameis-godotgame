package com.example.demo.domain.reward.listener;

import com.example.demo.domain.reward.RewardPushEvent;
import com.example.demo.domain.reward.RewardPushService;
import com.example.demo.protobuf.RewardProto.RewardResponse;
import com.example.demo.protobuf.reward.RewardResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RewardEventListener {

    private final RewardPushService rewardPushService;

    private final RewardResponseFactory rewardResponseFactory;

    @EventListener
    public void onRewardPushEvent(RewardPushEvent rewardPushEvent) {
        final RewardResponse rewardResponse =
                rewardResponseFactory.toRewardResponseFromCalculationResults(
                        rewardPushEvent.getCalculationResult());
        rewardPushService.pushLevelClearRewardToMessageQueue(rewardResponse);
    }
}
