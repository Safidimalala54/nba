package ITU.WebAvance.NBA.Models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_match;

    private Timestamp date_match;

    @ManyToOne
    @JoinColumn(name = "id_equipe1", referencedColumnName = "id_equipe")
    private Equipe equipe1;

    @ManyToOne
    @JoinColumn(name = "id_equipe2", referencedColumnName = "id_equipe")
    private Equipe equipe2;

    public Long getId_match() {
        return id_match;
    }

    public void setId_match(Long id_match) {
        this.id_match = id_match;
    }

    public Timestamp getDate_match() {
        return date_match;
    }

    public void setDate_match(Timestamp date_match) {
        this.date_match = date_match;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    
}
