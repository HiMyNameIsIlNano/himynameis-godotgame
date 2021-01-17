package com.example.demo.protobuf.planet;

import com.example.demo.BaseUnitTest;
import com.example.demo.domain.planet.definition.Amount;
import com.example.demo.domain.planet.definition.DifficultyEnum;
import com.example.demo.domain.planet.definition.PlanetEnum;
import com.example.demo.domain.planet.definition.UnitOfMeasureEnum;
import com.example.demo.domain.planet.mission.model.Mission;
import com.example.demo.domain.planet.mission.model.MissionDefinitionEnum;
import com.example.demo.domain.planet.model.Planet;
import com.example.demo.protobuf.PlanetProto.MissionAmountDTO;
import com.example.demo.protobuf.PlanetProto.PlanetDTO;
import com.example.demo.protobuf.PlanetProto.PlanetResearchResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class PlanetResponseFactoryUnitTest extends BaseUnitTest {

    private PlanetResponseFactory planetResponseFactory;

    @BeforeEach
    public void setUp() {
        planetResponseFactory = new PlanetResponseFactory();
    }

    @Test
    void toNullPlanetResponse() {
        // noinspection ConstantConditions
        Assertions.assertThrows(
                NullPointerException.class, () -> planetResponseFactory.toPlanetResponse(null));
    }

    @Test
    void toEmptyPlanetResponse() {
        final PlanetResearchResponse planetResearchResponse =
                planetResponseFactory.toPlanetResponse(Collections.emptyList());
        Assertions.assertNotNull(planetResearchResponse);
        Assertions.assertEquals(0L, planetResearchResponse.getPlanetsCount());
    }

    @Test
    void toSingleListPlanetResponse() {
        final List<Mission> missions =
                List.of(
                        new Mission(
                                MissionDefinitionEnum.CATCH_THE_DIAMOND,
                                new Amount(10, UnitOfMeasureEnum.CENTILITERS)));
        final Planet planet =
                new Planet("testPlanet", DifficultyEnum.EASY, PlanetEnum.EARTH, missions);
        final PlanetResearchResponse planetResearchResponse =
                planetResponseFactory.toPlanetResponse(List.of(planet));
        Assertions.assertNotNull(planetResearchResponse);
        Assertions.assertEquals(1L, planetResearchResponse.getPlanetsCount());

        final PlanetDTO planetToTest = planetResearchResponse.getPlanets(0);
        Assertions.assertEquals("testPlanet", planetToTest.getName());
        Assertions.assertEquals(DifficultyEnum.EASY.name(), planetToTest.getDifficulty());
        Assertions.assertEquals(PlanetEnum.EARTH.name(), planetToTest.getCategory());
        Assertions.assertEquals(1L, planetToTest.getMissionAmountCount());

        final MissionAmountDTO missionAmountToTest = planetToTest.getMissionAmount(0);
        Assertions.assertEquals(
                MissionDefinitionEnum.CATCH_THE_DIAMOND.name(), missionAmountToTest.getMissionId());
        Assertions.assertEquals(10, missionAmountToTest.getAmount().getAmount());
        Assertions.assertEquals(
                UnitOfMeasureEnum.CENTILITERS.getLabel(),
                missionAmountToTest.getAmount().getUnitOfMeasure());
    }

    @Test
    void toListPlanetResponse() {
        final Mission mission1 =
                new Mission(
                        MissionDefinitionEnum.CATCH_THE_DIAMOND,
                        new Amount(10, UnitOfMeasureEnum.CENTILITERS));
        final Mission mission2 =
                new Mission(
                        MissionDefinitionEnum.ESCAPE_THE_GIANT_SQUID,
                        new Amount(15, UnitOfMeasureEnum.KILOS));

        final List<Mission> missions = List.of(mission1, mission2);
        Planet planet = new Planet("testPlanet", DifficultyEnum.EASY, PlanetEnum.EARTH, missions);

        final PlanetResearchResponse planetResearchResponse =
                planetResponseFactory.toPlanetResponse(List.of(planet));
        Assertions.assertNotNull(planetResearchResponse);
        Assertions.assertEquals(1L, planetResearchResponse.getPlanetsCount());

        final PlanetDTO planetToTest = planetResearchResponse.getPlanets(0);
        Assertions.assertEquals("testPlanet", planetToTest.getName());
        Assertions.assertEquals(DifficultyEnum.EASY.name(), planetToTest.getDifficulty());
        Assertions.assertEquals(PlanetEnum.EARTH.name(), planetToTest.getCategory());
        Assertions.assertEquals(2L, planetToTest.getMissionAmountCount());

        final MissionAmountDTO missionAmountToTest1 = planetToTest.getMissionAmount(0);
        Assertions.assertEquals(
                MissionDefinitionEnum.CATCH_THE_DIAMOND.name(),
                missionAmountToTest1.getMissionId());
        Assertions.assertEquals(10, missionAmountToTest1.getAmount().getAmount());
        Assertions.assertEquals(
                UnitOfMeasureEnum.CENTILITERS.getLabel(),
                missionAmountToTest1.getAmount().getUnitOfMeasure());

        final MissionAmountDTO missionAmountToTest2 = planetToTest.getMissionAmount(1);
        Assertions.assertEquals(
                MissionDefinitionEnum.ESCAPE_THE_GIANT_SQUID.name(),
                missionAmountToTest2.getMissionId());
        Assertions.assertEquals(15, missionAmountToTest2.getAmount().getAmount());
        Assertions.assertEquals(
                UnitOfMeasureEnum.KILOS.getLabel(),
                missionAmountToTest2.getAmount().getUnitOfMeasure());
    }
}
