package com.example.demo.grpc.recipe;

import com.example.demo.domain.recipe.RecipeService;
import com.example.demo.protobuf.RecipeProto.RecipeInitRequest;
import com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest;
import com.example.demo.protobuf.RecipeProto.RecipeResearchResponse;
import com.example.demo.protobuf.RecipeServiceGrpc;
import com.example.demo.protobuf.recipe.RecipeResponseFactory;
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
public class RecipeServiceGrpcImpl extends RecipeServiceGrpc.RecipeServiceImplBase {

    private final RecipeService recipeService;

    private final RecipeResponseFactory recipeResponseFactory;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void init(RecipeInitRequest request, StreamObserver<Empty> responseObserver) {
        try {
            recipeService.initRecipes(request.getAmount());
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
                recipeResponseFactory.toRecipeResponse(recipeService.findRecipes());

        responseObserver.onNext(recipeResearchResponse);
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void removeAllRecipes(Empty request, StreamObserver<Empty> responseObserver) {
        try {
            recipeService.removeAllRecipes();
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
            recipeService.removeRecipe(request.getName());
        } catch (Exception e) {
            responseObserver.onError(Status.ABORTED.asRuntimeException());
        }

        applicationEventPublisher.publishEvent(new DeleteOneEvent(this));

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
