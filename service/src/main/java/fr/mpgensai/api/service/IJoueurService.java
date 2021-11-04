package fr.mpgensai.api.service;

import fr.mpgensai.api.core.model.Joueur;
import fr.mpgensai.api.service.common.IService;

public interface IJoueurService extends IService<Joueur> {

    void deleteByNomAndPrenom(String nom, String prenom);
}
