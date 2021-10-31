package fr.mpgensai.api.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Joueur joueur;

    @ManyToMany
    @JoinTable(name = "Team",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_ligue"))
    private Set<Ligue> ligues;

}
