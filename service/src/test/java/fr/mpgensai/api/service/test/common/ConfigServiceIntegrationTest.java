package fr.mpgensai.api.service.test.common;

import fr.mpgensai.api.core.common.IEntity;
import fr.mpgensai.api.core.spring.EntityConfig;
import fr.mpgensai.api.repository.spring.RepositoryConfig;
import fr.mpgensai.api.service.spring.ServiceConfig;
import fr.mpgensai.api.service.test.common.AbstractServiceIntegrationTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
@ContextConfiguration(classes = { ServiceConfig.class, RepositoryConfig.class, EntityConfig.class })
public abstract class ConfigServiceIntegrationTest<T extends IEntity> extends AbstractServiceIntegrationTest<T> {
}
