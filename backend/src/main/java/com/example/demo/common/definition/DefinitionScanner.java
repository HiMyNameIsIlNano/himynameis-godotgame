package com.example.demo.common.definition;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class DefinitionScanner implements ApplicationContextAware {

    static final String BASE_PACKAGE = "com.example.demo.domain";

    protected ApplicationContext applicationContext;

    protected void printErrorAndExit(Exception e) {
        System.err.println(e.getMessage());
        System.exit(1);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
