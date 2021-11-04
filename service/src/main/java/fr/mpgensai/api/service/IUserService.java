package fr.mpgensai.api.service;

import fr.mpgensai.api.core.model.User;
import fr.mpgensai.api.service.common.IService;

public interface IUserService extends IService<User> {

    void deleteByMpgUserId(String mpgUserId);
}
