package com.example.demo.domain.reward;

import com.example.demo.domain.reward.definition.AssignableResourceDefinition;
import com.example.demo.domain.reward.definition.BoxDefinition;
import com.example.demo.domain.reward.definition.RewardDefinition;
import com.example.demo.protobuf.RewardProto.RewardRequest.BoxType;

import java.util.List;

public class RewardTestDataHelper {

    public static BoxDefinition getBoxDefinition(String id, BoxType boxType, int factor) {
        final BoxDefinition boxDefinition = new BoxDefinition();
        boxDefinition.setId(id);
        boxDefinition.setBoxType(boxType.name());
        boxDefinition.setFactor(factor);

        return boxDefinition;
    }

    public static RewardDefinition getRewardDefinitionForOccupiedBox(BoxDefinition boxDefinition) {
        final RewardDefinition rewardDefinition = new RewardDefinition();
        rewardDefinition.setId("rewards.on_occupied");
        final AssignableResourceDefinition assignableResourceDefinitionForLevelOneAndTwo =
                getAssignableResourceDefinition(1, 2, boxDefinition.getId(), 2);
        final AssignableResourceDefinition assignableResourceDefinitionForLevelThreeAndFour =
                getAssignableResourceDefinition(3, 4, boxDefinition.getId(), 4);
        final List<AssignableResourceDefinition> assignableResourceDefinition =
                List.of(
                        assignableResourceDefinitionForLevelOneAndTwo,
                        assignableResourceDefinitionForLevelThreeAndFour);
        rewardDefinition.setAssignableResources(assignableResourceDefinition);

        return rewardDefinition;
    }

    private static AssignableResourceDefinition getAssignableResourceDefinition(
            int fromLevelGreaterOrEqualTo,
            int toLevelSmallerOrEqualTo,
            String forObjectId,
            int awardedAmount) {

        final AssignableResourceDefinition assignableResourceDefinition =
                getAssignableResourceDefinition(
                        fromLevelGreaterOrEqualTo, toLevelSmallerOrEqualTo, awardedAmount);
        assignableResourceDefinition.setForObjectId(forObjectId);
        return assignableResourceDefinition;
    }

    private static AssignableResourceDefinition getAssignableResourceDefinition(
            int fromLevelGreaterOrEqualTo, int toLevelSmallerOrEqualTo, int awardedAmount) {

        return AssignableResourceDefinition.builder()
                .fromLevelGreaterOrEqualTo(fromLevelGreaterOrEqualTo)
                .toLevelSmallerOrEqualTo(toLevelSmallerOrEqualTo)
                .awardedResourceId("resource.coins.silver")
                .amount(awardedAmount)
                .build();
    }

    @NotNull
    public static RewardDefinition getRewardDefinition() {
        final RewardDefinition rewardDefinition = new RewardDefinition();
        rewardDefinition.setId("rewards.on_level_cleared");
        final AssignableResourceDefinition assignableResourceDefinitionForLevelOneToTwo =
                getAssignableResourceDefinition(1, 2, 1);
        final AssignableResourceDefinition assignableResourceDefinitionForLevelThreeAndFour =
                getAssignableResourceDefinition(3, 4, 2);
        final List<AssignableResourceDefinition> assignableResourceDefinitionForLevelCleared =
                List.of(
                        assignableResourceDefinitionForLevelOneToTwo,
                        assignableResourceDefinitionForLevelThreeAndFour);
        rewardDefinition.setAssignableResources(assignableResourceDefinitionForLevelCleared);
        return rewardDefinition;
    }
}
