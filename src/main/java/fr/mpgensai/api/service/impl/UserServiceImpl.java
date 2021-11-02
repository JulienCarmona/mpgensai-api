package fr.mpgensai.api.service.impl;

import fr.mpgensai.api.persistence.dao.IUserRepository;
import fr.mpgensai.api.persistence.model.User;
import fr.mpgensai.api.service.IUserService;
import fr.mpgensai.common.service.impl.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractService<User> implements IUserService {

    private final IUserRepository repository;

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return repository;
    }

    @Override
    public void deleteByMpgUserId(String dummyMpgUserId) {
        repository.deleteByMpgUserId(dummyMpgUserId);
    }
}
