package com.example.demo.domain.recipe.model;

import com.example.demo.common.model.BaseEntity;
import com.example.demo.domain.recipe.definition.CategoryEnum;
import com.example.demo.domain.recipe.definition.DifficultyEnum;
import com.example.demo.domain.recipe.ingredient.model.Ingredient;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Getter
@Table(
        uniqueConstraints =
                @UniqueConstraint(
                        name = "unique_recipe_constraint",
                        columnNames = {"name"}))
public class Recipe extends BaseEntity {

    @NaturalId private String name;

    @Enumerated(value = EnumType.STRING)
    private DifficultyEnum difficulty;

    @Enumerated(value = EnumType.STRING)
    private CategoryEnum category;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private List<Ingredient> ingredients;

    /*@Type(
            type = "typed-list",
            parameters = {
                @Parameter(name = "type", value = "ingredient_definition"),
                @Parameter(name = "discriminatorValue", value = "ingredients")
            })
    @Column(columnDefinition = "ingredient_definition[]")
    private List<IngredientDefinition> ingredientDefinitions = new ArrayList<>();*/
}
