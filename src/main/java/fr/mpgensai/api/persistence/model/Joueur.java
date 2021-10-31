package fr.mpgensai.api.persistence.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Data
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Column(nullable = false)
    private String nom;
    @NotNull
    @Column(nullable = false)
    private String prenom;
    @NotNull
    @Column(length = 4, nullable = false)
    private int promo;

    @OneToMany(mappedBy = "joueur")
    private Set<User> users;

}
