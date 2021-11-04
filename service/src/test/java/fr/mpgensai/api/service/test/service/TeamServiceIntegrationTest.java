package fr.mpgensai.api.service.test.service;

import fr.mpgensai.api.core.model.Team;
import fr.mpgensai.api.core.spring.EntityConfig;
import fr.mpgensai.api.repository.spring.RepositoryConfig;
import fr.mpgensai.api.service.ITeamService;
import fr.mpgensai.api.service.common.IRawService;
import fr.mpgensai.api.service.spring.ServiceConfig;
import fr.mpgensai.api.service.test.common.AbstractRawServiceIntegrationTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
@ContextConfiguration(classes = {ServiceConfig.class, RepositoryConfig.class, EntityConfig.class})
public class TeamServiceIntegrationTest extends AbstractRawServiceIntegrationTest<Team> {

    private static final String DUMMY_TEAM_MPG_TEAM_ID = "testValueMpgTeamId";

    @Autowired
    private ITeamService service;

    @Override
    protected IRawService getApi() {
        return service;
    }

    @Override
    protected Team createNewEntity() {
        final Team newTeamEntity = Team.builder()
                .mpgTeamId(DUMMY_TEAM_MPG_TEAM_ID)
                .build();
        return newTeamEntity;
    }

    @Override
    protected void cleanDataBaseFromPersistedEntities() {
        service.deleteByMpgTeamId(DUMMY_TEAM_MPG_TEAM_ID);
    }


}
