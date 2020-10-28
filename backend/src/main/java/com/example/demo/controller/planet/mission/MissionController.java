package com.example.demo.controller.planet.mission;

import com.example.demo.domain.planet.mission.MissionDefinitionLoader;
import com.example.demo.protobuf.MissionProto.MissionListResponse;
import com.example.demo.protobuf.MissionProto.MissionResponse;
import com.example.demo.protobuf.recipe.ingredient.MissionResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/missions")
public class MissionController {

    private final MissionDefinitionLoader loader;
    private final MissionResponseFactory missionResponseFactory;

    @GetMapping("/find-all")
    public MissionListResponse finAll() throws IOException {
        return missionResponseFactory.toMissionResponseList(loader.loadAll());
    }

    @GetMapping("/find-by-id")
    public MissionResponse finById(@RequestParam String id) {
        return missionResponseFactory.toMissionResponse(loader.loadById(id));
    }
}
