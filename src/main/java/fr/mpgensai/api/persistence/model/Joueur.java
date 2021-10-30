package fr.mpgensai.api.persistence.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    private String promo;
    @OneToMany(mappedBy = "joueur")
    private List<User> users;

}
