package com.example.demo.protobuf.reward;

import com.example.demo.domain.reward.CalculationResult;
import com.example.demo.protobuf.RewardProto.RewardDTO;
import com.example.demo.protobuf.RewardProto.RewardResponse;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardResponseFactory {

    public RewardResponse toRewardResponseFromDTOs(@Nonnull Iterable<? extends RewardDTO> rewards) {
        Preconditions.checkNotNull(rewards, "rewards must not be null.");

        return RewardResponse.newBuilder().addAllRewards(rewards).build();
    }

    public RewardDTO toRewardDTO(@Nonnull String rewardId, int amount) {
        Preconditions.checkNotNull(rewardId, "rewardId must not be null.");

        return RewardDTO.newBuilder().setRewardId(rewardId).setAmount(amount).build();
    }

    public RewardResponse toRewardResponseFromCalculationResults(
            @Nonnull Collection<CalculationResult> calculatedResult) {
        Preconditions.checkNotNull(calculatedResult, "calculatedResult must not be null.");

        return toRewardResponseFromDTOs(new ArrayList<>(toRewardDTOS(calculatedResult)));
    }

    private List<RewardDTO> toRewardDTOS(@Nonnull Collection<CalculationResult> calculatedResult) {
        Preconditions.checkNotNull(calculatedResult, "calculatedResult must not be null.");

        return calculatedResult.stream()
                .map(
                        calculationResult ->
                                toRewardDTO(
                                        calculationResult.resourceId(), calculationResult.amount()))
                .collect(Collectors.toList());
    }
}
