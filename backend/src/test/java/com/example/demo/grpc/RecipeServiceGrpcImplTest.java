package com.example.demo.grpc;

import com.example.demo.BaseGrpcIntegrationTest;
import com.example.demo.protobuf.RecipeProto.RecipeResearchResponse;
import com.example.demo.protobuf.RecipeServiceGrpc.RecipeServiceBlockingStub;
import com.google.protobuf.Empty;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

class RecipeServiceGrpcImplTest extends BaseGrpcIntegrationTest {

    @GrpcClient("inProcess")
    private RecipeServiceBlockingStub recipeServiceBlockingStub;

    @Test
    @DirtiesContext
    public void findAll() {
        Empty request = Empty.newBuilder().build();
        RecipeResearchResponse recipeResearchResponse = recipeServiceBlockingStub.findAll(request);
        Assert.assertNotNull(recipeResearchResponse);
        Assert.assertEquals(0, recipeResearchResponse.getRecipesCount());
    }
}
