package com.example.demo.controller.planet;

import com.example.demo.domain.planet.PlanetService;
import com.example.demo.domain.planet.model.Planet;
import com.example.demo.protobuf.PlanetProto.PlanetInitRequest;
import com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest;
import com.example.demo.protobuf.PlanetProto.PlanetResearchResponse;
import com.example.demo.protobuf.planet.PlanetResponseFactory;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@Profile("enable-rest")
@RequiredArgsConstructor
@RestController
@RequestMapping("/planets")
@Transactional
public class PlanetController {

    private final PlanetService planetService;
    private final PlanetResponseFactory planetResponseFactory;

    @PostMapping("/init")
    public void init(@RequestBody PlanetInitRequest recipeInitRequest) {
        planetService.initPlanets(recipeInitRequest.getAmount());
    }

    @GetMapping("/find-all")
    public PlanetResearchResponse findAllPlanets() {
        List<Planet> univereList = planetService.findAllPlanets();
        return planetResponseFactory.toPlanetResponse(univereList);
    }

    @PostMapping("/remove-all")
    public void removeAllRecipes() {
        planetService.removeAllPlanets();
    }

    @PostMapping("/remove-single")
    public void removeRecipe(@RequestBody PlanetRemoveRequest request) {
        planetService.removeByName(request.getName());
    }
}
