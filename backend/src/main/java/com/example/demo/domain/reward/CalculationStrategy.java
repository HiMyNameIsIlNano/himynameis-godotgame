package com.example.demo.domain.reward;

import com.example.demo.domain.reward.definition.AssignableResourceDefinition;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface CalculationStrategy {

    Collection<CalculationResult> calculate();

    default Map<AssignableResourceDefinition, Integer> applyBuffToAssignableResources(
            Stream<AssignableResourceDefinition> assignableResourceDefinitionStream) {
        return assignableResourceDefinitionStream.collect(
                Collectors.toMap(Function.identity(), this::applyBuff));
    }

    int applyBuff(AssignableResourceDefinition assignableResourceDefinition);

    default Collection<CalculationResult> toCalculationResult(
            Map<AssignableResourceDefinition, Integer> assignableResourceDefinitionStream) {
        return assignableResourceDefinitionStream.entrySet().stream()
                .map(
                        awardedResourceToAmount ->
                                new CalculationResult(
                                        awardedResourceToAmount.getKey().getAwardedResourceId(),
                                        awardedResourceToAmount.getValue()))
                .collect(Collectors.toUnmodifiableList());
    }
}
