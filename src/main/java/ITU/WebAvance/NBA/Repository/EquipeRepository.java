package ITU.WebAvance.NBA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ITU.WebAvance.NBA.Models.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    
}
