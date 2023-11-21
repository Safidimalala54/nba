package ITU.WebAvance.NBA.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_equipe;

    private String nom_equipe;
    private Integer conference;

    
    public Equipe(Long id_equipe, String nom_equipe, Integer conference) {
        this.id_equipe = id_equipe;
        this.nom_equipe = nom_equipe;
        this.conference = conference;
    }

    public Equipe() {
    }
    
    public Long getId_equipe() {
        return id_equipe;
    }
    public void setId_equipe(Long id_equipe) {
        this.id_equipe = id_equipe;
    }
    public String getNom_equipe() {
        return nom_equipe;
    }
    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }
    public Integer getConference() {
        return conference;
    }
    public void setConference(Integer conference) {
        this.conference = conference;
    }

    
}

