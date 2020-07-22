package com.example.demo;

public class IntegrationTestUtils {

    private static final String BASE_URL = "http://localhost:%d";

    public enum RecipeUrlEnum {

        INIT("recipes/init"),
        FIND_ALL("recipes/find-all"),
        REMOVE_ALL("recipes/remove-all"),
        REMOVE_SINGLE("recipes/remove-single");

        private String requestMappingPath;

        RecipeUrlEnum(String requestMappingPath) {
            this.requestMappingPath = requestMappingPath;
        }

        public static final String toUrl(RecipeUrlEnum urlEnum, int port) {
            return String.format(BASE_URL + '/' + urlEnum.requestMappingPath, port);
        }
    }
}
