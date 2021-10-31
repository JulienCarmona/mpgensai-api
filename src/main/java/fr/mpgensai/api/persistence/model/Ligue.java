package fr.mpgensai.api.persistence.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class Ligue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(nullable = false)
    private String shortId;

    @NotNull
    @Column(length = 1, nullable = false)
    private int saison;

    @NotNull
    @Column(length = 1, nullable = false)
    private int division;

    @NotNull
    @Column(length = 1, nullable = false)
    private String poule;

    private boolean montee;

    private boolean descente;

    @OneToMany(mappedBy = "ligue")
    private Set<Team> teams;

}
