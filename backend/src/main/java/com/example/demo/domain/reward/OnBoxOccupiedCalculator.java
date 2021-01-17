package com.example.demo.domain.reward;

import com.example.demo.domain.reward.definition.AssignableResourceDefinition;
import com.example.demo.domain.reward.definition.BoxDefinition;
import com.example.demo.domain.reward.definition.RewardDefinition;
import com.google.common.base.Preconditions;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

@Value(staticConstructor = "of")
public class OnBoxOccupiedCalculator implements CalculationStrategy {

    @NonNull BoxDefinition boxDefinition;

    long level;

    RewardDefinition rewardForBoxOccupied;

    @Override
    public Collection<CalculationResult> calculate() {
        final Stream<AssignableResourceDefinition> assignableResourceDefinitionStream =
                identifyAssignableResources();

        final Map<AssignableResourceDefinition, Integer> assignableResourceToFinalAmount =
                applyBuffToAssignableResources(assignableResourceDefinitionStream);

        return toCalculationResult(assignableResourceToFinalAmount);
    }

    private Stream<AssignableResourceDefinition> identifyAssignableResources() {
        return rewardForBoxOccupied.getAssignableResources().stream()
                .filter(this::isAssignableResourceForCurrentLevel)
                .filter(this::isAssignableResourceForOccupiedBox);
    }

    private boolean isAssignableResourceForCurrentLevel(
            @NonNull AssignableResourceDefinition definition) {
        Preconditions.checkNotNull(definition, "definition must not be null.");

        return definition.getFromLevelGreaterOrEqualTo() <= level
                && level <= definition.getToLevelSmallerOrEqualTo();
    }

    private boolean isAssignableResourceForOccupiedBox(
            @NonNull AssignableResourceDefinition assignableResourceDefinition) {
        Preconditions.checkNotNull(
                assignableResourceDefinition, "assignableResourceDefinition must not be null.");

        final String forObjectId = assignableResourceDefinition.getForObjectId();
        String boxTypeId = boxDefinition.getId();
        return boxTypeId.equals(forObjectId);
    }

    public int applyBuff(@NonNull AssignableResourceDefinition assignableResourceDefinition) {
        Preconditions.checkNotNull(
                assignableResourceDefinition, "assignableResourceDefinition must not be null.");

        return assignableResourceDefinition.getAmount() * boxDefinition.getFactor();
    }
}
