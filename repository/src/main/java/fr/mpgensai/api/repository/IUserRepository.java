package fr.mpgensai.api.repository;

import fr.mpgensai.api.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

    void deleteByMpgUserId(String mpgUserId);

}
