package fr.mpgensai.api.service;

import fr.mpgensai.api.core.model.Ligue;
import fr.mpgensai.api.service.common.IService;

public interface ILigueService extends IService<Ligue> {

    void deleteByShortId(String shortId);

}
