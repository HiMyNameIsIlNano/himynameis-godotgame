package com.example.demo.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.util.FileCopyUtils;

public abstract class HibernateDDLGenerator {

    @Autowired @Getter private LocalContainerEntityManagerFactoryBean entityManagerFactoryBean;

    @Value("${spring.flyway.sql-migration-prefix:V}")
    private String flywayPrefix;

    @Value("${spring.flyway.sql-migration-separator:_}")
    private String migrationSeparator;

    @Value("${spring.flyway.sql-migration-suffixes:.sql}")
    private String migrationSuffix;

    @Value("${demo.migration.default-output-folder}")
    private String migrationOutputFolder;

    StandardServiceRegistry getStandardServiceRegistry() {
        SessionFactory sessionFactory =
                (SessionFactory) entityManagerFactoryBean.getNativeEntityManagerFactory();
        return sessionFactory.getSessionFactoryOptions().getServiceRegistry();
    }

    void checkFile(String filename) throws IOException {
        File file = new File(filename);
        if (file.exists() && file.length() > 0) {
            String migration = FileCopyUtils.copyToString(new FileReader(file));
            printErrorAndExit(file, migration);
        } else if (file.exists()) {
            Files.delete(file.toPath());
        }
    }

    void printErrorAndExit(File file, String migration) {
        System.err.println(migration);
        System.err.println(file.getAbsolutePath());
        System.exit(1);
    }

    String getFilename(String suffix) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "'" + flywayPrefix + "'uuuu.MM.dd_HH.mm.ss" + migrationSeparator + suffix);

        String timestamp = formatter.format(LocalDateTime.now());
        return migrationOutputFolder + timestamp + migrationSuffix;
    }
}
