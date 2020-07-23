package com.example.demo.grpc;

import com.example.demo.domain.recipe.RecipeService;
import com.example.demo.protobuf.RecipeProto.RecipeResearchResponse;
import com.example.demo.protobuf.RecipeServiceGrpc;
import com.example.demo.protobuf.recipe.RecipeResponseFactory;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
@Transactional
public class RecipeServiceGrpcImpl extends RecipeServiceGrpc.RecipeServiceImplBase {

    private final RecipeService recipeService;

    private final RecipeResponseFactory recipeResponseFactory;

    @Override
    public void findAll(Empty request, StreamObserver<RecipeResearchResponse> responseObserver) {
        RecipeResearchResponse recipeResearchResponse =
                recipeResponseFactory.toRecipeResponse(recipeService.findRecipes());

        responseObserver.onNext(recipeResearchResponse);
        responseObserver.onCompleted();
    }
}
