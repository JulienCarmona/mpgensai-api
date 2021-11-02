package fr.mpgensai.api.service.impl;

import fr.mpgensai.api.persistence.dao.IJoueurRepository;
import fr.mpgensai.api.persistence.model.Joueur;
import fr.mpgensai.api.service.IJoueurService;
import fr.mpgensai.common.service.impl.AbstractService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
