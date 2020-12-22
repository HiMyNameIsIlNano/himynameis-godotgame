package com.example.demo.protobuf.planet.mission;

import com.example.demo.domain.planet.mission.definition.MissionDefinition;
import com.example.demo.protobuf.MissionProto.MissionDTO;
import com.example.demo.protobuf.MissionProto.MissionListResponse;
import com.example.demo.protobuf.MissionProto.MissionResponse;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;

@Service
public class MissionResponseFactory {

    public MissionListResponse toMissionListResponse(
            @Nonnull List<MissionDefinition> missionDefinitionList) {
        Preconditions.checkNotNull(
                missionDefinitionList, "missionDefinitionList must not be null.");

        return MissionListResponse.newBuilder()
                .addAllMissions(toMissionCollectionDTO(missionDefinitionList))
                .build();
    }

    private Iterable<MissionDTO> toMissionCollectionDTO(
            @Nonnull List<MissionDefinition> missionDefinitionList) {
        return missionDefinitionList.stream().map(this::toMissionDto)::iterator;
    }

    private MissionDTO toMissionDto(@Nonnull MissionDefinition missionDefinition) {
        Preconditions.checkNotNull(missionDefinition, "missionDefinition must not be null.");

        return MissionDTO.newBuilder()
                .setId(missionDefinition.getId())
                .setCategory(missionDefinition.getCategory())
                .build();
    }

    public MissionResponse toMissionResponse(@Nonnull MissionDefinition missionDefinition) {
        Preconditions.checkNotNull(missionDefinition, "missionDefinition must not be null.");

        return MissionResponse.newBuilder().setMission(toMissionDto(missionDefinition)).build();
    }
}
