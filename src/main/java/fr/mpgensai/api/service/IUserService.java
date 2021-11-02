package fr.mpgensai.api.service;

import fr.mpgensai.api.persistence.model.User;
import fr.mpgensai.common.service.IService;

public interface IUserService extends IService<User> {

    void deleteByMpgUserId(String mpgUserId);
}
