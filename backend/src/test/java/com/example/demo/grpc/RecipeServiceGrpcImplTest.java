package com.example.demo.grpc;

import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.demo.BaseGrpcIntegrationTest;
import com.example.demo.domain.recipe.RecipeService;
import com.example.demo.grpc.recipe.DeleteAllEvent;
import com.example.demo.grpc.recipe.DeleteOneEvent;
import com.example.demo.protobuf.RecipeGrpcServiceGrpc.RecipeGrpcServiceBlockingStub;
import com.example.demo.protobuf.RecipeProto.RecipeDTO;
import com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest;
import com.example.demo.protobuf.RecipeProto.RecipeResearchResponse;
import com.google.protobuf.Empty;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.event.TransactionalEventListener;

class RecipeServiceGrpcImplTest extends BaseGrpcIntegrationTest {

    private static final int RECIPE_AMOUNT = 1;

    @Autowired private RecipeService recipeService;

    @MockBean private RecipeEventListenerMock consumer;

    @GrpcClient("inProcess")
    private RecipeGrpcServiceBlockingStub recipeServiceBlockingStub;

    @BeforeEach
    public void init() {
        recipeService.initRecipes(RECIPE_AMOUNT);
    }

    @AfterEach
    public void clean() {
        recipeService.removeAllRecipes();
        await().until(() -> recipeService.findRecipes().isEmpty());
    }

    @Test
    public void getAllRecipes() {
        RecipeResearchResponse recipeResearchResponse =
                recipeServiceBlockingStub.findAll(Empty.newBuilder().build());
        Assert.assertNotNull(recipeResearchResponse);
        Assert.assertEquals(RECIPE_AMOUNT, recipeResearchResponse.getRecipesCount());
    }

    @Test
    public void deleteAllRecipes() {
        RecipeResearchResponse recipeResearchResponse =
                recipeServiceBlockingStub.findAll(Empty.newBuilder().build());
        Assert.assertNotNull(recipeResearchResponse);
        Assert.assertEquals(RECIPE_AMOUNT, recipeResearchResponse.getRecipesCount());

        Empty emptyRequest = Empty.newBuilder().build();
        recipeServiceBlockingStub.removeAllRecipes(emptyRequest);

        waitForDeleteAllEventBeforeContinuing();

        RecipeResearchResponse afterDeletionResearchResponse =
                recipeServiceBlockingStub.findAll(emptyRequest);
        Assert.assertNotNull(afterDeletionResearchResponse);
        Assert.assertEquals(0, afterDeletionResearchResponse.getRecipesCount());
    }

    private void waitForDeleteAllEventBeforeContinuing() {
        await().until(() -> Mockito.mockingDetails(consumer).getInvocations().size() == 1);
        verify(consumer, times(1)).listenToDeleteAll(any(DeleteAllEvent.class));
    }

    @Test
    public void deleteOneRecipe() {
        Empty request = Empty.newBuilder().build();
        RecipeDTO recipe = recipeServiceBlockingStub.findAll(request).getRecipes(0);

        RecipeRemoveRequest recipeRemoveRequest =
                RecipeRemoveRequest.newBuilder().setName(recipe.getName()).build();
        recipeServiceBlockingStub.removeRecipe(recipeRemoveRequest);

        waitForDeleteOneEventBeforeContinuing();

        RecipeResearchResponse recipeResearchResponse = recipeServiceBlockingStub.findAll(request);
        Assert.assertNotNull(recipeResearchResponse);
        Assert.assertEquals(RECIPE_AMOUNT - 1, recipeResearchResponse.getRecipesCount());
    }

    private void waitForDeleteOneEventBeforeContinuing() {
        await().until(() -> Mockito.mockingDetails(consumer).getInvocations().size() == 1);
        verify(consumer, times(1)).listenToDeleteOne(any(DeleteOneEvent.class));
    }

    @TestComponent
    private static class RecipeEventListenerMock {

        @TransactionalEventListener
        public void listenToDeleteAll(DeleteAllEvent deleteAllEvent) {}

        @TransactionalEventListener
        public void listenToDeleteOne(DeleteOneEvent deleteOneEvent) {}
    }
}
