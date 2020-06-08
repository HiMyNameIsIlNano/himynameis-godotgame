package com.example.demo.config;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class FlywayMigrationConfiguration {

	private final ObjectProvider<EntityMigrationGeneratorConfiguration> entityMigrationGeneratorConfiguration;

	@Bean
	public FlywayMigrationStrategy flywayMigrationStrategy() {
		return this::migrate;
	}

	protected void migrate(Flyway flyway) {
		flyway.migrate();
		entityMigrationGeneratorConfiguration.ifAvailable(HibernateEntityDDLGenerator::generateDDL);
	}

}
