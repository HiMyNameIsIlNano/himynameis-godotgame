package com.example.demo.controller.recipe;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.BaseRestIntegrationTest;
import com.example.demo.IntegrationTestUtils.RecipeUrlEnum;
import com.example.demo.protobuf.RecipeProto.RecipeDTO;
import com.example.demo.protobuf.RecipeProto.RecipeInitRequest;
import com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest;
import com.example.demo.protobuf.RecipeProto.RecipeResearchResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

class RecipeControllerTest extends BaseRestIntegrationTest {

    @Autowired private RecipeController controller;

    @Autowired private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getAllRecipes() {
        int amount = 5;
        doPostInitRecipes(amount);

        RecipeResearchResponse response = doGetAllRecipes();
        Assert.assertNotNull(response);
        Assert.assertEquals(amount, response.getRecipesCount());
    }

    private void doPostInitRecipes(int amount) {
        String initUrl = RecipeUrlEnum.toUrl(RecipeUrlEnum.INIT, getPort());
        RecipeInitRequest initRequest = RecipeInitRequest.newBuilder().setAmount(amount).build();

        restTemplate.postForObject(initUrl, initRequest, Void.class);
    }

    private RecipeResearchResponse doGetAllRecipes() {
        String findAllUrl = RecipeUrlEnum.toUrl(RecipeUrlEnum.FIND_ALL, getPort());

        return restTemplate.getForObject(findAllUrl, RecipeResearchResponse.class);
    }

    @Test
    public void deleteAllRecipes() {
        doPostInitRecipes(5);

        doPostDeleteAllRecipes();

        RecipeResearchResponse response = doGetAllRecipes();
        Assert.assertNull(response);
    }

    private void doPostDeleteAllRecipes() {
        String deleteAllUrl = RecipeUrlEnum.toUrl(RecipeUrlEnum.REMOVE_ALL, getPort());

        restTemplate.postForObject(deleteAllUrl, null, Void.class);
    }

    @Test
    public void deleteOneRecipe() {
        doPostInitRecipes(5);

        RecipeDTO recipe = doGetAllRecipes().getRecipes(0);

        doPostDeleteOneRecipe(recipe.getName());

        RecipeResearchResponse response = doGetAllRecipes();
        Assert.assertNotNull(response);
        Assert.assertEquals(4, response.getRecipesCount());
    }

    private void doPostDeleteOneRecipe(String name) {
        String deleteOneUrl = RecipeUrlEnum.toUrl(RecipeUrlEnum.REMOVE_SINGLE, getPort());
        RecipeRemoveRequest deleteRequest = RecipeRemoveRequest.newBuilder().setName(name).build();

        restTemplate.postForObject(deleteOneUrl, deleteRequest, Void.class);
    }
}
