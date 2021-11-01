package fr.mpgensai.common.service.impl;

import fr.mpgensai.common.model.IWithId;
import fr.mpgensai.common.model.exception.MyEntityNotFoundException;
import fr.mpgensai.common.service.IRawService;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractRawService<T extends IWithId> implements IRawService<T> {

    protected abstract JpaRepository<T, Long> getRepository();

    // find - one
    @Override
    public T findOne(long id) {
        return getRepository().findById(id).orElse(null);
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
