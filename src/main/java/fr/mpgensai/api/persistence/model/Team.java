package fr.mpgensai.api.persistence.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Ligue ligue;

    private String teamId;

    private String name;

    private int classementFinal;
}
