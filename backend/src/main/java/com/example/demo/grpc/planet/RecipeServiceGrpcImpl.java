package com.example.demo.grpc.planet;

import com.example.demo.domain.planet.PlanetService;
import com.example.demo.protobuf.RecipeGrpcServiceGrpc;
import com.example.demo.protobuf.RecipeProto.RecipeInitRequest;
import com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest;
import com.example.demo.protobuf.RecipeProto.RecipeResearchResponse;
import com.example.demo.protobuf.recipe.PlanetResponseFactory;
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
public class RecipeServiceGrpcImpl extends RecipeGrpcServiceGrpc.RecipeGrpcServiceImplBase {

    private final PlanetService planetService;

    private final PlanetResponseFactory planetResponseFactory;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void init(RecipeInitRequest request, StreamObserver<Empty> responseObserver) {
        try {
            planetService.initRecipes(request.getAmount());
        } catch (Exception e) {
            responseObserver.onError(Status.ABORTED.asRuntimeException());
        }

        applicationEventPublisher.publishEvent(new InitEvent(this));

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void findAll(Empty request, StreamObserver<RecipeResearchResponse> responseObserver) {
        RecipeResearchResponse recipeResearchResponse =
                planetResponseFactory.toRecipeResponse(planetService.findRecipes());

        responseObserver.onNext(recipeResearchResponse);
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void removeAllRecipes(Empty request, StreamObserver<Empty> responseObserver) {
        try {
            planetService.removeAllRecipes();
        } catch (Exception e) {
            responseObserver.onError(Status.ABORTED.asRuntimeException());
        }

        applicationEventPublisher.publishEvent(new DeleteAllEvent(this));

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void removeRecipe(RecipeRemoveRequest request, StreamObserver<Empty> responseObserver) {
        try {
            planetService.removeRecipe(request.getName());
        } catch (Exception e) {
            responseObserver.onError(Status.ABORTED.asRuntimeException());
        }

        applicationEventPublisher.publishEvent(new DeleteOneEvent(this));

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
