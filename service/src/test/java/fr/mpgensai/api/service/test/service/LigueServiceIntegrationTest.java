package fr.mpgensai.api.service.test.service;

import fr.mpgensai.api.core.model.Ligue;
import fr.mpgensai.api.service.ILigueService;
import fr.mpgensai.api.service.common.IRawService;
import fr.mpgensai.api.service.test.common.ConfigServiceIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;

public class LigueServiceIntegrationTest extends ConfigServiceIntegrationTest<Ligue> {

    private final static String DUMMY_LIGUE_SHORT_ID = "dummyValueShortId";
    @Autowired
    private ILigueService service;

    @Override
    protected IRawService getApi() {
        return service;
    }

    @Override
    protected Ligue createNewEntity() {
        final Ligue newLigueEntity = Ligue.builder()
                .shortId(DUMMY_LIGUE_SHORT_ID)
                .saison(1)
                .division(1)
                .poule("A")
                .build();
        return newLigueEntity;
    }


    @Override
    protected void cleanDataBaseFromPersistedTestEntities() {
        service.deleteByShortId(DUMMY_LIGUE_SHORT_ID);
    }


}
