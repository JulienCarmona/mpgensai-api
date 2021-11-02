package fr.mpgensai.api.service;

import fr.mpgensai.api.persistence.model.Ligue;
import fr.mpgensai.common.service.IService;

public interface ILigueService extends IService<Ligue> {

    void deleteByShortId(String shortId);

}
