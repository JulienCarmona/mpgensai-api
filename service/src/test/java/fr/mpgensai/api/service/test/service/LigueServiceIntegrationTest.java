package fr.mpgensai.api.service.test.service;

import fr.mpgensai.api.core.model.Ligue;
import fr.mpgensai.api.core.spring.EntityConfig;
import fr.mpgensai.api.repository.spring.RepositoryConfig;
import fr.mpgensai.api.service.ILigueService;
import fr.mpgensai.api.service.common.IRawService;
import fr.mpgensai.api.service.spring.ServiceConfig;
import fr.mpgensai.api.service.test.common.AbstractRawServiceIntegrationTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class LigueServiceIntegrationTest extends ConfigServiceIntegrationTest<Ligue> {

    private final static String DUMMY_LIGUE_SHORT_ID = "testValueShortId";
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
        System.out.println(newLigueEntity);
        return newLigueEntity;
    }


    @Override
    protected void cleanDataBaseFromPersistedEntities() {
        service.deleteByShortId(DUMMY_LIGUE_SHORT_ID);
    }


}
