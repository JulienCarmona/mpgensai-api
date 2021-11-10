package fr.mpgensai.api.repository.test;

import fr.mpgensai.api.core.model.Team;
import fr.mpgensai.api.core.model.User;
import fr.mpgensai.api.repository.ITeamRepository;
import fr.mpgensai.api.repository.IUserRepository;
import fr.mpgensai.api.repository.test.common.ConfigRepositoryUnitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class TeamRepositoryUnitTest extends ConfigRepositoryUnitTest<Team> {

    private static final String DUMMY_TEAM_MPG_TEAM_ID = "dummyValueMpgTeamId";

    @Autowired
    private ITeamRepository repository;

    @Override
    protected JpaRepository<Team, Long> getRepository() {
        return repository;
    }

    @Override
    protected Team createNewDummyEntity() {
        final Team newTeamEntity = Team.builder()
                .mpgTeamId(DUMMY_TEAM_MPG_TEAM_ID)
                .build();
        return newTeamEntity;
    }
}
