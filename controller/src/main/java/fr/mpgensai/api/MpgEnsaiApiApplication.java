package fr.mpgensai.api;

import fr.mpgensai.api.core.spring.EntityConfig;
import fr.mpgensai.api.repository.spring.RepositoryConfig;
import fr.mpgensai.api.service.spring.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"fr.mpgensai.api.controller"})
@Import({ServiceConfig.class, RepositoryConfig.class, EntityConfig.class})
public class MpgEnsaiApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpgEnsaiApiApplication.class, args);
	}

}

