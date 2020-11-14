package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("auto-generate-ddl")
@Configuration(proxyBeanMethods = false)
public class EntityMigrationGeneratorConfiguration extends HibernateEntityDDLGenerator {}
