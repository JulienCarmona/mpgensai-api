package fr.mpgensai.api.repository;

import fr.mpgensai.api.core.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IJoueurRepository extends JpaRepository<Joueur, Long> {

    List<Joueur> findByNomAndPrenom(String nom, String prenom);

    void deleteByNomAndPrenom(String nom, String prenom);

}
