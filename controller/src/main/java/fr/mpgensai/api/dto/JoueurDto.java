package fr.mpgensai.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class JoueurDto {

    private String nom;
    private String prenom;
    private String promo;
    private Set<String> mpgUserIds;

}
