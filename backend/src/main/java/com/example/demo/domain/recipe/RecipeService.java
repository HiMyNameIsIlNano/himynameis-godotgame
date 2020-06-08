package com.example.demo.domain.recipe;

import com.example.demo.domain.recipe.definition.Amount;
import com.example.demo.domain.recipe.definition.CategoryEnum;
import com.example.demo.domain.recipe.definition.DifficultyEnum;
import com.example.demo.domain.recipe.definition.UnitOfMeasureEnum;
import com.example.demo.domain.recipe.ingredient.IngredientRepository;
import com.example.demo.domain.recipe.ingredient.model.Ingredient;
import com.example.demo.domain.recipe.ingredient.model.IngredientDefinitionEnum;
import com.example.demo.domain.recipe.model.Recipe;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RecipeService {

	private final RecipeRepository recipeRepository;

	private final IngredientRepository ingredientRepository;

	public void initRecipes(int amount) {
		while (amount > 0) {
			mockAndPersistRecipe(amount);
			amount--;
		}
	}

	private void mockAndPersistRecipe(int index) {
		Recipe recipe = new Recipe("Recipe_" + index, DifficultyEnum.EASY, CategoryEnum.WITH_MEAT);
		Ingredient ingredient = mockIngredientsForRecipe(recipe);
		recipeRepository.save(recipe);
		ingredientRepository.save(ingredient);
	}

	private Ingredient mockIngredientsForRecipe(Recipe recipe) {
		int randomQuantity = ThreadLocalRandom.current().nextInt(100);
		Amount amount = new Amount(randomQuantity, UnitOfMeasureEnum.GRAMS);
		return new Ingredient(IngredientDefinitionEnum.WHEAT, amount, recipe);
	}

	public List<Recipe> findRecipes() {
		return recipeRepository.findAll();
	}

	public void removeAllRecipes() {
		List<Recipe> recipes = recipeRepository.findAll();
		recipes.forEach(ingredientRepository::deleteByRecipe);
	}

	public void removeRecipe(String name) {
		Optional<Recipe> recipe = recipeRepository.findByName(name);
		if (recipe.isEmpty()) {
			return;
		}

		ingredientRepository.deleteByRecipe(recipe.get());
	}
}
