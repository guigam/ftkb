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
import modeles.Entraineurs;
import modeles.HistoriqueJoueurs;
import modeles.Joueur;
import modeles.Personnes;
import modeles.specialite;



/**
 *
 * @author guigam
 */
public class GestionDesJoueurs {
    private Joueur lejoueur = new Joueur();
    private Personnes monPersonne = new Personnes();
    private List<Personnes> lesPersonnes = new LinkedList<Personnes>();   
    private List<Joueur> lesJoueurs = new LinkedList<Joueur>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
    private List<specialite> mesSpecial = new LinkedList<specialite>();
    private HistoriqueJoueurs m_historique = new HistoriqueJoueurs();
     /** Creates a new instance of GestionDesJoueurs */
    public GestionDesJoueurs() {
    }

    public List<Personnes> listePersonneByCIN() {
        System.out.println("test");
        lesPersonnes = new gestionPersonnes().getlistePersonneByCIN(getMonPersonne().getCin());
        return  lesPersonnes;
    }

    public Joueur rechercheJoueurParLicence(String licence) {
        Query query = em.createQuery("select j from Joueur j where j.licence = ?1");
        query.setParameter(1, licence);
        lejoueur = (Joueur) query.getResultList().get(0);
        return lejoueur;
    }

      public List<Joueur>  getlistDesJoueurs(){
        Query query = em.createQuery("select j from Joueur j where j.etat <> 1");
        lesJoueurs = query.getResultList();
        return lesJoueurs;
    }
     

 
    public String saveJoueurs() {
       
        Joueur monJoueur = new Joueur();
         //monJoueur.setLesSpecialite(lejoueur.getLesSpecialite());
         monJoueur.setDateDebut(getLejoueur().getDateDebut());
        //entrain.setDateFin(df);
        monJoueur.setLeClubJoueur(lejoueur.getLeClubJoueur());
        monJoueur.setGrade(getLejoueur().getGrade());
         monJoueur.setLaPersonne(monPersonne);
        monJoueur.setLicence(getLejoueur().getLicence());
        em.getTransaction().begin();
        em.persist(monJoueur);
        em.getTransaction().commit();

        return "listJoueurs";
    }

    public String saveJoueurEtPersonne() {
        Joueur joueur = new Joueur();
        new gestionPersonnes().enregistrerPersonne(monPersonne);
        saveJoueurs();
        return "listJoueurs";

    }
    
    public void coucou(){
    	System.out.println("alooooooooooooooo");
    }
    
   public List<Joueur> getrecherchelstJoueurPAram(){
       String lic = null;
       String grd = null;

       if (lejoueur.getLicence()!= null){
            lic = lejoueur.getLicence();
       }
       if(lejoueur.getGrade()!=null){
            grd = lejoueur.getGrade();
       }
        Query query = em.createQuery("from Joueur j ");
       // query.setParameter(1, lic);
        //query.setParameter(2, "Marron");
        lesJoueurs = query.getResultList();
    return lesJoueurs;
   }
   


    /**
     * @return the lejoueur
     */
    public Joueur getLejoueur() {
        return lejoueur;
    }

    /**
     * @param lejoueur the lejoueur to set
     */
    public void setLejoueur(Joueur lejoueur) {
        this.lejoueur = lejoueur;
    }

    /**
     * @return the lesJoueurs
     */
    public List<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

    /**
     * @param lesJoueurs the lesJoueurs to set
     */
    public void setLesJoueurs(List<Joueur> lesJoueurs) {
        this.setLesJoueurs(lesJoueurs);
    }

    

    /**
     * @return the monPersonne
     */
    public Personnes getMonPersonne() {
        return monPersonne;
    }

    /**
     * @param monPersonne the monPersonne to set
     */
    public void setMonPersonne(Personnes monPersonne) {
        this.monPersonne = monPersonne;
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
     * @return the emf
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }

    


    /**
     * @return the mesSpecial
     */
    public List<specialite> getMesSpecial() {
        return mesSpecial;
    }

    /**
     * @param mesSpecial the mesSpecial to set
     */
    public void setMesSpecial(List<specialite> mesSpecial) {
        this.mesSpecial = mesSpecial;
    }

    /**
     * @return the m_historique
     */
    public HistoriqueJoueurs getM_historique() {
        return m_historique;
    }

    /**
     * @param m_historique the m_historique to set
     */
    public void setM_historique(HistoriqueJoueurs m_historique) {
        this.m_historique = m_historique;
    }



   

   
}
