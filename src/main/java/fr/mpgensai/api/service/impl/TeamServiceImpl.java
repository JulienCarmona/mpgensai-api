package fr.mpgensai.api.service.impl;

import fr.mpgensai.api.persistence.dao.ITeamRepository;
import fr.mpgensai.api.persistence.model.Team;
import fr.mpgensai.api.service.ITeamService;
import fr.mpgensai.common.service.impl.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamServiceImpl extends AbstractService<Team> implements ITeamService {

    private final ITeamRepository repository;

    @Override
    protected JpaRepository<Team, Long> getRepository() {
        return repository;
    }


}
