package com.example.demo.domain.planet.mission;

import com.example.demo.common.DefinitionLoaderService;
import com.example.demo.common.definition.BaseDefinitionScanner;
import com.example.demo.common.definition.DefinitionLoader;
import com.example.demo.domain.planet.mission.definition.MissionDefinition;
import com.example.demo.domain.planet.mission.definition.MissionDefinitionList;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;

@DefinitionLoaderService(forDefinition = MissionDefinition.class)
public class MissionDefinitionLoader implements DefinitionLoader<MissionDefinition> {

    private List<MissionDefinition> cache = null;

    @PostConstruct
    void init() throws IOException {
        loadAll();
    }

    @Override
    public List<MissionDefinition> loadAll() throws IOException {
        if (cache != null) {
            return cache;
        }

        String fileName = BaseDefinitionScanner.getJsonFileForType(MissionDefinition.class);
        URL resource = getResourceOrThrowException(fileName);
        Collection<MissionDefinition> definitions =
                new ObjectMapper()
                        .readValue(new File(resource.getFile()), MissionDefinitionList.class)
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
    public MissionDefinition loadById(String id) {
        return cache.stream()
                .filter(ingredient -> id.equalsIgnoreCase(ingredient.getId()))
                .findFirst()
                .orElseThrow();
    }
}
