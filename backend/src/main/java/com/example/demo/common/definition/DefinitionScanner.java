package com.example.demo.common.definition;

public class DefinitionScanner {

    static final String PACKAGE_TO_SCAN = "com.example.demo.domain";

    protected static void printErrorAndExit(Exception e) {
        System.err.println(e.getMessage());
        System.exit(1);
    }
}
