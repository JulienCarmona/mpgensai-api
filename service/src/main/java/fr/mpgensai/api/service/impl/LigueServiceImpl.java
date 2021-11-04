package fr.mpgensai.api.service.impl;

import fr.mpgensai.api.core.model.Ligue;
import fr.mpgensai.api.repository.ILigueRepository;
import fr.mpgensai.api.service.ILigueService;
import fr.mpgensai.api.service.common.impl.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LigueServiceImpl extends AbstractService<Ligue> implements ILigueService {

    private final ILigueRepository repository;

    @Override
    protected JpaRepository<Ligue, Long> getRepository() {
        return repository;
    }


    @Override
    @Transactional
    public void deleteByShortId(String shortId) {
        repository.deleteByShortId(shortId);
    }
}
