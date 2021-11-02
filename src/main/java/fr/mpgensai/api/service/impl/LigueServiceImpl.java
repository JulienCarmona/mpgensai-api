package fr.mpgensai.api.service.impl;

import fr.mpgensai.api.persistence.dao.ILigueRepository;
import fr.mpgensai.api.persistence.dao.ITeamRepository;
import fr.mpgensai.api.persistence.model.Ligue;
import fr.mpgensai.api.persistence.model.Team;
import fr.mpgensai.api.service.ILigueService;
import fr.mpgensai.api.service.ITeamService;
import fr.mpgensai.common.service.impl.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LigueServiceImpl extends AbstractService<Ligue> implements ILigueService {

    private final ILigueRepository repository;

    @Override
    protected JpaRepository<Ligue, Long> getRepository() {
        return repository;
    }


    @Override
    public void deleteByShortId(String shortId) {
        repository.deleteByShortId(shortId);
    }
}
