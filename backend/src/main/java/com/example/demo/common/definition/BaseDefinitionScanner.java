package com.example.demo.common.definition;

import java.util.HashMap;
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
public class BaseDefinitionScanner extends DefinitionScanner {

    private final String FILE_EXT = "json";
    private final Map<Class<?>, String> DEFINITION_TO_FILE = new HashMap<>();
    private final Map<String, Class<?>> DISCRIMINATOR_TO_DEFINITION = new HashMap<>();

    static {
        initDefinitionToFileMap();
    }

    public String getJsonFileForType(Class<? extends BaseDefinition> clazz) {
        return DEFINITION_TO_FILE.get(clazz);
    }

    public Class<?> getDefinitionFromDiscriminatorValue(String discriminatorValue) {
        return DISCRIMINATOR_TO_DEFINITION.get(discriminatorValue);
    }

    private void initDefinitionToFileMap() {
        ClassPathScanningCandidateComponentProvider scanner = createDiscriminatorValueScanner();
        scanner.findCandidateComponents(PACKAGE_TO_SCAN)
                .forEach(BaseDefinitionScanner::handleBaseDefinitions);
    }

    private ClassPathScanningCandidateComponentProvider createDiscriminatorValueScanner() {
        ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(DiscriminatorValue.class));
        provider.addIncludeFilter(new AssignableTypeFilter(BaseDefinition.class));
        return provider;
    }

    private void handleBaseDefinitions(BeanDefinition beanDef) {
        try {
            addDefinitionFileToMap(beanDef);
        } catch (ClassNotFoundException e) {
            printErrorAndExit(e);
        }
    }

    private void addDefinitionFileToMap(BeanDefinition beanDef) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(beanDef.getBeanClassName());
        DiscriminatorValue discriminatorValue = clazz.getAnnotation(DiscriminatorValue.class);
        if (discriminatorValue != null) {
            DEFINITION_TO_FILE.putIfAbsent(clazz, discriminatorValue.value() + "." + FILE_EXT);
            DISCRIMINATOR_TO_DEFINITION.putIfAbsent(discriminatorValue.value(), clazz);
        } else {
            handleMissingDiscriminatorAnnotation(clazz);
        }
    }

    private void handleMissingDiscriminatorAnnotation(Class<?> clazz) {
        String missingAnnotationException =
                String.format("Missing DiscriminatorValue annotation in %s", clazz.getName());
        printErrorAndExit(new IllegalArgumentException(missingAnnotationException));
    }
}
