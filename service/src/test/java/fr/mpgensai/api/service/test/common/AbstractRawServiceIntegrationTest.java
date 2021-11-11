package fr.mpgensai.api.service.test.common;

import fr.mpgensai.api.core.common.IWithId;
import fr.mpgensai.api.core.exception.MyEntityNotFoundException;
import fr.mpgensai.api.core.utill.IDUtil;
import fr.mpgensai.api.service.common.IRawService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractRawServiceIntegrationTest<T extends IWithId> {

    // tests : find - one
    @Test
    public void givenResourceExists_whenResourceIsRetrieved_thenNoExceptions() {
        final T existingResource = persistNewEntity();
        assertDoesNotThrow(() -> getApi().findOne(existingResource.getId()));
        cleanDataBaseFromPersistedTestEntities();
    }

    @Test
    public void givenResourceDoesNotExist_whenResourceIsRetrieved_thenMyEntityNotFoundExceptionThrown() {
        final Long randomPositiveLongId = IDUtil.randomPositiveLong();
        Exception exception = assertThrows(MyEntityNotFoundException.class,
                () -> getApi().findOne(randomPositiveLongId),
                "NoSuchElementException error was expected");
        String expectedMessage = "Entity with id " + randomPositiveLongId + "not found in the database";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void givenResourceExists_whenResourceIsRetrieved_thenTheResultIsNotNull() {
        final T existingResource = persistNewEntity();
        final T retrievedResource = getApi().findOne(existingResource.getId());
        assertNotNull(retrievedResource);
        cleanDataBaseFromPersistedTestEntities();
    }

    @Test
    public void givenResourceExists_whenResourceIsRetrieved_thenResourceIsRetrievedCorrectly() {
        final T existingResource = persistNewEntity();
        final T retrievedResource = getApi().findOne(existingResource.getId());
        assertEquals(existingResource, retrievedResource);
        cleanDataBaseFromPersistedTestEntities();
    }


    // tests : find - all
    @Test
    public void whenAllResourcesAreRetrieved_thenNoExceptions() {
        assertDoesNotThrow(() -> getApi().findAll());
    }

    @Test
    public void whenAllResourcesAreRetrieved_thenTheResultIsNotNull() {
        final List<T> resources = getApi().findAll();
        assertNotNull(resources);
    }

    @Test
    public void givenAtLeastOneResourceExists_whenAllResourcesAreRetrieved_thenRetrievedResourcesAreNotEmpty() {
        persistNewEntity();
        // When
        final List<T> allResources = getApi().findAll();
        // Then
        assertThat(allResources, not(Matchers.<T>empty()));
        cleanDataBaseFromPersistedTestEntities();
    }

    @Test
    public void givenAnResourceExists_whenAllResourcesAreRetrieved_thenTheExistingResourceIsIndeedAmongThem() {
        final T existingResource = persistNewEntity();
        final List<T> resources = getApi().findAll();
        assertThat(resources, hasItem(existingResource));
    }

    @Test
    public void whenAllResourcesAreRetrieved_thenResourcesHaveIds() {
        persistNewEntity();
        // When
        final List<T> allResources = getApi().findAll();
        // Then
        for (final T resource : allResources) {
            assertNotNull(resource.getId());
        }
    }

    protected abstract IRawService<T> getApi();

    protected abstract T createNewEntity();

    protected T persistNewEntity() {
        return getApi().create(createNewEntity());
    }

    protected abstract void cleanDataBaseFromPersistedTestEntities();


}
