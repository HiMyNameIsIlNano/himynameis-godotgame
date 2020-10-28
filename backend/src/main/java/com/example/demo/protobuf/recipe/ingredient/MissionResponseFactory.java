package com.example.demo.protobuf.recipe.ingredient;

import com.example.demo.domain.planet.mission.definition.MissionDefinition;
import com.example.demo.protobuf.MissionProto.MissionDTO;
import com.example.demo.protobuf.MissionProto.MissionDTO.CategoryEnum;
import com.example.demo.protobuf.MissionProto.MissionListResponse;
import com.example.demo.protobuf.MissionProto.MissionResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MissionResponseFactory {

    public MissionListResponse toMissionResponseList(
            List<MissionDefinition> missionDefinitionList) {
        return MissionListResponse.newBuilder()
                .addAllMissions(toMissionCollectionDTO(missionDefinitionList))
                .build();
    }

    private Iterable<MissionDTO> toMissionCollectionDTO(
            List<MissionDefinition> missionDefinitionList) {
        return missionDefinitionList.stream().map(this::toMissionDto)::iterator;
    }

    private MissionDTO toMissionDto(MissionDefinition missionDefinition) {
        return MissionDTO.newBuilder()
                .setId(missionDefinition.getId())
                .setCategory(CategoryEnum.valueOf(missionDefinition.getCategory()))
                .build();
    }

    public MissionResponse toMissionResponse(MissionDefinition missionDefinition) {
        return MissionResponse.newBuilder().setMission(toMissionDto(missionDefinition)).build();
    }
}
