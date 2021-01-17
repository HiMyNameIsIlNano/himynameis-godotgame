package com.example.demo.domain.reward;

import com.example.demo.domain.reward.definition.AssignableResourceDefinition;
import com.example.demo.domain.reward.definition.RewardDefinition;
import com.google.common.base.Preconditions;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

@Value(staticConstructor = "of")
public class OnLevelClearedCalculator implements CalculationStrategy {

    int level;

    @NonNull RewardDefinition rewardForLevelCleared;

    @Override
    public Collection<CalculationResult> calculate() {
        final Stream<AssignableResourceDefinition> assignableResourceDefinitionStream =
                identifyAssignableResources();

        final Map<AssignableResourceDefinition, Integer> assignableResourceToFinalAmount =
                applyBuffToAssignableResources(assignableResourceDefinitionStream);

        return toCalculationResult(assignableResourceToFinalAmount);
    }

    private Stream<AssignableResourceDefinition> identifyAssignableResources() {
        return rewardForLevelCleared.getAssignableResources().stream()
                .filter(this::isRewardForCurrentLevel);
    }

    private boolean isRewardForCurrentLevel(@NonNull AssignableResourceDefinition definition) {
        Preconditions.checkNotNull(definition, "definition must not be null.");

        return definition.getFromLevelGreaterOrEqualTo() <= level
                && level <= definition.getToLevelSmallerOrEqualTo();
    }

    public int applyBuff(@NonNull AssignableResourceDefinition assignableResourceDefinition) {
        Preconditions.checkNotNull(
                assignableResourceDefinition, "assignableResourceDefinition must not be null.");

        return assignableResourceDefinition.getAmount() * level;
    }
}
