package com.example.demo.grpc.game.reward;

import com.example.demo.domain.reward.CalculationResult;
import com.example.demo.domain.reward.RewardService;
import com.example.demo.protobuf.RewardProto.RewardRequest;
import com.example.demo.protobuf.RewardProto.RewardResponse;
import com.example.demo.protobuf.RewardServiceGrpc;
import com.example.demo.protobuf.reward.RewardResponseFactory;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Collection;

@RequiredArgsConstructor
@GrpcService
public class RewardServiceGrpcImpl extends RewardServiceGrpc.RewardServiceImplBase {

    private final RewardService rewardService;

    private final RewardResponseFactory rewardResponseFactory;

    @Override
    public void getRewardsOnGoal(
            RewardRequest request, StreamObserver<RewardResponse> responseObserver) {
        final Collection<CalculationResult> calculationResult =
                rewardService.generateRewardsDtoOnBoxOccupied(
                        request.getBoxType(), request.getLevel());

        responseObserver.onNext(
                rewardResponseFactory.toRewardResponseFromCalculationResults(calculationResult));
        responseObserver.onCompleted();
    }

    @Override
    public void getRewardsOnLevelCleared(
            RewardRequest request, StreamObserver<RewardResponse> responseObserver) {
        final Collection<CalculationResult> calculationResult =
                rewardService.generateRewardDtoOnLevelCleared(request.getLevel());

        responseObserver.onNext(
                rewardResponseFactory.toRewardResponseFromCalculationResults(calculationResult));
        responseObserver.onCompleted();
    }
}
