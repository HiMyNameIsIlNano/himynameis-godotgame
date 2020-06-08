package com.example.demo.domain.recipe.ingredient.model;

import com.example.demo.common.definition.EnumDefinitionType;
import com.example.demo.common.model.BaseEntity;
import com.example.demo.domain.recipe.definition.Amount;
import com.example.demo.domain.recipe.definition.StringBasedDefinition;
import com.example.demo.domain.recipe.model.Recipe;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
@TypeDef(name = "ingredient-enum", typeClass = EnumDefinitionType.class, defaultForType = StringBasedDefinition.class)
public class Ingredient extends BaseEntity {

	@Enumerated(value = EnumType.STRING)
	@Type(type = "ingredient-enum")
	@Column(columnDefinition = "ingredient_definition")
	private IngredientDefinitionEnum ingredientDefinition;

	@Embedded
	private Amount amount;

	@ManyToOne(fetch = FetchType.LAZY)
	private Recipe recipe;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ingredient that = (Ingredient) o;
		return Objects.equals(ingredientDefinition, that.ingredientDefinition) &&
			Objects.equals(amount, that.amount) &&
			Objects.equals(recipe, that.recipe);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ingredientDefinition, amount, recipe);
	}
}

