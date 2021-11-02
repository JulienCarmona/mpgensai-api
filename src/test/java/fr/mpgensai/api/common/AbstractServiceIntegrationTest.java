package fr.mpgensai.api.common;

import fr.mpgensai.api.utill.IDUtil;
import fr.mpgensai.common.model.IWithId;
import fr.mpgensai.common.service.IRawService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractServiceIntegrationTest<T extends IWithId> {

    // tests : find - one
    @Test
    public final void givenResourceDoesNotExist_whenResourceIsRetrieved_thenNoResourceIsReceived() {
        // When
        final T createdResource = getApi().findOne(IDUtil.randomPositiveLong());
        // Then
        assertNull(createdResource);
    }

    @Test
    public void givenResourceExists_whenResourceIsRetrieved_thenNoExceptions() {
        final T existingResource = persistNewEntity();
        getApi().findOne(existingResource.getId());
        getApi().delete(existingResource.getId());
    }


    @Test
    public void givenResourceDoesNotExist_whenResourceIsRetrieved_thenNoExceptions() {
        getApi().findOne(IDUtil.randomPositiveLong());
    }

    @Test
    public void givenResourceExists_whenResourceIsRetrieved_thenTheResultIsNotNull() {
        final T existingResource = persistNewEntity();
        final T retrievedResource = getApi().findOne(existingResource.getId());
        assertNotNull(retrievedResource);
    }

    @Test
    public void givenResourceExists_whenResourceIsRetrieved_thenResourceIsRetrievedCorrectly() {
        final T existingResource = persistNewEntity();
        final T retrievedResource = getApi().findOne(existingResource.getId());
        assertEquals(existingResource, retrievedResource);
    }

    protected abstract IRawService<T> getApi();

    protected abstract T createNewEntity();

    protected T persistNewEntity() {
        return getApi().create(createNewEntity());
    }


}
