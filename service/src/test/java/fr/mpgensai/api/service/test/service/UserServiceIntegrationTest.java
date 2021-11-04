package fr.mpgensai.api.service.test.service;

import fr.mpgensai.api.core.model.User;
import fr.mpgensai.api.service.IUserService;
import fr.mpgensai.api.service.common.IRawService;
import fr.mpgensai.api.service.test.common.ConfigServiceIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceIntegrationTest extends ConfigServiceIntegrationTest<User> {

    private static final String DUMMY_USER_MPG_USER_ID = "dummyValueMpgUserId";

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
    protected void cleanDataBaseFromPersistedTestEntities() {
        service.deleteByMpgUserId(DUMMY_USER_MPG_USER_ID);
    }


}
