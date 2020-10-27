package com.example.demo.controller.planet.mission;

import com.example.demo.domain.planet.mission.MissionDefinitionLoader;
import com.example.demo.protobuf.IngredientProto.IngredientListResponse;
import com.example.demo.protobuf.IngredientProto.IngredientResponse;
import com.example.demo.protobuf.recipe.ingredient.MissionResponseFactory;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/missions")
public class MissionController {

    private final MissionDefinitionLoader loader;
    private final MissionResponseFactory missionResponseFactory;

    @GetMapping("/find-all")
    public IngredientListResponse finAll() throws IOException {
        return missionResponseFactory.toIngredientResponseList(loader.loadAll());
    }

    @GetMapping("/find-by-id")
    public IngredientResponse finById(@RequestParam String id) {
        return missionResponseFactory.toIngredientResponse(loader.loadById(id));
    }
}
