package com.example.demo;

public class IntegrationTestUtils {

    private static final String BASE_URL = "http://localhost:%d";

    public enum PlanetUrlEnum {
        INIT("planets/init"),
        FIND_ALL("planets/find-all"),
        REMOVE_ALL("planets/remove-all"),
        REMOVE_SINGLE("planets/remove-single");

        private String requestMappingPath;

        PlanetUrlEnum(String requestMappingPath) {
            this.requestMappingPath = requestMappingPath;
        }

        public static final String toUrl(PlanetUrlEnum urlEnum, int port) {
            return String.format(BASE_URL + '/' + urlEnum.requestMappingPath, port);
        }
    }
}
