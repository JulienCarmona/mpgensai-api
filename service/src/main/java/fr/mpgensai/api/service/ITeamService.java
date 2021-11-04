package fr.mpgensai.api.service;


import fr.mpgensai.api.core.model.Team;
import fr.mpgensai.api.service.common.IService;

public interface ITeamService extends IService<Team> {
    void deleteByMpgTeamId(String teamMpgTeamId);
}
