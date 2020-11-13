package com.example.demo.domain.planet;

import com.example.demo.domain.planet.definition.Amount;
import com.example.demo.domain.planet.definition.DifficultyEnum;
import com.example.demo.domain.planet.definition.PlanetEnum;
import com.example.demo.domain.planet.definition.UnitOfMeasureEnum;
import com.example.demo.domain.planet.mission.model.Mission;
import com.example.demo.domain.planet.mission.model.MissionDefinitionEnum;
import com.example.demo.domain.planet.model.Planet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    public void initPlanets(int amount) {
        while (amount > 0) {
            mockAndPersistPlanet(amount);
            amount--;
        }
    }

    private void mockAndPersistPlanet(int index) {
        Planet planet =
                new Planet(
                        "Planet_" + index, DifficultyEnum.EASY, PlanetEnum.EARTH, mockMissions());

        planetRepository.save(planet);
    }

    private List<Mission> mockMissions() {
        List<Mission> missionList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            missionList.add(mockMissionsForUniverse());
        }
        return missionList;
    }

    private Mission mockMissionsForUniverse() {
        int randomQuantity = ThreadLocalRandom.current().nextInt(100);
        Amount amount = new Amount(randomQuantity, UnitOfMeasureEnum.GRAMS);
        return new Mission(MissionDefinitionEnum.ESCAPE_THE_GIANT_SQUID, amount);
    }

    public List<Planet> findAllPlanets() {
        return planetRepository.findAll();
    }

    public void removeAllPlanets() {
        planetRepository.deleteAll();
    }

    public void removePlanet(String name) {
        Optional<Planet> planet = planetRepository.findByName(name);
        if (planet.isEmpty()) {
            return;
        }

        planetRepository.delete(planet.get());
    }
}
