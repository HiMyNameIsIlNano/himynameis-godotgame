package com.example.demo.domain.recipe.ingredient.model;

import com.example.demo.common.model.BaseEntity;
import com.example.demo.domain.recipe.definition.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
public class Ingredient extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    @Type(type = "ingredient-enum")
    @Column(columnDefinition = "ingredient_definition")
    private IngredientDefinitionEnum ingredientDefinition;

    @Embedded
    private Amount amount;

}

