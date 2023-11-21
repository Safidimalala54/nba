package ITU.WebAvance.NBA.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_action;
    private String nom_action;

    public Action(Integer id_action, String nom_action) {
        this.id_action = id_action;
        this.nom_action = nom_action;
    }

    public Action(){}

    public Integer getId_action() {
        return id_action;
    }
    public void setId_action(Integer id_action) {
        this.id_action = id_action;
    }
    public String getNom_action() {
        return nom_action;
    }
    public void setNom_action(String nom_action) {
        this.nom_action = nom_action;
    }
}
