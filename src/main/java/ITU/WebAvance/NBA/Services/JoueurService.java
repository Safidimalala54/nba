package ITU.WebAvance.NBA.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ITU.WebAvance.NBA.Models.Joueur;
import ITU.WebAvance.NBA.Repository.JoueurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JoueurService {

    private final JoueurRepository joueurRepository;

    @Autowired
    public JoueurService(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    public Optional<Joueur> getJoueurById(Integer id) {
        return joueurRepository.findById(id);
    }

    public Joueur saveOrUpdateJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public void deleteJoueur(Integer id) {
        joueurRepository.deleteById(id);
    }
    // Autres méthodes CRUD si nécessaire
}
