package com.example.demo.controller.planet;

import com.example.demo.domain.planet.PlanetService;
import com.example.demo.domain.planet.model.Planet;
import com.example.demo.protobuf.RecipeProto.RecipeInitRequest;
import com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest;
import com.example.demo.protobuf.RecipeProto.RecipeResearchResponse;
import com.example.demo.protobuf.recipe.PlanetResponseFactory;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/planets")
@Transactional
public class PlanetController {

    private final PlanetService planetService;
    private final PlanetResponseFactory planetResponseFactory;

    @PostMapping("/init")
    public void init(@RequestBody RecipeInitRequest recipeInitRequest) {
        planetService.initRecipes(recipeInitRequest.getAmount());
    }

    @GetMapping("/find-all")
    public RecipeResearchResponse findAllRecipes() {
        List<Planet> univers = planetService.findRecipes();
        return planetResponseFactory.toRecipeResponse(univers);
    }

    @PostMapping("/remove-all")
    public void removeAllRecipes() {
        planetService.removeAllRecipes();
    }

    @PostMapping("/remove-single")
    public void removeRecipe(@RequestBody RecipeRemoveRequest request) {
        planetService.removeRecipe(request.getName());
    }
}
