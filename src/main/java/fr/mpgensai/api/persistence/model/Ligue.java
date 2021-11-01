package fr.mpgensai.api.persistence.model;

import fr.mpgensai.common.model.IEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Ligue implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @NotNull
    @Column(length = 1, nullable = false)
    private int montee;

    @NotNull
    @Column(length = 1, nullable = false)
    private int descente;

    @OneToMany(mappedBy = "ligue")
    private Set<Team> teams;

    public String getMpgDivisionId() {
        return shortId + "_" + saison + "_" + division;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ligue))
            return false;
        Ligue other = (Ligue) o;
        return id != null &&
                id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
