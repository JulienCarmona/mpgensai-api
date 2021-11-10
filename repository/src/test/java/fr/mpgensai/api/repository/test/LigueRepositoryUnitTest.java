package fr.mpgensai.api.repository.test;

import fr.mpgensai.api.core.model.Ligue;
import fr.mpgensai.api.repository.ILigueRepository;
import fr.mpgensai.api.repository.test.common.ConfigRepositoryUnitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class LigueRepositoryUnitTest extends ConfigRepositoryUnitTest<Ligue> {

    private final static String DUMMY_LIGUE_SHORT_ID = "dummyValueShortId";

    @Autowired
    private ILigueRepository repository;

    @Override
    protected JpaRepository<Ligue, Long> getRepository() {
        return repository;
    }

    @Override
    protected Ligue createNewDummyEntity() {
        final Ligue newLigueEntity = Ligue.builder()
                .shortId(DUMMY_LIGUE_SHORT_ID)
                .saison(1)
                .division(1)
                .poule("A")
                .build();
        return newLigueEntity;
    }
}
