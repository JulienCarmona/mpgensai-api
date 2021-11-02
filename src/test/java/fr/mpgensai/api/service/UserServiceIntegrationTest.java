package fr.mpgensai.api.service;

import fr.mpgensai.api.persistence.model.User;
import fr.mpgensai.api.common.AbstractServiceIntegrationTest;
import fr.mpgensai.common.service.IRawService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceIntegrationTest extends AbstractServiceIntegrationTest<User> {

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

    @AfterEach
    void cleanDataBase() {
        service.deleteByMpgUserId(DUMMY_USER_MPG_USER_ID);
    }


}
