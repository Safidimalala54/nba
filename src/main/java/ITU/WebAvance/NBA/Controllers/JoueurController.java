package ITU.WebAvance.NBA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ITU.WebAvance.NBA.Models.Joueur;
import ITU.WebAvance.NBA.Services.JoueurService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

    private final JoueurService joueurService;

    @Autowired
    public JoueurController(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    @GetMapping
    public List<Joueur> getAllJoueurs() {
        return joueurService.getAllJoueurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable Integer id) {
        Optional<Joueur> joueur = joueurService.getJoueurById(id);
        return joueur.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Joueur> createJoueur(@RequestBody Joueur joueur) {
        Joueur savedJoueur = joueurService.saveOrUpdateJoueur(joueur);
        return new ResponseEntity<>(savedJoueur, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoueur(@PathVariable Integer id) {
        joueurService.deleteJoueur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
