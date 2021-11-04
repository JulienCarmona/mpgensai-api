package fr.mpgensai.api.repository.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "fr.mpgensai.api.repository")
@PropertySource({ "classpath:persistence-${persistenceTarget:local}.properties" })
public class RepositoryConfig {
}
