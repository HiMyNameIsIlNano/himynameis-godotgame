package com.example.demo.domain.recipe.ingredient;

import com.example.demo.common.DefinitionLoaderService;
import com.example.demo.common.definition.BaseDefinitionScanner;
import com.example.demo.common.definition.DefinitionLoader;
import com.example.demo.domain.recipe.ingredient.definition.IngredientDefinition;
import com.example.demo.domain.recipe.ingredient.definition.IngredientDefinitionList;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@DefinitionLoaderService(forDefinition = IngredientDefinition.class)
public class IngredientDefinitionLoader implements DefinitionLoader<IngredientDefinition> {

    private List<IngredientDefinition> cache = null;

    @PostConstruct
    void init() throws IOException {
        loadAll();
    }

    @Override
    public List<IngredientDefinition> loadAll() throws IOException {
        if (cache != null) {
            return cache;
        }

        String fileName = BaseDefinitionScanner.getJsonFileForType(IngredientDefinition.class);
        URL resource = getResourceOrThrowException(fileName);
        Collection<IngredientDefinition> definitions = new ObjectMapper()
                .readValue(new File(resource.getFile()), IngredientDefinitionList.class)
                .getDefinitions();

        cache = new ArrayList<>(definitions);
        return cache;
    }

    private URL getResourceOrThrowException(String fileName) throws FileNotFoundException {
        URL resource = getClass().getClassLoader().getResource(getResourcePath(fileName));
        if (resource == null) {
            throw new FileNotFoundException(fileName + " was not found");
        }

        return resource;
    }

    private String getResourcePath(String fileName) {
        return "json/" + fileName;
    }

    @Override
    public IngredientDefinition loadById(String id) {
        return cache.stream()
                .filter(ingredient -> id.equalsIgnoreCase(ingredient.getId()))
                .findFirst()
                .orElseThrow();
    }

}
