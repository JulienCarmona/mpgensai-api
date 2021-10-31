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

    @OneToMany(mappedBy = "user")
    private Set<Team> teams;

}
