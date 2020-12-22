package com.example.demo.common.definition;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
public abstract class AbstractDefinitionLoader<
                T extends BaseDefinition, L extends BaseDefinitionList<T>>
        implements DefinitionLoader<T> {

    private final Class<T> definition;

    private final Class<L> definitionList;

    private List<T> cache;

    @PostConstruct
    private void init() throws IOException {
        loadAll();
    }

    @Override
    public List<T> loadAll() throws IOException {
        if (cache != null) {
            return cache;
        }

        String fileName = BaseDefinitionScanner.getJsonFileForType(definition);
        URL resource = getResourceOrThrowException(fileName);
        cache =
                new ArrayList<>(
                        new ObjectMapper()
                                .readValue(new File(resource.getFile()), definitionList)
                                .getDefinitions());

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
    public T loadById(String id) {
        return loadByFunction(definition -> id.equalsIgnoreCase(definition.getId()));
    }

    @Override
    public T loadByFunction(Function<T, Boolean> function) {
        return cache.stream().filter(function::apply).findFirst().orElseThrow();
    }
}
