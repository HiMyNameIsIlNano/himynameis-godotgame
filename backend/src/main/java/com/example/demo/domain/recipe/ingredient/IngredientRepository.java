package com.example.demo.domain.recipe.ingredient;

import com.example.demo.domain.recipe.ingredient.model.Ingredient;
import com.example.demo.domain.recipe.model.Recipe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

	List<Ingredient> findAllByRecipe(Recipe recipe);

	void deleteByRecipe(Recipe recipe);
}
