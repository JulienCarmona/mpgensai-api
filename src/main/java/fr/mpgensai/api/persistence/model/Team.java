package fr.mpgensai.api.persistence.model;

import fr.mpgensai.common.model.IEntity;
import fr.mpgensai.common.model.INameableEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Team implements INameableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Ligue ligue;

    private String mpgTeamId;

    private String name;

    private int classementFinal;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team))
            return false;
        Team other = (Team) o;
        return id != null &&
                id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
}
