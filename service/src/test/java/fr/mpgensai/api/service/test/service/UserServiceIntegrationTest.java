package fr.mpgensai.api.service.test.service;

import fr.mpgensai.api.core.model.User;
import fr.mpgensai.api.core.spring.EntityConfig;
import fr.mpgensai.api.repository.spring.RepositoryConfig;
import fr.mpgensai.api.service.IUserService;
import fr.mpgensai.api.service.common.IRawService;
import fr.mpgensai.api.service.spring.ServiceConfig;
import fr.mpgensai.api.service.test.common.AbstractRawServiceIntegrationTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class UserServiceIntegrationTest extends ConfigServiceIntegrationTest<User> {

    private static final String DUMMY_USER_MPG_USER_ID = "testValueMpgUserId";

    @Autowired
    private IUserService service;

    @Override
    protected IRawService getApi() {
        return service;
    }

    @Override
    protected User createNewEntity() {
        final User newUserEntity = User.builder()
                .mpgUserId(DUMMY_USER_MPG_USER_ID)
                .build();
        return newUserEntity;
    }


    @Override
    protected void cleanDataBaseFromPersistedEntities() {
        service.deleteByMpgUserId(DUMMY_USER_MPG_USER_ID);
    }


}
