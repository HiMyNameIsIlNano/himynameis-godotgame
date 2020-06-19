package com.example.demo.common.definition;

public abstract class DefinitionScanner {

    static final String BASE_PACKAGE = "com.example.demo.domain";

    static void printErrorAndExit(Exception e) {
        System.err.println("***************************");
        System.err.println(e.getMessage());
        System.err.println("***************************");
        System.exit(1);
    }

}
