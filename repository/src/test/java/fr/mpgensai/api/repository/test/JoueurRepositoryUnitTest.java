package fr.mpgensai.api.repository.test;

import fr.mpgensai.api.core.model.Joueur;
import fr.mpgensai.api.core.model.User;
import fr.mpgensai.api.repository.IJoueurRepository;
import fr.mpgensai.api.repository.IUserRepository;
import fr.mpgensai.api.repository.test.common.ConfigRepositoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class JoueurRepositoryUnitTest extends ConfigRepositoryTest<Joueur> {

    private final static String DUMMY_JOUEUR_NOM = "dummyValueNom";
    private final static String DUMMY_JOUEUR_PRENOM = "dummyValuePrenom";
    private static final String DUMMY_JOUEUR_PROMO = "2021";

    private static final String DUMMY_USER_MPG_USER_ID = "dummyValueMpgUserId";

    @Autowired
    IJoueurRepository repository;

    @Autowired
    IUserRepository userRepository;

    @Test
    void contextLoad() {
    }

    // tests : add
    @Test
    public void whenAddingJoueurWithUsers_thenUsersShouldAlsoBePersisted() {
        Joueur joueur = createNewDummyJoueur();
        joueur.addUser(User.builder().mpgUserId(DUMMY_USER_MPG_USER_ID).build());
        joueur.addUser(User.builder().mpgUserId(DUMMY_USER_MPG_USER_ID).build());
        repository.save(joueur);
        assertThat(userRepository.count()).isEqualTo(2);
        cleanDataBase();
    }

    // tests : deleteById
    @Test
    public void givenOnlyOneJoueur_whenDeleteByIdFromRepository_thenRepositoryShouldBeEmpty() {
        Joueur persistedJoueur = persistNewDummyJoueur();
        repository.deleteById(persistedJoueur.getId());
        assertThat(repository.count()).isEqualTo(0);
    }

    @Test
    public void givenJoueurIsDeleted_whenFindByIdAndTryToGetJoueur_thenNoSuchElementExceptionIsThrown() {
        Joueur persistedJoueur = persistNewDummyJoueur();
        repository.deleteById(persistedJoueur.getId());
        assertThrows(NoSuchElementException.class,
                () -> repository.findById(persistedJoueur.getId()).get(),
                "NoSuchElementException error was expected");
    }

    // tests : deleteAll
    @Test
    public void givenJoueurs_whenDeleteAllFromRepository_thenRepositoryShouldBeEmpty() {
        Joueur persistedJoueur1 = persistNewDummyJoueur();
        Joueur persistedJoueur2 = persistNewDummyJoueur();
        Joueur persistedJoueur3 = persistNewDummyJoueur();
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }

    @Test
    public void whenDeletingJoueur_thenUsersShouldAlsoBeDeleted() {
        Joueur joueurPersisted = peristNewDummyJoueurWith4Users();
        repository.deleteById(joueurPersisted.getId());
        assertThat(userRepository.count()).isEqualTo(0);
    }

    //tests : findByNomAndPrenom
    @Test
    @Transactional
    public void givenJoueurs_whenFindByNomAndPrenom_thenJoueursAreRetrievedCorrectly() {
        Joueur joueur1 = persistNewJoueur("Carmona", "Julien");
        Joueur joueur2 = persistNewJoueur("Carmona", "Julien");
        List<Joueur> existingJoueurs = Arrays.asList(joueur1, joueur2);
        persistNewJoueur("Carmona", "Pierre");
        persistNewJoueur("Carmona", "Philippe");
        persistNewJoueur("Quentin", "Ville");
        List<Joueur> retrievedJoueurs = repository.findByNomAndPrenom("Carmona", "Julien");
        assertEquals(existingJoueurs, retrievedJoueurs);
        cleanDataBase();
    }

    @Test
    public void givenNothing_whenFindByNomAndPrenom_thenResultIsEmptyList() {
        List<Joueur> retrievedJoueurs = repository.findByNomAndPrenom("Carmona", "Julien");
        assertThat(retrievedJoueurs).isEmpty();
    }

    // tests : deleteByNomAndPrenom
    @Test
    @Transactional
    public void givenJoueurs_whenDeletingByNomAndPrenom_deleteSuccessfull() {
        persistNewJoueur("Carmona", "Julien");
        persistNewJoueur("Carmona", "Julien");
        persistNewJoueur("Carmona", "Pierre");
        persistNewJoueur("Carmona", "Philippe");
        persistNewJoueur("Quentin", "Ville");
        repository.deleteByNomAndPrenom("Carmona", "Julien");
        assertThat(repository.count()).isEqualTo(3);
        cleanDataBase();
    }

    @Test
    @Transactional
    public void givenJoueurs_whenDeletingByNomAndPrenom_thenResultIsEmptyList() {
        persistNewJoueur("Carmona", "Julien");
        persistNewJoueur("Carmona", "Julien");
        persistNewJoueur("Carmona", "Pierre");
        persistNewJoueur("Carmona", "Philippe");
        persistNewJoueur("Quentin", "Ville");
        repository.deleteByNomAndPrenom("Carmona", "Julien");
        assertThat(repository.findByNomAndPrenom("Carmona", "Julien")).isEmpty();
        cleanDataBase();
    }

    @Autowired
    private EntityManager entityManager;

    private Joueur createNewDummyJoueur() {
        return createNewJoueur(DUMMY_JOUEUR_NOM, DUMMY_JOUEUR_PRENOM);
    }

    private Joueur createNewJoueur(String nom, String prenom) {
        return Joueur.builder()
                .nom(nom)
                .prenom(prenom)
                .promo(DUMMY_JOUEUR_PROMO)
                .users(new HashSet<>())
                .build();
    }

    private Joueur persistNewJoueur(String nom, String prenom) {
        return repository.save(createNewJoueur(nom, prenom));
    }

    private Joueur persistNewDummyJoueur() {
        return repository.save(createNewDummyJoueur());
    }

    private Joueur peristNewDummyJoueurWith4Users() {
        Joueur joueur = createNewDummyJoueur();
        joueur.addUser(User.builder().mpgUserId(DUMMY_USER_MPG_USER_ID).build());
        joueur.addUser(User.builder().mpgUserId(DUMMY_USER_MPG_USER_ID).build());
        joueur.addUser(User.builder().mpgUserId(DUMMY_USER_MPG_USER_ID).build());
        joueur.addUser(User.builder().mpgUserId(DUMMY_USER_MPG_USER_ID).build());
        return repository.save(joueur);
    }

    private void cleanDataBase() {
        repository.deleteAll();
    }


}
