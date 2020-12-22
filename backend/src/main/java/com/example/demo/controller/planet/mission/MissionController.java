package com.example.demo.controller.planet.mission;

import com.example.demo.domain.planet.mission.MissionDefinitionLoader;
import com.example.demo.protobuf.MissionProto.MissionListResponse;
import com.example.demo.protobuf.MissionProto.MissionResponse;
import com.example.demo.protobuf.planet.mission.MissionResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Profile("enable-rest")
@RequiredArgsConstructor
@RestController
@RequestMapping("/missions")
public class MissionController {

    private final MissionDefinitionLoader loader;
    private final MissionResponseFactory missionResponseFactory;

    @GetMapping("/find-all")
    public MissionListResponse finAll() throws IOException {
        return missionResponseFactory.toMissionListResponse(loader.loadAll());
    }

    @GetMapping("/find-by-id")
    public MissionResponse finById(@RequestParam String id) {
        return missionResponseFactory.toMissionResponse(loader.loadById(id));
    }
}
