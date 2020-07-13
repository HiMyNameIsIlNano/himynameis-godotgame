package com.example.demo.common;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class EndpointGenerator {

    static final String PACKAGE_TO_SCAN = "com.example.demo.controller";
    private static Map<Class<?>, List<String>> classToRequests = new HashMap<>();

    private static final List<Class> ANNOTATIONS = List.of(PostMapping.class, GetMapping.class);

    public static void main(String[] args) {
        scanRestControllers();
    }

    private static void scanRestControllers() {
        ClassPathScanningCandidateComponentProvider restControllerScanner =
                createRestControllerScanner();
        restControllerScanner
                .findCandidateComponents(PACKAGE_TO_SCAN)
                .forEach(EndpointGenerator::handleRestController);

        logInfo();
    }

    private static void logInfo() {
        classToRequests
                .entrySet()
                .forEach(
                        classToRequest ->
                                System.out.println(
                                        "Class: "
                                                + classToRequest.getKey()
                                                + ", requests: "
                                                + toCommeSeparatedString(
                                                        classToRequest.getValue())));
    }

    private static String toCommeSeparatedString(List<String> classToRequest) {
        return String.join(", ", classToRequest);
    }

    private static void handleRestController(BeanDefinition restControllerBean) {
        try {
            handleRestControllers(restControllerBean);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static ClassPathScanningCandidateComponentProvider createRestControllerScanner() {
        ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(RestController.class));
        return provider;
    }

    private static void handleRestControllers(BeanDefinition restControllerBean)
            throws ClassNotFoundException {
        Class<?> clazz = Class.forName(restControllerBean.getBeanClassName());

        List<String> requestUrl = toRequestUrl(clazz);

        classToRequests.putIfAbsent(clazz, requestUrl);
    }

    private static List<String> toRequestUrl(Class<?> clazz) {
        String baseUrl =
                Objects.requireNonNull(AnnotationUtils.getAnnotation(clazz, RequestMapping.class))
                        .value()[0];

        return Arrays.stream(clazz.getMethods())
                .filter(EndpointGenerator::isHttpRequest)
                .map(method -> toRequestUrl(baseUrl, method))
                .collect(Collectors.toList());
    }

    private static boolean isHttpRequest(Method method) {
        return method.getAnnotation(PostMapping.class) != null
                || method.getAnnotation(GetMapping.class) != null;
    }

    private static String toRequestUrl(String baseUrl, Method method) {
        PostMapping postMapping = AnnotationUtils.getAnnotation(method, PostMapping.class);
        if (postMapping != null) {
            return baseUrl + postMapping.value()[0];
        }

        GetMapping getMapping = AnnotationUtils.getAnnotation(method, GetMapping.class);
        if (getMapping != null) {
            return baseUrl + getMapping.value()[0];
        }

        throw new IllegalArgumentException(
                "Method " + method.getName() + "is neither a POST nor a GET");
    }
}
