package com.example.demo.grpc.game.reward;

import com.example.demo.domain.reward.RewardService;
import com.example.demo.protobuf.RewardProto.RewardDTO;
import com.example.demo.protobuf.RewardProto.RewardRequest;
import com.example.demo.protobuf.RewardProto.RewardResponse;
import com.example.demo.protobuf.RewardServiceGrpc;
import com.example.demo.protobuf.reward.RewardResponseFactory;
import io.grpc.stub.StreamObserver;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
@GrpcService
public class RewardServiceGrpcImpl extends RewardServiceGrpc.RewardServiceImplBase {

    @Autowired private final RewardService rewardService;

    @Autowired private final RewardResponseFactory rewardResponseFactory;

    @Override
    public void getRewardsOnGoal(
            RewardRequest request, StreamObserver<RewardResponse> responseObserver) {
        List<RewardDTO> rewardDTOList =
                rewardService.generateOnBoxOccupiedRewardsDTO(
                        request.getBoxType(), request.getLevel());
        responseObserver.onNext(rewardResponseFactory.toRewardResponse(rewardDTOList));
        responseObserver.onCompleted();
    }

    @Override
    public void getRewardsOnLevelCleared(
            RewardRequest request, StreamObserver<RewardResponse> responseObserver) {
        List<RewardDTO> rewardDTOList =
                rewardService.generateOnLevelClearedRewardDTO(request.getLevel());
        responseObserver.onNext(rewardResponseFactory.toRewardResponse(rewardDTOList));
        responseObserver.onCompleted();
    }
}
