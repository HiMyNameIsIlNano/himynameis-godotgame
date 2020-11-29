package com.example.demo.domain.planet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.demo.BaseIntegrationTest;
import com.example.demo.domain.planet.definition.DifficultyEnum;
import com.example.demo.domain.planet.definition.PlanetEnum;
import com.example.demo.domain.planet.model.Planet;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PlanetServiceTest extends BaseIntegrationTest {

    public static final String TEST_PLANET_NAME = "IExist";

    @Autowired PlanetService planetService;

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
        boolean exists = planetService.existsByPlanetName(TEST_PLANET_NAME);
        assertTrue(exists);
    }

    @Test
    void planetDoesNotExist() {
        boolean exists = planetService.existsByPlanetName(TEST_PLANET_NAME + "Not");
        assertFalse(exists);
    }
}
