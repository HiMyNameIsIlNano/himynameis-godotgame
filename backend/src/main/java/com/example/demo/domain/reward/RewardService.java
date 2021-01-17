package com.example.demo.domain.reward;

import com.example.demo.domain.reward.definition.BoxDefinition;
import com.example.demo.domain.reward.definition.RewardDefinition;
import com.example.demo.protobuf.RewardProto.RewardRequest.BoxType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class RewardService {

    private final ApplicationEventPublisher applicationEventPublisher;

    private final RewardDefinitionLoader rewardDefinitionLoader;

    private final BoxDefinitionLoader boxDefinitionLoader;

    public Collection<CalculationResult> generateRewardsDtoOnBoxOccupied(
            BoxType boxType, int level) {
        final RewardDefinition rewardOnOccupied =
                rewardDefinitionLoader.loadById("rewards.on_occupied");
        final BoxDefinition occupiedBox = identifyOccupiedBox(boxType);
        return OnBoxOccupiedCalculator.of(occupiedBox, level, rewardOnOccupied).calculate();
    }

    private BoxDefinition identifyOccupiedBox(BoxType boxType) {
        return boxDefinitionLoader.loadByFunction(
                box -> boxType.name().equalsIgnoreCase(box.getBoxType()));
    }

    public Collection<CalculationResult> generateRewardDtoOnLevelCleared(int clearedLevel) {
        final RewardDefinition rewardOnLevelCleared =
                rewardDefinitionLoader.loadById("rewards.on_level_cleared");
        final Collection<CalculationResult> calculatedResult =
                OnLevelClearedCalculator.of(clearedLevel, rewardOnLevelCleared).calculate();

        applicationEventPublisher.publishEvent(new RewardPushEvent(this, calculatedResult));
        return calculatedResult;
    }
}
