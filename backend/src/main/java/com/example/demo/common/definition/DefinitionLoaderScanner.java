package com.example.demo.common.definition;

import com.example.demo.common.DefinitionLoaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class DefinitionLoaderScanner extends DefinitionScanner implements ApplicationContextAware {

    private static DefinitionLoaderScanner _SELF;

    private ApplicationContext applicationContext;

    private final Map<Class<?>, Class<?>> DEFINITION_TO_LOADER = new HashMap<>();

    @PostConstruct
    void init() {
        _SELF = this;
        initDefinitionToLoaderMap();
    }

    public static DefinitionLoaderScanner unwrap() {
        return _SELF;
    }

    private Class<?> getLoaderForDefinition(Class<?> definition) {
        return DEFINITION_TO_LOADER.get(definition);
    }

    public BaseDefinition getDefinitionByIdForType(String id, Class<?> definition) {
        Object bean = applicationContext.getBean(getLoaderForDefinition(definition));
        if (bean instanceof DefinitionLoader) {
            DefinitionLoader<?> loader = (DefinitionLoader<?>) bean;
            return (BaseDefinition) loader.loadById(id);
        }

        return null;
    }

    private void initDefinitionToLoaderMap() {
        ClassPathScanningCandidateComponentProvider scanner = createLoaderForScanner();
        scanner.findCandidateComponents(BASE_PACKAGE)
                .forEach(this::handleDefinitionLoader);
    }

    private ClassPathScanningCandidateComponentProvider createLoaderForScanner() {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(DefinitionLoaderService.class));
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
        Class<?> loaderClass = Class.forName(loader.getBeanClassName());
        DefinitionLoaderService annotation = loaderClass.getAnnotation(DefinitionLoaderService.class);

        if (annotation != null) {
            DEFINITION_TO_LOADER.putIfAbsent(annotation.forDefinition(), loaderClass);
        } else {
            handleMissingLoaderForValue(loaderClass);
        }
    }

    private void handleMissingLoaderForValue(Class<?> clazz) {
        String missingAnnotationException = String.format("Missing LoaderFor annotation in %s", clazz.getName());
        printErrorAndExit(new IllegalArgumentException(missingAnnotationException));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
