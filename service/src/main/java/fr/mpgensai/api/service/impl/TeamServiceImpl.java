package fr.mpgensai.api.service.impl;

import fr.mpgensai.api.core.model.Team;
import fr.mpgensai.api.repository.ITeamRepository;
import fr.mpgensai.api.service.ITeamService;
import fr.mpgensai.api.service.common.impl.AbstractService;
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


    @Override
    public void deleteByMpgTeamId(String teamMpgTeamId) {
        repository.deleteByMpgTeamId(teamMpgTeamId);
    }
}
