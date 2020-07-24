package com.example.demo;

import com.example.demo.configuration.GrpcIntegrationTestConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
@SpringJUnitConfig(classes = {GrpcIntegrationTestConfiguration.class})
@DirtiesContext
@ActiveProfiles("integration-test")
public abstract class BaseGrpcIntegrationTest {

    @LocalServerPort private int port;
}
