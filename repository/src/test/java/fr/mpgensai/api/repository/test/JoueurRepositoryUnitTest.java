package fr.mpgensai.api.repository.test;

import fr.mpgensai.api.core.model.Joueur;
import fr.mpgensai.api.core.spring.EntityConfig;
import fr.mpgensai.api.repository.IJoueurRepository;
import fr.mpgensai.api.repository.spring.RepositoryConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
@ContextConfiguration(classes = {RepositoryConfig.class, EntityConfig.class})
@TestPropertySource(locations = {"classpath:persistence-h2.properties"})
public class JoueurRepositoryUnitTest {

    @Autowired
    IJoueurRepository repository;

    @Test
    void contextLoad() {
    }

    @Test
    public void whenDeleteByIdFromRepository_thenDeletingShouldBeSuccessful() {

        repository.deleteById(book1.getId());
        assertThat(repository.count()).isEqualTo(1);
    }

    @Test
    public void whenDeleteAllFromRepository_thenRepositoryShouldBeEmpty() {
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }


    private Joueur createNewEntity() {
        return Joueur.builder()
                .nom(D)
                .build()
    }

    private T persistNewEntity() {
        return getApi().create(createNewEntity());
    }


}
