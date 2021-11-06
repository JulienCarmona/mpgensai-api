package fr.mpgensai.api.repository.test.common;

import fr.mpgensai.api.core.common.IWithId;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractRepositoryUnitTest<T extends IWithId> {

    // tests : deleteById
    @Test
    public void givenOnlyOneJoueur_whenDeleteByIdFromRepository_thenRepositoryShouldBeEmpty() {
        T persistedJoueur = persistNewDummyEntity();
        getRepository().deleteById(persistedJoueur.getId());
        assertThat(getRepository().count()).isEqualTo(0);
    }

    @Test
    public void givenJoueurIsDeleted_whenFindByIdAndTryToGetJoueur_thenNoSuchElementExceptionIsThrown() {
        T persistedJoueur = persistNewDummyEntity();
        getRepository().deleteById(persistedJoueur.getId());
        assertThrows(NoSuchElementException.class,
                () -> getRepository().findById(persistedJoueur.getId()).get(),
                "NoSuchElementException error was expected");
    }

    // tests : deleteAll
    @Test
    public void givenJoueurs_whenDeleteAllFromRepository_thenRepositoryShouldBeEmpty() {
        T persistedJoueur1 = persistNewDummyEntity();
        T persistedJoueur2 = persistNewDummyEntity();
        T persistedJoueur3 = persistNewDummyEntity();
        getRepository().deleteAll();
        assertThat(getRepository().count()).isEqualTo(0);
    }

    protected abstract JpaRepository<T, Long> getRepository();

    protected abstract T createNewDummyEntity();

    protected T persistNewDummyEntity() {
        return getRepository().save(createNewDummyEntity());
    }

    protected void cleanDataBase() {
        getRepository().deleteAll();
    }

}
