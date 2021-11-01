package fr.mpgensai.api.service;

import fr.mpgensai.api.persistence.model.Joueur;
import fr.mpgensai.common.service.IRawService;
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

    @Override
    protected IRawService getApi() {
        return service;
    }

    @Override
    protected Joueur createNewEntity() {
        final Joueur newJoueurEntity = Joueur.builder()
                .nom("testNom")
                .prenom("testPrenom")
                .promo("2021")
                .users(new HashSet<>())
                .build();
        return newJoueurEntity;
    }

}
