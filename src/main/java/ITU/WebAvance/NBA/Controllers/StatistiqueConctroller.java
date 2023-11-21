package ITU.WebAvance.NBA.Controllers;

import java.sql.SQLException;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ITU.WebAvance.NBA.Models.Statistique;

@RestController
@RequestMapping("/stats")
public class StatistiqueConctroller {
    
    @GetMapping
    public Vector<Statistique> getStatistiqueClass() throws SQLException{
        return new Statistique().getStatistiqueJoueur(null);
    }

    @GetMapping("/{equipe}")
    public Vector<Statistique> getStatEquipeByNomEquipe(@PathVariable Integer equipe) throws SQLException{
        return new Statistique().getStatistiqueJoueurEquipe(null, equipe);
    }
}
