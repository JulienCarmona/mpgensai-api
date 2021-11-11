package fr.mpgensai.api.dto;

import fr.mpgensai.api.core.model.Joueur;
import fr.mpgensai.api.core.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Mapper.class)
public class JoueurDtoUnitTest {

    private final static String DUMMY_JOUEUR_NOM = "dummyValueNom";
    private final static String DUMMY_JOUEUR_PRENOM = "dummyValuePrenom";
    private static final String DUMMY_JOUEUR_PROMO = "2021";

    private final String[] MPG_USER_ID_VALUES = new String[]{"testMpgUserId1", "testMpgUserId"};
    private final Set<String> MPG_USER_IDS = new HashSet<>(Arrays.asList(MPG_USER_ID_VALUES));

    @Autowired
    private Mapper mapper;

    @Test
    public void whenConvertPostEntityToPostDto_thenCorrect() {
        Joueur joueur = Joueur.builder()
                .nom(DUMMY_JOUEUR_NOM)
                .prenom(DUMMY_JOUEUR_PRENOM)
                .promo(DUMMY_JOUEUR_PROMO)
                .users(new HashSet<>())
                .build();
        Set<User> users = MPG_USER_IDS.stream()
                .map(mui -> User.builder().mpgUserId(mui).build())
                .collect(Collectors.toSet());
        joueur.addAllUser(users);

        JoueurDto joueurDto = mapper.toJoueurDto(joueur);
        assertThat(joueur.getNom()).isEqualTo(joueurDto.getNom());
        assertThat(joueur.getPrenom()).isEqualTo(joueurDto.getPrenom());
        assertThat(joueur.getPromo()).isEqualTo(joueurDto.getPromo());
        assertThat(MPG_USER_IDS).isEqualTo(joueurDto.getMpgUserIds());
    }

}
