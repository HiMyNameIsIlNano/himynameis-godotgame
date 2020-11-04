package com.example.demo.protobuf.planet;

import com.example.demo.domain.planet.definition.Amount;
import com.example.demo.domain.planet.mission.model.Mission;
import com.example.demo.domain.planet.model.Planet;
import com.example.demo.protobuf.PlanetProto.AmountDTO;
import com.example.demo.protobuf.PlanetProto.MissionAmountDTO;
import com.example.demo.protobuf.PlanetProto.PlanetDTO;
import com.example.demo.protobuf.PlanetProto.PlanetResearchResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlanetResponseFactory {

    public PlanetResearchResponse toPlanetResponse(List<Planet> univers) {
        return PlanetResearchResponse.newBuilder().addAllPlanets(toPlanetDTOList(univers)).build();
    }

    private List<PlanetDTO> toPlanetDTOList(List<Planet> univers) {
        return univers.stream().map(this::toPlanetDTO).collect(Collectors.toList());
    }

    private PlanetDTO toPlanetDTO(Planet planet) {
        return PlanetDTO.newBuilder()
                .setName(planet.getName())
                .setDifficulty(planet.getDifficulty().name())
                .setCategory(planet.getCategory().name())
                .addAllMissionAmount(toMissionList(planet.getMissions()))
                .build();
    }

    private Iterable<? extends MissionAmountDTO> toMissionList(
            List<Mission> missionDefinitionList) {
        return missionDefinitionList.stream().map(this::toMission)::iterator;
    }

    private MissionAmountDTO toMission(Mission mission) {
        return MissionAmountDTO.newBuilder()
                .setMissionId(mission.getMissionDefinition().name())
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
