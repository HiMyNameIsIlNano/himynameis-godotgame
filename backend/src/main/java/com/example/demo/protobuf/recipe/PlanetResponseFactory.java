package com.example.demo.protobuf.recipe;

import com.example.demo.domain.planet.definition.Amount;
import com.example.demo.domain.planet.mission.model.Mission;
import com.example.demo.domain.planet.model.Planet;
import com.example.demo.protobuf.RecipeProto.AmountDTO;
import com.example.demo.protobuf.RecipeProto.IngredientAmountDTO;
import com.example.demo.protobuf.RecipeProto.RecipeDTO;
import com.example.demo.protobuf.RecipeProto.RecipeResearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlanetResponseFactory {

    public RecipeResearchResponse toRecipeResponse(List<Planet> univers) {
        return RecipeResearchResponse.newBuilder().addAllRecipes(toRecipeDTOList(univers)).build();
    }

    private List<RecipeDTO> toRecipeDTOList(List<Planet> univers) {
        return univers.stream().map(this::toRecipeDTO).collect(Collectors.toList());
    }

    private RecipeDTO toRecipeDTO(Planet planet) {
        return RecipeDTO.newBuilder()
                .setName(planet.getName())
                .setDifficulty(planet.getDifficulty().name())
                .setCategory(planet.getCategory().name())
                .addAllIngredientAmount(toIngredientList(planet.getMissions()))
                .build();
    }

    private Iterable<? extends IngredientAmountDTO> toIngredientList(
            List<Mission> missionDefinitionList) {
        return missionDefinitionList.stream().map(this::toIngredient)::iterator;
    }

    private IngredientAmountDTO toIngredient(Mission mission) {
        return IngredientAmountDTO.newBuilder()
                .setIngredientId(mission.getMissionDefinition().name())
                .setAmount(toAmount(mission.getAmount()))
                .build();
    }

    private AmountDTO toAmount(Amount amount) {
        return AmountDTO.newBuilder()
                .setAmount(amount.getQuantity())
                .setUnitOfMeasure(amount.getUnitOfMeasure().getLabel())
                .build();
    }
}
