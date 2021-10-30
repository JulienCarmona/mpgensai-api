package fr.mpgensai.api.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({ "fr.mpgensai.api.persistence" })
@PropertySource({ "classpath:persistence-${persistenceTarget:local}.properties" })
public class ApiPersistenceJpaConfig {

    public ApiPersistenceJpaConfig() {
        super();
    }
}
