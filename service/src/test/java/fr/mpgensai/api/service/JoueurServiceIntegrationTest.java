package fr.mpgensai.api.service;

import fr.mpgensai.api.core.model.Joueur;
import fr.mpgensai.api.service.common.ConfigServiceIntegrationTest;
import fr.mpgensai.api.service.common.IRawService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class JoueurServiceIntegrationTest extends ConfigServiceIntegrationTest<Joueur> {

    private final static String DUMMY_JOUEUR_NOM = "dummyValueNom";
    private final static String DUMMY_JOUEUR_PRENOM = "dummyValuePrenom";
    private static final String DUMMY_JOUEUR_PROMO = "2021";
    @Autowired
    private IJoueurService service;

    @Override
    protected IRawService getApi() {
        return service;
    }

    @Override
    protected Joueur createNewEntity() {
        final Joueur newJoueurEntity = Joueur.builder()
                .nom(DUMMY_JOUEUR_NOM)
                .prenom(DUMMY_JOUEUR_PRENOM)
                .promo(DUMMY_JOUEUR_PROMO)
                .users(new HashSet<>())
                .build();
        return newJoueurEntity;
    }

    @Override
    protected void cleanDataBaseFromPersistedTestEntities() {
        service.deleteByNomAndPrenom(DUMMY_JOUEUR_NOM, DUMMY_JOUEUR_PRENOM);
    }

}
