package com.example.demo.controller.recipe;

import com.example.demo.domain.recipe.RecipeService;
import com.example.demo.domain.recipe.model.Recipe;
import com.example.demo.protobuf.RecipeProto.RecipeInitRequest;
import com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest;
import com.example.demo.protobuf.RecipeProto.RecipeResearchResponse;
import com.example.demo.protobuf.recipe.RecipeResponseFactory;
import java.io.IOException;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recipes")
@Transactional
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeResponseFactory recipeResponseFactory;

    @PostMapping("/init")
    public void init(@RequestBody RecipeInitRequest recipeInitRequest) {
        recipeService.initRecipes(recipeInitRequest.getAmount());
    }

    @GetMapping("/find-all")
    public RecipeResearchResponse findAllRecipes() {
        List<Recipe> recipes = recipeService.findRecipes();
        return recipeResponseFactory.toRecipeResponse(recipes);
    }

    @PostMapping("/remove-all")
    public void removeAllRecipes() {
        recipeService.removeAllRecipes();
    }

    @PostMapping("/remove-single")
    public void removeRecipe(RecipeRemoveRequest request) {
        recipeService.removeRecipe(request.getName());
    }
}
