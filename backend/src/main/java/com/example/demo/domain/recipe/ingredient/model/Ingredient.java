package com.example.demo.domain.recipe.ingredient.model;

import com.example.demo.common.model.BaseEntity;
import com.example.demo.domain.recipe.definition.Amount;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
@ToString(callSuper = true)
public class Ingredient extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    @Type(type = "ingredient-enum")
    @Column(columnDefinition = "ingredient_definition")
    private IngredientDefinitionEnum ingredientDefinition;

    @Embedded private Amount amount;
}
