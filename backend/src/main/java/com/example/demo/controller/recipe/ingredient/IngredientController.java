package com.example.demo.controller.recipe.ingredient;

import com.example.demo.domain.recipe.ingredient.IngredientDefinitionLoader;
import com.example.demo.protobuf.IngredientProto.IngredientListResponse;
import com.example.demo.protobuf.IngredientProto.IngredientResponse;
import com.example.demo.protobuf.recipe.ingredient.IngredientResponseFactory;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientDefinitionLoader loader;
    private final IngredientResponseFactory ingredientResponseFactory;

    @GetMapping("/find-all")
    public IngredientListResponse finAll() throws IOException {
        return ingredientResponseFactory.toIngredientResponseList(loader.loadAll());
    }

    @GetMapping("/find-by-id")
    public IngredientResponse finById(@RequestParam String id) {
        return ingredientResponseFactory.toIngredientResponse(loader.loadById(id));
    }
}
