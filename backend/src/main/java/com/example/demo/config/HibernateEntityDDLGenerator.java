package com.example.demo.config;

import java.io.IOException;
import java.util.EnumSet;
import javax.persistence.spi.PersistenceUnitInfo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.hibernate.tool.schema.TargetType;

@Slf4j
public abstract class HibernateEntityDDLGenerator extends HibernateDDLGenerator {

	public void generateDDL() {
		try {
			doCreateMigration();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	private void doCreateMigration() throws IOException {
		PersistenceUnitInfo persistenceUnitInfo = getEntityManagerFactoryBean().getPersistenceUnitInfo();
		if (persistenceUnitInfo == null) {
			throw new IllegalStateException("The persistence unit is null");
		}

		String filename = getFilename("'entity_name'");
		writeMigrationToFile(filename, persistenceUnitInfo);
		checkFile(filename);
	}

	private void writeMigrationToFile(String filename, PersistenceUnitInfo persistenceUnitInfo) {
		StandardServiceRegistry serviceRegistry = getStandardServiceRegistry();
		MetadataSources metadataSources = new MetadataSources(new BootstrapServiceRegistryBuilder().build());

		persistenceUnitInfo
			.getManagedClassNames()
			.forEach(metadataSources::addAnnotatedClassName);

		Metadata metadata = metadataSources.buildMetadata(serviceRegistry);

		SchemaUpdate update = new SchemaUpdate(); // To create SchemaUpdate
		update.setFormat(true);
		update.setOutputFile(filename);
		update.setDelimiter(";");
		update.execute(EnumSet.of(TargetType.SCRIPT), metadata, serviceRegistry);
	}

}
