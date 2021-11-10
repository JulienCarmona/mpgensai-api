package fr.mpgensai.api.service;

import fr.mpgensai.api.core.model.Joueur;
import fr.mpgensai.api.core.model.User;
import fr.mpgensai.api.service.common.IService;

import java.util.Set;

public interface IJoueurService extends IService<Joueur> {

    void deleteByNomAndPrenom(String nom, String prenom);

    Joueur updateOrCreate(Joueur Joueur, Long id);

    Joueur updateUsers(Set<User> users, Long id);
}
