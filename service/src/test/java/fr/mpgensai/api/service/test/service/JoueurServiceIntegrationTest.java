package fr.mpgensai.api.service.test.service;

import fr.mpgensai.api.core.model.Joueur;
import fr.mpgensai.api.core.spring.EntityConfig;
import fr.mpgensai.api.repository.spring.RepositoryConfig;
import fr.mpgensai.api.service.IJoueurService;
import fr.mpgensai.api.service.common.IRawService;
import fr.mpgensai.api.service.spring.ServiceConfig;
import fr.mpgensai.api.service.test.common.AbstractRawServiceIntegrationTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;

@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
@ContextConfiguration(classes = {ServiceConfig.class, RepositoryConfig.class, EntityConfig.class})
public class JoueurServiceIntegrationTest extends AbstractRawServiceIntegrationTest<Joueur> {

    private final static String DUMMY_JOUEUR_NAME = "testNom";
    private final static String DUMMY_JOUEUR_PRENOM = "testPrenom";
    @Autowired
    private IJoueurService service;

    @Override
    protected IRawService getApi() {
        return service;
    }

    @Override
    protected Joueur createNewEntity() {
        final Joueur newJoueurEntity = Joueur.builder()
                .nom(DUMMY_JOUEUR_NAME)
                .prenom(DUMMY_JOUEUR_PRENOM)
                .promo("2021")
                .users(new HashSet<>())
                .build();
        return newJoueurEntity;
    }

    @Override
    public void cleanDataBaseFromPersistedEntities() {
        service.deleteByNomAndPrenom(DUMMY_JOUEUR_NAME, DUMMY_JOUEUR_PRENOM);
    }

}
