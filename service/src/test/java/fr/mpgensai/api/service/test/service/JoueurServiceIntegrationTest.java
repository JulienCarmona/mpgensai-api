package fr.mpgensai.api.service.test.service;

import fr.mpgensai.api.core.model.Joueur;
import fr.mpgensai.api.service.IJoueurService;
import fr.mpgensai.api.service.common.IRawService;
import fr.mpgensai.api.service.test.common.ConfigServiceIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class JoueurServiceIntegrationTest extends ConfigServiceIntegrationTest<Joueur> {

    private final static String DUMMY_JOUEUR_NAME = "dummyValueNom";
    private final static String DUMMY_JOUEUR_PRENOM = "dummyValuePrenom";
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
    public void cleanDataBaseFromPersistedTestEntities() {
        service.deleteByNomAndPrenom(DUMMY_JOUEUR_NAME, DUMMY_JOUEUR_PRENOM);
    }

}
