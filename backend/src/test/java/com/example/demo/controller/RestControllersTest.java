package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.demo.BaseIntegrationTest;
import com.example.demo.controller.planet.PlanetController;
import com.example.demo.domain.planet.PlanetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;

class RestControllersTest extends BaseIntegrationTest {

    @Autowired PlanetService planetService;

    private final WebApplicationContextRunner contextRunner =
            new WebApplicationContextRunner().withBean(PlanetController.class);

    @Test
    void testServiceIsInContextWhileControllerIsNotCreated() {
        contextRunner.run(
                context ->
                        assertAll(
                                () -> assertThat(planetService).isNotNull(),
                                () -> assertThat(context).doesNotHaveBean(PlanetController.class)));
    }
}
