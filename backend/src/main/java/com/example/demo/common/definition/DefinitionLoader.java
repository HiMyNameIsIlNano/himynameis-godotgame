package com.example.demo.common.definition;

import java.io.IOException;
import java.util.List;

public interface DefinitionLoader<T> {

    List<T> loadAll() throws IOException;

    T loadById(String id);

}
