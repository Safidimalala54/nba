package ITU.WebAvance.NBA.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "joueur")
public class Joueur {

    public Joueur() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_joueur")
    private Integer idJoueur;

    @Column(name = "nom_joueur")
    private String nomJoueur;

    @Column(name = "prenom_joueur")
    private String prenomJoueur;

    @Column(name = "date_de_naissance")
    private Date dateDeNaissance;

    @Column(name = "position")
    private int position;

    public Joueur(Integer idJoueur, String nomJoueur, String prenomJoueur, Date dateDeNaissance, int position) {
        this.idJoueur = idJoueur;
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
        this.dateDeNaissance = dateDeNaissance;
        this.position = position;
    }

    public Integer getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(Integer idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    public void setPrenomJoueur(String prenomJoueur) {
        this.prenomJoueur = prenomJoueur;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    // Getters and setters
}

