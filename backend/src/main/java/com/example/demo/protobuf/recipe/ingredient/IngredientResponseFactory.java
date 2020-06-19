package com.example.demo.protobuf.recipe.ingredient;

import com.example.demo.domain.recipe.ingredient.definition.IngredientDefinition;
import com.example.demo.protobuf.IngredientProto.IngredientDTO;
import com.example.demo.protobuf.IngredientProto.IngredientDTO.CategoryEnum;
import com.example.demo.protobuf.IngredientProto.IngredientListResponse;
import com.example.demo.protobuf.IngredientProto.IngredientResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientResponseFactory {

    public IngredientListResponse toIngredientResponseList(List<IngredientDefinition> ingredientDefinitionList) {
        return IngredientListResponse.newBuilder()
                .addAllIngredients(toIngredientCollectionDTO(ingredientDefinitionList))
                .build();
    }

    private Iterable<IngredientDTO> toIngredientCollectionDTO(List<IngredientDefinition> ingredientDefinitionList) {
        return ingredientDefinitionList.stream()
                .map(this::toIngredientDto)::iterator;
    }

    private IngredientDTO toIngredientDto(IngredientDefinition ingredientDefinition) {
        return IngredientDTO.newBuilder()
                .setId(ingredientDefinition.getId())
                .setCategory(CategoryEnum.valueOf(ingredientDefinition.getCategory()))
                .build();
    }

    public IngredientResponse toIngredientResponse(IngredientDefinition ingredientDefinition) {
        return IngredientResponse.newBuilder()
                .setIngredient(toIngredientDto(ingredientDefinition))
                .build();
    }
}
