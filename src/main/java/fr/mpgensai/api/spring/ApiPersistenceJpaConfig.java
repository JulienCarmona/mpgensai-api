package fr.mpgensai.api.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource({ "classpath:persistence-${persistenceTarget:local}.properties" })
@EnableJpaRepositories(basePackages = "fr.mpgensai.api.persistence.dao")
public class ApiPersistenceJpaConfig {

    public ApiPersistenceJpaConfig() {
        super();
    }
}
