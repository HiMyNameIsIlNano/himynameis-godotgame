package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
@DirtiesContext
@ActiveProfiles({"embedded-db"}) // This activates the bootstrap-embedded-db.properties
@Testcontainers
public abstract class BaseIntegrationTest {

    @LocalServerPort private int port;

    public int getPort() {
        return port;
    }
}
