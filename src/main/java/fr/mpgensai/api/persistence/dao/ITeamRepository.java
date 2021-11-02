package fr.mpgensai.api.persistence.dao;

import fr.mpgensai.api.persistence.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<Team, Long> {


}
