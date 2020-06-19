
package com.example.demo.domain.recipe.ingredient.definition;

import com.example.demo.common.definition.BaseDefinition;
import com.example.demo.domain.recipe.ingredient.model.Ingredient;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.DiscriminatorValue;
import java.util.Objects;

/**
 * The definition of an {@link Ingredient}.
 */
@DiscriminatorValue("ingredients")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "category"
})
public class IngredientDefinition extends BaseDefinition {

    @JsonProperty("category")
    private String category;

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
        return Objects.hashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof IngredientDefinition)) {
            return false;
        }
        return Objects.equals(this, other);
    }

}
