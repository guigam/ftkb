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
import modeles.Arbitres;
import modeles.Personnes;


/**
 *
 * @author guiga
 */
public class GestionArbitre {
    private Arbitres monArbitre = new Arbitres();
    private List<Arbitres> lesArbitres = new LinkedList<Arbitres>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
    private List<Personnes> lesPersonnes = new LinkedList<Personnes>();
    private Personnes laPersonnes = new Personnes();
   

    /** Creates a new instance of GestionArbitre */
    public GestionArbitre() {
    }




//    public Personnes listePersonneByCIN() {
//        lesPersonnes = new gestionPersonnes().getlistePersonneByCIN(getLaPersonnes().getCin());
//        setLaPersonnes(lesPersonnes.get(0));
//        return getLaPersonnes();
//    }


    public String saveArbitre() {
        
        Arbitres Arb = new Arbitres();
       
        Arb.setDateDeb(getMonArbitre().getDateDeb());
        //entrain.setDateFin(df);
        //entrain.setLeClubs(monClub);
        Arb.setGrade(getMonArbitre().getGrade());
        Arb.setLaPersonne(getLaPersonnes());
        Arb.setLicence(getMonArbitre().getLicence());
        em.getTransaction().begin();
        em.persist(Arb);
        em.getTransaction().commit();

        return "listArbitres";
    }
    public String saveArbitreEtPersonne() {
        Arbitres arb = new Arbitres();
        new gestionPersonnes().enregistrerPersonne(getLaPersonnes());
        saveArbitre();
        return "listArbitres";

    }

    public List<Arbitres> getlistDesArbitres() {
        Query query = em.createQuery("from Arbitres a where a.etat <> 1");
        lesArbitres = query.getResultList();
        return lesArbitres;
    }


    

    /**
     * @return the lesArbitres
     */
    public List<Arbitres> getLesArbitres() {
        return lesArbitres;
    }

    /**
     * @param lesArbitres the lesArbitres to set
     */
    public void setLesArbitres(List<Arbitres> lesArbitres) {
        this.lesArbitres = lesArbitres;
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
     * @return the monArbitre
     */
    public Arbitres getMonArbitre() {
        return monArbitre;
    }

    /**
     * @param monArbitre the monArbitre to set
     */
    public void setMonArbitre(Arbitres monArbitre) {
        this.monArbitre = monArbitre;
    }

}
