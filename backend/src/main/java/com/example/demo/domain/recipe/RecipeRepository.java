package com.example.demo.domain.recipe;

import com.example.demo.domain.recipe.model.Recipe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

	Optional<Recipe> findByName(String name);

}
