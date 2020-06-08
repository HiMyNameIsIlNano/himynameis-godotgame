
package com.example.demo.domain.generated;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ingredients"
})
public class IngredientDefinition {

    @JsonProperty("ingredients")
    private List<IngredientDefinition__1> ingredients = new ArrayList<IngredientDefinition__1>();

    @JsonProperty("ingredients")
    public List<IngredientDefinition__1> getIngredients() {
        return ingredients;
    }

    @JsonProperty("ingredients")
    public void setIngredients(List<IngredientDefinition__1> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.ingredients == null)? 0 :this.ingredients.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IngredientDefinition) == false) {
            return false;
        }
        IngredientDefinition rhs = ((IngredientDefinition) other);
        return ((this.ingredients == rhs.ingredients)||((this.ingredients!= null)&&this.ingredients.equals(rhs.ingredients)));
    }

}
