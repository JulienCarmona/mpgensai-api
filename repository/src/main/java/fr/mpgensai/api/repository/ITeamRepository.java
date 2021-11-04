package fr.mpgensai.api.repository;

import fr.mpgensai.api.core.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<Team, Long> {

    void deleteByMpgTeamId(String teamMpgTeamId);
}
