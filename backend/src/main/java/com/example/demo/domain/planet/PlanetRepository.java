package com.example.demo.domain.planet;

import com.example.demo.domain.planet.model.Planet;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Optional<Planet> findByName(String name);

    boolean existsByName(String name);
}
