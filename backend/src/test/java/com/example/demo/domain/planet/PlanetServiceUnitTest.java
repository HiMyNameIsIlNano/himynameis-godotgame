package com.example.demo.domain.planet;

import com.example.demo.BaseUnitTest;
import com.example.demo.domain.planet.definition.DifficultyEnum;
import com.example.demo.domain.planet.definition.PlanetEnum;
import com.example.demo.domain.planet.model.Planet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class PlanetServiceUnitTest extends BaseUnitTest {

    private PlanetService planetService;

    @Mock private PlanetRepository planetRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        planetService = new PlanetService(planetRepository);
    }

    @Test
    void initPlanets() {
        planetService.initPlanets(5);

        verify(planetRepository, times(5)).save(any());
    }

    @Test
    void save() {
        planetService.save(any());

        verify(planetRepository, times(1)).save(any());
    }

    @Test
    void findAllPlanets() {
        planetService.findAllPlanets();

        verify(planetRepository, times(1)).findAll();
    }

    @Test
    void removeAllPlanets() {
        planetService.removeAllPlanets();

        verify(planetRepository, times(1)).deleteAll();
    }

    @Test
    void doNotRemoveUnknownPlanet() {
        final Planet planet =
                new Planet("testPlanet", DifficultyEnum.EASY, PlanetEnum.EARTH, List.of());
        when(planetRepository.findByName(planet.getName())).thenReturn(Optional.empty());

        planetService.removeByName(planet.getName());
        verify(planetRepository, times(1)).findByName(planet.getName());
        verify(planetRepository, times(0)).delete(any());
    }

    @Test
    void removePlanetByName() {
        final Planet planet =
                new Planet("testPlanet", DifficultyEnum.EASY, PlanetEnum.EARTH, List.of());
        when(planetRepository.findByName(planet.getName())).thenReturn(Optional.of(planet));

        planetService.removeByName(planet.getName());
        verify(planetRepository, times(1)).findByName(planet.getName());
        verify(planetRepository, times(1)).delete(planet);
    }

    @Test
    void existsByPlanetName() {
        planetService.existsByPlanetName(anyString());

        verify(planetRepository, times(1)).existsByName(anyString());
    }
}
