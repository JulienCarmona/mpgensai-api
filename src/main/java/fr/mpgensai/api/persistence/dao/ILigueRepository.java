package fr.mpgensai.api.persistence.dao;

import fr.mpgensai.api.persistence.model.Ligue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILigueRepository extends JpaRepository<Ligue, Long> {

    void deleteByShortId(String shortId);

}
