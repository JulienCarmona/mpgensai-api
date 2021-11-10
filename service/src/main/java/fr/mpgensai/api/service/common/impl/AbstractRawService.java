package fr.mpgensai.api.service.common.impl;

import fr.mpgensai.api.core.common.IWithId;
import fr.mpgensai.api.core.exception.MyEntityNotFoundException;
import fr.mpgensai.api.repository.IJoueurRepository;
import fr.mpgensai.api.service.common.IRawService;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractRawService<T extends IWithId> implements IRawService<T> {

    protected abstract JpaRepository<T, Long> getRepository();

    // find - one
    @Override
    public T findOne(long id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new MyEntityNotFoundException(id));
    }

    // find - all
    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    // save/create/persist
    @Override
    public T create(@NonNull final T entity) {
        return getRepository().save(entity);
    }

    // update/merge
    @Override
    public void update(@NonNull final T entity) {
        getRepository().save(entity);
    }

    // delete
    @Override
    public void delete(long id) {
        getRepository().findById(id)
                .orElseThrow(MyEntityNotFoundException::new);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }

    @Override
    public long count() {
        return getRepository().count();
    }
}
