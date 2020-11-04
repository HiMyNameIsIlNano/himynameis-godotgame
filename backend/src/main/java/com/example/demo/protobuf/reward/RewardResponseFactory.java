package com.example.demo.protobuf.reward;

import com.example.demo.protobuf.RewardProto;
import org.springframework.stereotype.Service;

@Service
public class RewardResponseFactory {

    public RewardProto.RewardResponse toRewardResponse(Iterable<? extends RewardProto.RewardDTO> rewards) {
        return RewardProto.RewardResponse.newBuilder()
                .addAllRewards(rewards)
                .build();
    }
}
