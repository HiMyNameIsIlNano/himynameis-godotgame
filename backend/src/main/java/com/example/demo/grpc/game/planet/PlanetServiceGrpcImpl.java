package com.example.demo.grpc.game.planet;

import com.example.demo.domain.planet.PlanetService;
import com.example.demo.protobuf.PlanetProto.PlanetInitRequest;
import com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest;
import com.example.demo.protobuf.PlanetProto.PlanetResearchResponse;
import com.example.demo.protobuf.PlanetServiceGrpc;
import com.example.demo.protobuf.planet.PlanetResponseFactory;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.context.ApplicationEventPublisher;

@GrpcService
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PlanetServiceGrpcImpl extends PlanetServiceGrpc.PlanetServiceImplBase {

    private final PlanetService planetService;

    private final PlanetResponseFactory planetResponseFactory;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void init(PlanetInitRequest request, StreamObserver<Empty> responseObserver) {
        try {
            planetService.initPlanets(request.getAmount());
        } catch (Exception e) {
            responseObserver.onError(Status.ABORTED.asRuntimeException());
        }

        applicationEventPublisher.publishEvent(new InitEvent(this));

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void findAll(Empty request, StreamObserver<PlanetResearchResponse> responseObserver) {
        PlanetResearchResponse PlanetResearchResponse =
                planetResponseFactory.toPlanetResponse(planetService.findAllPlanets());

        responseObserver.onNext(PlanetResearchResponse);
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void removeAllPlanets(Empty request, StreamObserver<Empty> responseObserver) {
        try {
            planetService.removeAllPlanets();
        } catch (Exception e) {
            responseObserver.onError(Status.ABORTED.asRuntimeException());
        }

        applicationEventPublisher.publishEvent(new DeleteAllEvent(this));

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void removePlanet(PlanetRemoveRequest request, StreamObserver<Empty> responseObserver) {
        try {
            planetService.removePlanet(request.getName());
        } catch (Exception e) {
            responseObserver.onError(Status.ABORTED.asRuntimeException());
        }

        applicationEventPublisher.publishEvent(new DeleteOneEvent(this));

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
