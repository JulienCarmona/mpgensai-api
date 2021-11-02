package fr.mpgensai.api.service;

import fr.mpgensai.api.common.AbstractServiceIntegrationTest;
import fr.mpgensai.api.persistence.model.Joueur;
import fr.mpgensai.common.service.IRawService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JoueurServiceIntegrationTest extends AbstractServiceIntegrationTest<Joueur> {

    @Autowired
    private IJoueurService service;
    private final static String DUMMY_JOUEUR_NAME = "testNom";
    private final static String DUMMY_JOUEUR_PRENOM = "testPrenom";

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

    @AfterEach
    void cleanDataBase() {
        service.deleteByNomAndPrenom(DUMMY_JOUEUR_NAME, DUMMY_JOUEUR_PRENOM);
    }

}
