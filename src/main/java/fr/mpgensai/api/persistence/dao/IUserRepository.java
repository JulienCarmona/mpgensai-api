package fr.mpgensai.api.persistence.dao;

import fr.mpgensai.api.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

    void deleteByMpgUserId(String mpgUserId);

}
