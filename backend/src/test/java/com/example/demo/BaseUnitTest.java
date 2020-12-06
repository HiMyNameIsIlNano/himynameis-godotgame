package com.example.demo;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles({"no-embedded-db"}) // This activates the bootstrap-no-embedded-db.properties
public abstract class BaseUnitTest {}
