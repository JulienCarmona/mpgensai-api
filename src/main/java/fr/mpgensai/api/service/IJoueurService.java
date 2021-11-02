package fr.mpgensai.api.service;

import fr.mpgensai.api.persistence.model.Joueur;
import fr.mpgensai.common.service.IService;

public interface IJoueurService extends IService<Joueur> {

    void deleteByNomAndPrenom(String nom, String prenom);
}
