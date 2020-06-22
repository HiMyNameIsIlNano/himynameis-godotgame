package com.example.demo.protobuf.recipe;

import com.example.demo.domain.recipe.definition.Amount;
import com.example.demo.domain.recipe.ingredient.model.Ingredient;
import com.example.demo.domain.recipe.model.Recipe;
import com.example.demo.protobuf.RecipeProto.AmountDTO;
import com.example.demo.protobuf.RecipeProto.IngredientAmountDTO;
import com.example.demo.protobuf.RecipeProto.RecipeDTO;
import com.example.demo.protobuf.RecipeProto.RecipeResearchResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RecipeResponseFactory {

    public RecipeResearchResponse toRecipeResponse(List<Recipe> recipes) {
        return RecipeResearchResponse.newBuilder().addAllRecipes(toRecipeDTOList(recipes)).build();
    }

    private List<RecipeDTO> toRecipeDTOList(List<Recipe> recipes) {
        return recipes.stream().map(this::toRecipeDTO).collect(Collectors.toList());
    }

    private RecipeDTO toRecipeDTO(Recipe recipe) {
        return RecipeDTO.newBuilder()
                .setName(recipe.getName())
                .setDifficulty(recipe.getDifficulty().name())
                .setCategory(recipe.getCategory().name())
                .addAllIngredientAmount(toIngredientList(recipe.getIngredients()))
                .build();
    }

    private Iterable<? extends IngredientAmountDTO> toIngredientList(
            List<Ingredient> ingredientDefinitionList) {
        return ingredientDefinitionList.stream().map(this::toIngredient)::iterator;
    }

    private IngredientAmountDTO toIngredient(Ingredient ingredient) {
        return IngredientAmountDTO.newBuilder()
                .setIngredientId(ingredient.getIngredientDefinition().name())
                .setAmount(toAmount(ingredient.getAmount()))
                .build();
    }

    private AmountDTO toAmount(Amount amount) {
        return AmountDTO.newBuilder()
                .setAmount(amount.getQuantity())
                .setUnitOfMeasure(amount.getUnitOfMeasure().getLabel())
                .build();
    }
}
