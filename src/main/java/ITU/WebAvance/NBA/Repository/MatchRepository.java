package ITU.WebAvance.NBA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ITU.WebAvance.NBA.Models.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    // Additional custom methods if needed
}
