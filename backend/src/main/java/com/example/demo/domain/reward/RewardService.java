package com.example.demo.domain.reward;

import com.example.demo.protobuf.RewardProto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    public List<RewardProto.RewardDTO> generateRewardsDTO() {
        return List.of();
    }

}
