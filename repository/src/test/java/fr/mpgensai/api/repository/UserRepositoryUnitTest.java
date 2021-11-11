package fr.mpgensai.api.repository;

import fr.mpgensai.api.core.model.User;
import fr.mpgensai.api.repository.common.ConfigRepositoryUnitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepositoryUnitTest extends ConfigRepositoryUnitTest<User> {

    private static final String DUMMY_USER_MPG_USER_ID = "dummyValueMpgUserId";

    @Autowired
    private IUserRepository repository;

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return repository;
    }

    @Override
    protected User createNewDummyEntity() {
        return User.builder()
                .mpgUserId(DUMMY_USER_MPG_USER_ID)
                .build();
    }
}
