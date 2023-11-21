package ITU.WebAvance.NBA.Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import org.apache.catalina.connector.Connector;

public class Statistique {
    String joueur;
    Integer id;
    String equipe;
    Float match;
    Float matchJoueur;
    Float point;
    Float rebond;
    Float passe;
    Float tir;
    Float troisPoint;
    Float lancer;
    
    public Statistique(String joueur, Integer id, String equipe, Float match, Float matchJoueur, Float point, Float rebond,
            Float passe, Float tir, Float troisPoint, Float lancer) {
        this.joueur = joueur;
        this.id = id;
        this.equipe = equipe;
        this.match = match;
        this.matchJoueur = matchJoueur;
        this.point = point;
        this.rebond = rebond;
        this.passe = passe;
        this.tir = tir;
        this.troisPoint = troisPoint;
        this.lancer = lancer;
    }

    public Statistique() {
    }

    public Vector<Statistique> getStatistiqueJoueur(Connection co) throws SQLException{
        Vector<Statistique> stat = new Vector<>();
        boolean nisokatra = false;
        if (co == null) {
            co = new Connect().getConnection();
            nisokatra = true;
        }
        try {
            String sql = "select * from v_statistique order by PPM desc";
            Statement state = co.createStatement();
            ResultSet res = state.executeQuery(sql);
            while (res.next()) {
                Statistique statistique = new Statistique();
                statistique.joueur = res.getString("joueur");
                statistique.id = res.getInt("id_equipe");
                statistique.equipe = res.getString("equipe");
                statistique.match = res.getFloat("match");
                statistique.matchJoueur = res.getFloat("matchjoueur");
                statistique.point = res.getFloat("ppm");
                statistique.rebond = res.getFloat("rbpm");
                statistique.passe = res.getFloat("pdpm");
                statistique.tir = res.getFloat("tir");
                statistique.troisPoint = res.getFloat("trois");
                statistique.lancer = res.getFloat("lf");
                stat.add(statistique);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        if (nisokatra) {
            co.close();
        }
        return stat;
    }

    public Vector<Statistique> getStatistiqueJoueurEquipe(Connection co, Integer idequipe) throws SQLException{
        Vector<Statistique> stat = new Vector<>();
        boolean nisokatra = false;
        if (co == null) {
            co = new Connect().getConnection();
            nisokatra = true;
        }
        try {
            String sql = "select * from v_statistique where id_equipe = '"+ idequipe +"' order by PPM desc";
            Statement state = co.createStatement();
            ResultSet res = state.executeQuery(sql);
            while (res.next()) {
                Statistique statistique = new Statistique();
                statistique.joueur = res.getString("joueur");
                statistique.id = res.getInt("id_equipe");
                statistique.equipe = res.getString("equipe");
                statistique.match = res.getFloat("match");
                statistique.matchJoueur = res.getFloat("matchjoueur");
                statistique.point = res.getFloat("ppm");
                statistique.rebond = res.getFloat("rbpm");
                statistique.passe = res.getFloat("pdpm");
                statistique.tir = res.getFloat("tir");
                statistique.troisPoint = res.getFloat("trois");
                statistique.lancer = res.getFloat("lf");
                stat.add(statistique);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        if (nisokatra) {
            co.close();
        }
        return stat;
    }

    public String getJoueur() {
        return joueur;
    }

    public void setJoueur(String joueur) {
        this.joueur = joueur;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public Float getMatch() {
        return match;
    }

    public void setMatch(Float match) {
        this.match = match;
    }

    public Float getMatchJoueur() {
        return matchJoueur;
    }

    public void setMatchJoueur(Float matchJoueur) {
        this.matchJoueur = matchJoueur;
    }

    public Float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }

    public Float getRebond() {
        return rebond;
    }

    public void setRebond(Float rebond) {
        this.rebond = rebond;
    }

    public Float getPasse() {
        return passe;
    }

    public void setPasse(Float passe) {
        this.passe = passe;
    }

    public Float getTir() {
        return tir;
    }

    public void setTir(Float tir) {
        this.tir = tir;
    }

    public Float getTroisPoint() {
        return troisPoint;
    }

    public void setTroisPoint(Float troisPoint) {
        this.troisPoint = troisPoint;
    }

    public Float getLancer() {
        return lancer;
    }

    public void setLancer(Float lancer) {
        this.lancer = lancer;
    }
}
