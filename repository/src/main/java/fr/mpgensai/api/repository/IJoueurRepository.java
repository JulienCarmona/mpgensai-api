package fr.mpgensai.api.repository;

import fr.mpgensai.api.core.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJoueurRepository extends JpaRepository<Joueur, Long> {

    void deleteByNomAndPrenom(String nom, String prenom);

}
