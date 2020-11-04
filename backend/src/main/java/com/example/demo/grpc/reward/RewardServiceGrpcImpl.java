package com.example.demo.grpc.reward;

import com.example.demo.domain.reward.RewardService;
import com.example.demo.protobuf.RewardProto;
import com.example.demo.protobuf.RewardProto.RewardDTO;
import com.example.demo.protobuf.RewardServiceGrpc;
import com.example.demo.protobuf.reward.RewardResponseFactory;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequiredArgsConstructor
@GrpcService
public class RewardServiceGrpcImpl extends RewardServiceGrpc.RewardServiceImplBase {

    @Autowired
    private final RewardService rewardService;

    @Autowired
    private final RewardResponseFactory rewardResponseFactory;

    @Override
    public void getRewardsOnGoal(RewardProto.RewardRequest request, StreamObserver<RewardProto.RewardResponse> responseObserver) {
        List<RewardDTO> rewardDTOList = rewardService.generateRewardsDTO();
        responseObserver.onNext(rewardResponseFactory.toRewardResponse(rewardDTOList));
        responseObserver.onCompleted();
    }

    @Override
    public void getRewardsOnLevelCleared(RewardProto.RewardRequest request, StreamObserver<RewardProto.RewardResponse> responseObserver) {
        super.getRewardsOnLevelCleared(request, responseObserver);
    }
}
