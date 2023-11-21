package ITU.WebAvance.NBA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ITU.WebAvance.NBA.Models.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Integer> {
    // Ajoutez des méthodes personnalisées si nécessaire
}

