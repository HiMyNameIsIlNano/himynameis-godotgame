package com.example.demo.protobuf.recipe.ingredient;

import com.example.demo.domain.planet.mission.definition.MissionDefinition;
import com.example.demo.protobuf.IngredientProto.IngredientDTO;
import com.example.demo.protobuf.IngredientProto.IngredientDTO.CategoryEnum;
import com.example.demo.protobuf.IngredientProto.IngredientListResponse;
import com.example.demo.protobuf.IngredientProto.IngredientResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MissionResponseFactory {

    public IngredientListResponse toIngredientResponseList(
            List<MissionDefinition> missionDefinitionList) {
        return IngredientListResponse.newBuilder()
                .addAllIngredients(toIngredientCollectionDTO(missionDefinitionList))
                .build();
    }

    private Iterable<IngredientDTO> toIngredientCollectionDTO(
            List<MissionDefinition> missionDefinitionList) {
        return missionDefinitionList.stream().map(this::toIngredientDto)::iterator;
    }

    private IngredientDTO toIngredientDto(MissionDefinition missionDefinition) {
        return IngredientDTO.newBuilder()
                .setId(missionDefinition.getId())
                .setCategory(CategoryEnum.valueOf(missionDefinition.getCategory()))
                .build();
    }

    public IngredientResponse toIngredientResponse(MissionDefinition missionDefinition) {
        return IngredientResponse.newBuilder()
                .setIngredient(toIngredientDto(missionDefinition))
                .build();
    }
}
