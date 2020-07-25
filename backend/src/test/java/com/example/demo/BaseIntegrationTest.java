package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
@DirtiesContext
@ActiveProfiles({"integration-test"})
public abstract class BaseIntegrationTest {

    @LocalServerPort private int port;

    public int getPort() {
        return port;
    }
}
