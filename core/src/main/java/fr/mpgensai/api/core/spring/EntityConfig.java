package fr.mpgensai.api.core.spring;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "fr.mpgensai.api.core")
public class EntityConfig {
}
