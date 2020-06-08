
package com.example.demo.domain.recipe.ingredient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"category"
})
public class IngredientDefinition {

	@JsonProperty("id")
	private String id;
	@JsonProperty("category")
	private String category;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = ((result * 31) + ((this.category == null) ? 0 : this.category.hashCode()));
		result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof IngredientDefinition)) {
			return false;
		}
		IngredientDefinition rhs = ((IngredientDefinition) other);
		return (((this.category == rhs.category) || ((this.category != null) && this.category.equals(rhs.category))) && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))));
	}

}
