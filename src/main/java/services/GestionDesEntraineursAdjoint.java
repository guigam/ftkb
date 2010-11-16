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
import modeles.Clubs;
import modeles.EntraineurAdjoint;
import modeles.Personnes;

/**
 *
 * @author guigam
 */

public class GestionDesEntraineursAdjoint {
    private EntraineurAdjoint lentraineurAdj = new EntraineurAdjoint();
    private List<EntraineurAdjoint> lesEntraineursAdjoint = new LinkedList<EntraineurAdjoint>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
    private List<Personnes> lesPersonnes = new LinkedList<Personnes>();
    private Personnes laPersonnes = new Personnes();
    private Clubs monClub = new Clubs();

    /** Creates a new instance of GestionDesEntraineurs */
    public GestionDesEntraineursAdjoint() {
    }

  
    public Personnes listePersonneAdjByCIN(){
       lesPersonnes = new gestionPersonnes().getlistePersonneByCIN(getLaPersonnes().getCin());
       laPersonnes = lesPersonnes.get(0);
        return laPersonnes;
    }

    public String saveEntraineuradjoint(){
        
        EntraineurAdjoint entrain = new EntraineurAdjoint();
        
        entrain.setDateDeb(lentraineurAdj.getDateDeb());
        //entrain.setLeClubs(monClub);
        entrain.setGrade(lentraineurAdj.getGrade());
        entrain.setLaPersonne(laPersonnes);
        entrain.setLicence(lentraineurAdj.getLicence());
        getEm().getTransaction().begin();
        getEm().persist(entrain);
        getEm().getTransaction().commit();

        return "listEntrainAdj";
    }
    public String saveEntraineurADJEtPersonne() {
        EntraineurAdjoint entrainADJ = new EntraineurAdjoint();
        new gestionPersonnes().enregistrerPersonne(laPersonnes);
        saveEntraineuradjoint();
        return "listEntrainAdj";

    }


    public List<EntraineurAdjoint>  getlistDesEntraineurs(){
        Query query = getEm().createQuery("select e from EntraineurAdjoint e where e.etat <> 1");
        lesEntraineursAdjoint = query.getResultList();
        return lesEntraineursAdjoint;
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
        this.setLesPersonnes(lesPersonnes);
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

    /**
     * @return the lentraineurAdj
     */
    public EntraineurAdjoint getLentraineurAdj() {
        return lentraineurAdj;
    }

    /**
     * @param lentraineurAdj the lentraineurAdj to set
     */
    public void setLentraineurAdj(EntraineurAdjoint lentraineurAdj) {
        this.lentraineurAdj = lentraineurAdj;
    }

    /**
     * @return the lesEntraineursAdjoint
     */
    public List<EntraineurAdjoint> getLesEntraineursAdjoint() {
        return lesEntraineursAdjoint;
    }

    /**
     * @param lesEntraineursAdjoint the lesEntraineursAdjoint to set
     */
    public void setLesEntraineursAdjoint(List<EntraineurAdjoint> lesEntraineursAdjoint) {
        this.lesEntraineursAdjoint = lesEntraineursAdjoint;
    }

    /**
     * @return the emf
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @param emf the emf to set
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

   
    

    

   

}
