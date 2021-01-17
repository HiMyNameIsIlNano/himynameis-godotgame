package com.example.demo.protobuf.planet;

import com.example.demo.domain.planet.definition.Amount;
import com.example.demo.domain.planet.mission.model.Mission;
import com.example.demo.domain.planet.model.Planet;
import com.example.demo.protobuf.PlanetProto.AmountDTO;
import com.example.demo.protobuf.PlanetProto.MissionAmountDTO;
import com.example.demo.protobuf.PlanetProto.PlanetDTO;
import com.example.demo.protobuf.PlanetProto.PlanetResearchResponse;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetResponseFactory {

    public PlanetResearchResponse toPlanetResponse(@Nonnull List<Planet> planets) {
        Preconditions.checkNotNull(planets, "planets must not be null.");

        return PlanetResearchResponse.newBuilder().addAllPlanets(toPlanetDTOList(planets)).build();
    }

    private List<PlanetDTO> toPlanetDTOList(@Nonnull List<Planet> planets) {
        return planets.stream().map(this::toPlanetDTO).collect(Collectors.toList());
    }

    private PlanetDTO toPlanetDTO(@Nonnull Planet planet) {
        Preconditions.checkNotNull(planet, "planet must not be null.");

        return PlanetDTO.newBuilder()
                .setName(planet.getName())
                .setDifficulty(planet.getDifficulty().name())
                .setCategory(planet.getCategory().name())
                .addAllMissionAmount(toMissionList(planet.getMissions()))
                .build();
    }

    private Iterable<? extends MissionAmountDTO> toMissionList(
            @Nonnull List<Mission> missionDefinitionList) {
        Preconditions.checkNotNull(
                missionDefinitionList, "missionDefinitionList must not be null.");

        return missionDefinitionList.stream().map(this::toMission)::iterator;
    }

    private MissionAmountDTO toMission(@Nonnull Mission mission) {
        return MissionAmountDTO.newBuilder()
                .setMissionId(mission.getMissionDefinition().name())
                .setAmount(toAmount(mission.getAmount()))
                .build();
    }

    private AmountDTO toAmount(@Nonnull Amount amount) {
        return AmountDTO.newBuilder()
                .setAmount(amount.getQuantity())
                .setUnitOfMeasure(amount.getUnitOfMeasure().getLabel())
                .build();
    }
}
