package fr.mpgensai.api.repository.common;

import fr.mpgensai.api.core.common.IEntity;
import fr.mpgensai.api.core.spring.EntityConfig;
import fr.mpgensai.api.repository.spring.RepositoryConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
@ContextConfiguration(classes = {RepositoryConfig.class, EntityConfig.class})
@TestPropertySource(locations = {"classpath:persistence-h2.properties"})
public abstract class ConfigRepositoryUnitTest<T extends IEntity> extends AbstractRepositoryUnitTest<T>{
}
