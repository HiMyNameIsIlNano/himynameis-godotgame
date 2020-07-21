package com.example.demo;

public class IntegrationTestUtils {

    private static final String BASE_URL = "http://localhost:%d";

    public enum RecipeUrlEnum {

        INIT("recipes/init"),
        FIND_ALL("recipes/find-all"),
        REMOVE_ALL("recipes/remove-all"),
        REMOVE_SINGLE("recipes/remove-single");

        private String url;

        RecipeUrlEnum(String url) {
            this.url = url;
        }

        public static final String toUrl(RecipeUrlEnum url, int port) {
            return String.format(BASE_URL + '/' + url, port);
        }
    }
}
