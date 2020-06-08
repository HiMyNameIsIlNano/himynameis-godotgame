package com.example.demo.domain.recipe.ingredient;

import com.example.demo.common.definition.BaseDefinitionScanner;
import com.example.demo.common.definition.DefinitionLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class IngredientDefinitionLoader implements DefinitionLoader<IngredientDefinitionList, IngredientDefinition> {

	private IngredientDefinitionList cache = null;

	@PostConstruct
	void init() throws IOException {
		loadAll();
	}

	@Override
	public IngredientDefinitionList loadAll() throws IOException {
		if (cache != null) {
			return cache;
		}

		String fileName = BaseDefinitionScanner.getJsonFileForType(IngredientDefinitionList.class);
		URL resource = getResourceOrThrowException(fileName);
		cache = new ObjectMapper().readValue(new File(resource.getFile()), IngredientDefinitionList.class);

		return cache;
	}

	private URL getResourceOrThrowException(String fileName) throws FileNotFoundException {
		URL resource = getClass().getClassLoader().getResource(getResourcePath(fileName));
		if (resource == null) {
			throw new FileNotFoundException(fileName + "was not found");
		}

		return resource;
	}

	private String getResourcePath(String fileName) {
		return "json/" + fileName;
	}

	@Override
	public IngredientDefinition loadById(String id) {
		return cache.getIngredients().stream()
			.filter(ingredient -> id.equalsIgnoreCase(ingredient.getId()))
			.findFirst()
			.orElseThrow();
	}

}
