package com.example.demo.common.definition;

public class DefinitionScanner {

    static final String BASE_PACKAGE = "com.example.demo.domain";

    protected static void printErrorAndExit(Exception e) {
        System.err.println(e.getMessage());
        System.exit(1);
    }

}
