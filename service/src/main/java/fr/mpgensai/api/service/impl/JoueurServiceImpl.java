package fr.mpgensai.api.service.impl;

import fr.mpgensai.api.core.exception.MyEntityNotFoundException;
import fr.mpgensai.api.core.model.Joueur;
import fr.mpgensai.api.core.model.User;
import fr.mpgensai.api.repository.IJoueurRepository;
import fr.mpgensai.api.service.IJoueurService;
import fr.mpgensai.api.service.common.impl.AbstractService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class JoueurServiceImpl extends AbstractService<Joueur> implements IJoueurService {

    @NonNull
    private final IJoueurRepository repository;

    @Override
    protected JpaRepository<Joueur, Long> getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void deleteByNomAndPrenom(String nom, String prenom) {
        repository.deleteByNomAndPrenom(nom, prenom);
    }

    @Override
    public Joueur updateOrCreate(Joueur newJoueur, Long id) {
        return repository.findById(id)
                .map(foundedJoueur -> foundedJoueur.toBuilder()
                        .nom(newJoueur.getNom())
                        .prenom(newJoueur.getPrenom())
                        .promo(newJoueur.getPromo())
                        .build())
                .orElseGet(() -> repository.save(newJoueur.toBuilder()
                        .id(id)
                        .build()));
    }

    @Override
    public Joueur updateUsers(Set<User> users, Long id) {
        return repository.findById(id)
                .map(foundedJoueur -> foundedJoueur.toBuilder()
                        .users(users)
                        .build())
                .orElseThrow(() -> new MyEntityNotFoundException(id));

    }
}
