package com.example.demo.domain.planet;

import com.example.demo.BaseIntegrationTest;
import com.example.demo.domain.planet.definition.DifficultyEnum;
import com.example.demo.domain.planet.definition.PlanetEnum;
import com.example.demo.domain.planet.model.Planet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlanetServiceIntegrationTest extends BaseIntegrationTest {

    public static final String TEST_PLANET_NAME = "IExist";

    @Autowired private PlanetService planetService;

    @BeforeEach
    public void initDb() {
        planetService.save(
                new Planet(TEST_PLANET_NAME, DifficultyEnum.EASY, PlanetEnum.EARTH, List.of()));
    }

    @AfterEach
    public void cleanDb() {
        planetService.removeByName(TEST_PLANET_NAME);
    }

    @Test
    void planetExists() {
        final boolean exists = planetService.existsByPlanetName(TEST_PLANET_NAME);
        assertTrue(exists);
    }

    @Test
    void planetDoesNotExist() {
        final boolean exists = planetService.existsByPlanetName(TEST_PLANET_NAME + "Not");
        assertFalse(exists);
    }
}
