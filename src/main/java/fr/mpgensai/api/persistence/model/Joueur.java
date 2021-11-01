package fr.mpgensai.api.persistence.model;


import fr.mpgensai.common.model.IEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Joueur implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String nom;

    @NotNull
    @Column(nullable = false)
    private String prenom;

    @NotNull
    @Size(min = 4, max = 9, message
            = "promo's valu must hav a length between 4 and 7 ({Year} or 'Permanent' value)")
    @Column(length = 9, nullable = false)
    private String promo;

    @OneToMany(mappedBy = "joueur")
    private Set<User> users;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Joueur))
            return false;
        Joueur other = (Joueur) o;
        return id != null &&
                id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
