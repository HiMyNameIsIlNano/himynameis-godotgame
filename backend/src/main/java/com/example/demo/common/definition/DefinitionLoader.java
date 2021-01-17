package com.example.demo.common.definition;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public interface DefinitionLoader<T> {

    List<T> loadAll() throws IOException;

    T loadById(String id);

    T loadByFunction(Function<T, Boolean> function);
}
