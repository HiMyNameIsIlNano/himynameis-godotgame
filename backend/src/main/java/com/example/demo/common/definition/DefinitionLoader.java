package com.example.demo.common.definition;

import java.io.IOException;

public interface DefinitionLoader<T, S> {

	T loadAll() throws IOException;

	S loadById(String id) throws IOException;

}
