package com.example.demo.domain.reward;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.Collection;

@Getter
public class RewardPushEvent extends ApplicationEvent {

    private final Collection<CalculationResult> calculationResult;

    public RewardPushEvent(Object source, Collection<CalculationResult> calculationResult) {
        super(source);
        this.calculationResult = calculationResult;
    }
}
