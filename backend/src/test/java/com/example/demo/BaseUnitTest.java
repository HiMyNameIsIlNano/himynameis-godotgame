package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = DemoApplication.class)
@DirtiesContext
@ActiveProfiles({"no-embedded-db"}) // This activates the bootstrap-no-embedded-db.properties
public abstract class BaseUnitTest {}
