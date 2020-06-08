package com.example.demo.common.definition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.DiscriminatorValue;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;

@Slf4j
@UtilityClass
public class BaseDefinitionScanner {

	private final String FILE_EXT = "json";
	private final String BASE_PACKAGE = "com.example.demo.domain";
	private final List<Class<?>> ENUM_DEFINITIONS = List.of(BaseDefinition.class);
	private final Map<Class<?>, String> DEFINITION_TO_FILE = new HashMap<>();

	public String getJsonFileForType(Class<?> clazz) {
		return getDefinitionToFile().get(clazz);
	}

	private Map<Class<?>, String> getDefinitionToFile() {
		ClassPathScanningCandidateComponentProvider scanner = createDiscriminatorValueScanner();
		scanner.findCandidateComponents(BASE_PACKAGE)
			.forEach(BaseDefinitionScanner::handleBaseDefinitions);

		return DEFINITION_TO_FILE;
	}

	private ClassPathScanningCandidateComponentProvider createDiscriminatorValueScanner() {
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
		provider.addIncludeFilter(new AnnotationTypeFilter(DiscriminatorValue.class));
		ENUM_DEFINITIONS.forEach(scannedClass -> provider.addIncludeFilter(new AssignableTypeFilter(scannedClass)));
		return provider;
	}

	private void handleBaseDefinitions(BeanDefinition beanDef) {
		try {
			addClassToMap(beanDef);
		} catch (ClassNotFoundException e) {
			printErrorAndExit(e);
		}
	}

	private void addClassToMap(BeanDefinition beanDef) throws ClassNotFoundException {
		Class<?> clazz = Class.forName(beanDef.getBeanClassName());
		DiscriminatorValue discriminatorValue = clazz.getAnnotation(DiscriminatorValue.class);
		if (discriminatorValue != null) {
			DEFINITION_TO_FILE.putIfAbsent(clazz, discriminatorValue.value() + "." + FILE_EXT);
		} else {
			handleMissingDiscriminatorValue(clazz);
		}
	}

	private void handleMissingDiscriminatorValue(Class<?> clazz) {
		String missingAnnotationException = String.format("Missing DiscriminatorValue annotation in %s", clazz.getName());
		printErrorAndExit(new IllegalArgumentException(missingAnnotationException));
	}

	@SuppressWarnings({"squid:S106", "squid:S1192"})
	private void printErrorAndExit(Exception e) {
		System.err.println("***************************");
		System.err.println(e.getMessage());
		System.err.println("***************************");
		System.exit(1);
	}

}
