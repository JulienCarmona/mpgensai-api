package fr.mpgensai.api.service;

import fr.mpgensai.api.core.model.Team;
import fr.mpgensai.api.service.common.ConfigServiceIntegrationTest;
import fr.mpgensai.api.service.common.IRawService;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamServiceIntegrationTest extends ConfigServiceIntegrationTest<Team> {

    private static final String DUMMY_TEAM_MPG_TEAM_ID = "dummyValueMpgTeamId";

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
    protected void cleanDataBaseFromPersistedTestEntities() {
        service.deleteByMpgTeamId(DUMMY_TEAM_MPG_TEAM_ID);
    }


}
