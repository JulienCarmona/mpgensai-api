package fr.mpgensai.api.service;

import fr.mpgensai.api.common.AbstractServiceIntegrationTest;
import fr.mpgensai.api.persistence.model.Joueur;
import fr.mpgensai.api.persistence.model.Ligue;
import fr.mpgensai.common.service.IRawService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LigueServiceIntegrationTest extends AbstractServiceIntegrationTest<Ligue> {

    @Autowired
    private ILigueService service;
    private final static String DUMMY_LIGUE_SHORT_ID = "testValueShortId";

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

    @AfterEach
    void cleanDataBase() {
        service.deleteByShortId(DUMMY_LIGUE_SHORT_ID);
    }

}
