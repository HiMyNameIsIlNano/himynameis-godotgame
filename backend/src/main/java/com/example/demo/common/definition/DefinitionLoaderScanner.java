package com.example.demo.common.definition;

import com.example.demo.common.LoaderFor;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@UtilityClass
public class DefinitionLoaderScanner extends DefinitionScanner {

    private final Map<Class<?>, Class<?>> DEFINITION_TO_LOADER = new HashMap<>();

    static {
        initDefinitionToLoaderMap();
    }

    public BaseDefinition getDefinitionByIdForType(String id, Class<?> definition) {
        if (DefinitionLoader.class.isAssignableFrom(DEFINITION_TO_LOADER.get(definition))) {
            DefinitionLoader loader = DefinitionLoader.class.cast(DEFINITION_TO_LOADER.get(definition));
            return (BaseDefinition) loader.loadById(id);
        }

        return null;
    }

    private void initDefinitionToLoaderMap() {
        ClassPathScanningCandidateComponentProvider scanner = createLoaderForScanner();
        scanner.findCandidateComponents(BASE_PACKAGE)
                .forEach(DefinitionLoaderScanner::handleDefinitionLoader);
    }

    private ClassPathScanningCandidateComponentProvider createLoaderForScanner() {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(LoaderFor.class));
        provider.addIncludeFilter(new AssignableTypeFilter(DefinitionLoader.class));
        return provider;
    }

    private void handleDefinitionLoader(BeanDefinition loader) {
        try {
            addLoaderToMap(loader);
        } catch (ClassNotFoundException e) {
            printErrorAndExit(e);
        }
    }

    private void addLoaderToMap(BeanDefinition loader) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(loader.getBeanClassName());
        LoaderFor annotation = clazz.getAnnotation(LoaderFor.class);
        if (annotation != null) {
            DEFINITION_TO_LOADER.putIfAbsent(annotation.definition(), clazz);
        } else {
            handleMissingLoaderForValue(clazz);
        }
    }

    private void handleMissingLoaderForValue(Class<?> clazz) {
        String missingAnnotationException = String.format("Missing LoaderFor annotation in %s", clazz.getName());
        printErrorAndExit(new IllegalArgumentException(missingAnnotationException));
    }

}
