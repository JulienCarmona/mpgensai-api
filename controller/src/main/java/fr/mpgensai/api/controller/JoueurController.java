package fr.mpgensai.api.controller;

import fr.mpgensai.api.core.model.Joueur;
import fr.mpgensai.api.dto.JoueurDto;
import fr.mpgensai.api.dto.Mapper;
import fr.mpgensai.api.service.IJoueurService;
import fr.mpgensai.api.util.MpgEnsaiApiMappings;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(MpgEnsaiApiMappings.JOUEURS)
@RequiredArgsConstructor
public class JoueurController {

    private final IJoueurService joueurService;

    private final Mapper mapper;

    @GetMapping("")
    public List<JoueurDto> getAllJoueurs() {
        return joueurService.findAll()
                .stream()
                .map(mapper::toJoueurDto)
                .collect(Collectors.toList());
    }

    @PostMapping("")
    public Joueur createNewJoueur(@RequestBody Joueur newJoueur) {
        return joueurService.create(newJoueur);
    }

    @GetMapping("/{id}")
    public JoueurDto getOneJoueurById(@PathVariable Long id) {
        return mapper.toJoueurDto(joueurService.findOne(id));
    }

    @PutMapping("/{id}")
    public Joueur replaceOneJoueurById(@RequestBody Joueur newJoueur, @PathVariable Long id) {
        return joueurService.updateOrCreate(newJoueur, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        joueurService.delete(id);
    }


    // Info users attribute
    /*@GetMapping("/{id}/users")
    public List<User> allAllUsersOfJoueurById(@PathVariable Long id) {
        return joueurService.findOne(id).getUsers().stream().collect(Collectors.toList());
    }

    @PostMapping("/{id}/users")
    public Joueur updateUserOfJoueurById(@RequestBody Set<User> users, @PathVariable Long id) {
        return joueurService.updateUsers(users, id);
    }*/

}

