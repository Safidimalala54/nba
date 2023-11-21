package ITU.WebAvance.NBA.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ITU.WebAvance.NBA.Models.Equipe;
import ITU.WebAvance.NBA.Services.EquipeService;

@RestController
@RequestMapping("/equipes")
public class EquipeController {
    private final EquipeService equipeService;

    @Autowired
    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeService.getAllEquipes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable Long id) {
        Optional<Equipe> equipe = equipeService.getEquipeById(id);
        return equipe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Equipe> createEquipe(@RequestBody Equipe equipe) {
        Equipe savedEquipe = equipeService.saveOrUpdateEquipe(equipe);
        return new ResponseEntity<>(savedEquipe, HttpStatus.CREATED);
    }
}