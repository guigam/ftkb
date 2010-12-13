/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import services.ServiceEntraineurs.ServiceEntraineurImpl;
import modeles.Clubs;
import modeles.Entraineurs;
import modeles.Historique;
import modeles.Personnes;

/**
 *
 * @author guigam
 */

public class GestionDesEntraineurs {
    private Entraineurs lentraineur = new Entraineurs();
    private List<Entraineurs> lesEntraineurs = new LinkedList<Entraineurs>();
    private List<Personnes> lesPersonnes = new LinkedList<Personnes>();
    private Personnes laPersonnes = new Personnes();
    private Clubs monClub = new Clubs();
    private Historique he = new Historique();




			// private static final Date df = new Date("01-01-3000");
            /** Creates a new instance of GestionDesEntraineurs */
    public GestionDesEntraineurs() {
    }

  

    public List<Personnes> listePersonneByCIN() {
       lesPersonnes = new gestionPersonnes().getlistePersonneByCIN(getLaPersonnes().getCin());
       return lesPersonnes;
    }

    public String saveEntraineur(){
       
        Entraineurs entrain = new Entraineurs();
        //entrain.setDateDeb(getLentraineur().getDateDeb());
        //entrain.setDateFin(df);
        entrain.setLeClubEntraineur(monClub);
        entrain.setGrade(getLentraineur().getGrade());
        entrain.setLaPersonne(laPersonnes);
        entrain.setLicence(getLentraineur().getLicence());
        new ServiceEntraineurImpl().saveEntraineur(entrain);
        return "listEntrain";
    }

    public String saveEntraineurEtPersonne() {
        Entraineurs entrain = new Entraineurs();
        new gestionPersonnes().enregistrerPersonne(laPersonnes);
        saveEntraineur();
        return "listEntrain";

    }


//    public List<Entraineurs> getlistDesEntraineursParClub(Clubs p_Clubs){
//        Query query = getEm().createQuery("from Entraineurs e where e.leClubs = ?1");
//        query.setParameter(1, p_Clubs);
//        lesEntraineurs = query.getResultList();
//        return lesEntraineurs;
//    }

    /**
     * @return the lentraineur
     */
    public Entraineurs getLentraineur() {
        return lentraineur;
    }

    /**
     * @param lentraineur the lentraineur to set
     */
    public void setLentraineur(Entraineurs lentraineur) {
        this.lentraineur = lentraineur;
    }

    /**
     * @return the lesEntraineurs
     */
    public List<Entraineurs> getLesEntraineurs() {
        return new ServiceEntraineurImpl().lstEntraineur();
    }

    /**
     * @param lesEntraineurs the lesEntraineurs to set
     */
    public void setLesEntraineurs(List<Entraineurs> lesEntraineurs) {
        this.setLesEntraineurs(lesEntraineurs);
    }



    /**
     * @param lesPersonnes the lesPersonnes to set
     */
    public void setLesPersonnes(LinkedList<Personnes> lesPersonnes) {
        this.setLesPersonnes(lesPersonnes);
    }

    /**
     * @return the lesPersonnes
     */
    public List<Personnes> getLesPersonnes() {
        return lesPersonnes;
    }

    /**
     * @param lesPersonnes the lesPersonnes to set
     */
    public void setLesPersonnes(List<Personnes> lesPersonnes) {
        this.lesPersonnes = lesPersonnes;
    }

    /**
     * @return the laPersonnes
     */
    public Personnes getLaPersonnes() {
        return laPersonnes;
    }

    /**
     * @param laPersonnes the laPersonnes to set
     */
    public void setLaPersonnes(Personnes laPersonnes) {
        this.laPersonnes = laPersonnes;
    }

    /**
     * @return the monClub
     */
    public Clubs getMonClub() {
        return monClub;
    }

    /**
     * @param monClub the monClub to set
     */
    public void setMonClub(Clubs monClub) {
        this.monClub = monClub;
    }

    

    

   

}
