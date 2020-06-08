
package com.example.demo.domain.recipe.ingredient;

import com.example.demo.common.definition.BaseDefinition;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("ingredient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"ingredients"
})
public class IngredientDefinitionList implements BaseDefinition {

	@JsonProperty("ingredients")
	private List<IngredientDefinition> ingredients = new ArrayList<>();

	@JsonProperty("ingredients")
	public List<IngredientDefinition> getIngredients() {
		return ingredients;
	}

	@JsonProperty("ingredients")
	public void setIngredients(List<IngredientDefinition> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = ((result * 31) + ((this.ingredients == null) ? 0 : this.ingredients.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof IngredientDefinitionList)) {
			return false;
		}
		IngredientDefinitionList rhs = ((IngredientDefinitionList) other);
		return ((this.ingredients == rhs.ingredients) || ((this.ingredients != null) && this.ingredients.equals(rhs.ingredients)));
	}

}
