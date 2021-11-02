package fr.mpgensai.api.persistence.dao;

import fr.mpgensai.api.persistence.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJoueurRepository extends JpaRepository<Joueur, Long> {

    void deleteByNomAndPrenom(String nom, String prenom);

}
