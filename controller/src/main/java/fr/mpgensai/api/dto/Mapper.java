package fr.mpgensai.api.dto;

import fr.mpgensai.api.core.model.Joueur;
import fr.mpgensai.api.core.model.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Mapper {

    public JoueurDto toJoueurDto(Joueur joueur) {
        return JoueurDto.builder()
                .nom(joueur.getNom())
                .prenom(joueur.getPrenom())
                .promo(joueur.getPromo())
                .mpgUserIds(joueur.getUsers()
                        .stream()
                        .map(User::getMpgUserId)
                        .collect(Collectors.toSet()))
                .build();
    }

}
