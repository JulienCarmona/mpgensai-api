package fr.mpgensai.api.repository;

import fr.mpgensai.api.core.model.Ligue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILigueRepository extends JpaRepository<Ligue, Long> {

    void deleteByShortId(String shortId);

}
