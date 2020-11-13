package com.example.demo.protobuf.reward;

import com.example.demo.protobuf.RewardProto;
import com.example.demo.protobuf.RewardProto.RewardResponse;
import org.springframework.stereotype.Service;

@Service
public class RewardResponseFactory {

    public RewardResponse toRewardResponse(Iterable<? extends RewardProto.RewardDTO> rewards) {
        return RewardProto.RewardResponse.newBuilder().addAllRewards(rewards).build();
    }

    public RewardProto.RewardDTO toRewardDTO(String rewardId, int amount) {
        return RewardProto.RewardDTO.newBuilder().setRewardId(rewardId).setAmount(amount).build();
    }
}
