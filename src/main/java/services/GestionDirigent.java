/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modeles.Clubs;
import modeles.Dirigents;
import modeles.HistoriqueDirigent;
import modeles.Personnes;


/**
 *
 * @author guiga
 */
public class GestionDirigent {

    private Dirigents leDirigent = new Dirigents();
    private List<Dirigents> lesDirigents = new LinkedList<Dirigents>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
    private List<Personnes> lesPersonnes = new LinkedList<Personnes>();
    private Personnes laPersonnes = new Personnes();
    private Clubs monClub = new Clubs();
    private HistoriqueDirigent m_historique = new HistoriqueDirigent();
    static Date dateSysteme = new Date();


	/** Creates a new instance of GestionDirigent */
    public GestionDirigent() {
    }



    public List<Personnes> listePersonneByCIN() {
        lesPersonnes = new gestionPersonnes().getlistePersonneByCIN(getLaPersonnes().getCin());
        
        
        return  lesPersonnes;
    }
    
    

    public void saveDirigent() {
    	  //on crée un nouveau dirigent
    	List<HistoriqueDirigent> lstHD = new LinkedList<HistoriqueDirigent>();
    	lstHD.add(m_historique);
    	leDirigent.setLst_histoDirigents(lstHD);
        leDirigent.setLaPersonne(lesPersonnes.get(0));      
        em.getTransaction().begin();
        try{
        em.persist(leDirigent);
        }catch (Exception e) {
			// TODO: handle exception
        	em.getTransaction().rollback();
		}
        em.getTransaction().commit();
        //return "listDirigents";
    }

    public void miseAjourHistorique(Dirigents leDirig, HistoriqueDirigent p_HD){
    	Query query = em.createQuery("from HistoriqueDirigent h where h.m_dirigents = 1? and h.dateDebut = ?2 and h.dateFin = ?3");
    	query.setParameter(1, leDirig);
    	query.setParameter(2, p_HD.getDateDebut());
    	query.setParameter(3, p_HD.getDateFin());
    	HistoriqueDirigent hd = (HistoriqueDirigent) query.getResultList().get(0);
    	hd.setDateFin(p_HD.getDateDebut());
    	em.getTransaction().begin();
    	try{
    		em.persist(hd);
    	}catch (Exception e) {
			// TODO: handle exception
    		em.getTransaction().rollback();
		}
    	em.getTransaction().commit();
    }	
    
    public String saveDirigentEtPersonne(){
        try{
        new gestionPersonnes().enregistrerPersonne(laPersonnes);
        saveDirigent();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
       
        return "listDirigents";
       
    }

        public List<Dirigents> getlisDesDirigents() {
        
        Query query = em.createQuery("from Dirigents d where d.etat <> 1");
        List<Dirigents> lst_dirigents = query.getResultList();
//        for(Dirigents d :lst_dirigents){
//        Dirigents dr = new Dirigents();
//       
//      	dr.setLaPersonne(d.getLaPersonne());
//      	dr.setLst_histoDirigents(new gestionHistorique().licenceCourantduDirigent(d));
//      	
//      	lesDirigents.add(dr);
//      	
//      }
      //  lesDirigents = query.getResultList(); 

        return lst_dirigents;
    }


        
  
    /**
     * @return the leDirigent
     */
    public Dirigents getLeDirigent() {
        return leDirigent;
    }

    /**
     * @param leDirigent the leDirigent to set
     */
    public void setLeDirigent(Dirigents leDirigent) {
        this.leDirigent = leDirigent;
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

    /**
     * @return the lesDirigents
     */
    public List<Dirigents> getLesDirigents() {
        return lesDirigents;
    }

    /**
     * @param lesDirigents the lesDirigents to set
     */
    public void setLesDirigents(List<Dirigents> lesDirigents) {
        this.lesDirigents = lesDirigents;
    }
    public HistoriqueDirigent getm_historique() {
		return m_historique;
	}



	public void setm_historique(HistoriqueDirigent m_historique) {
		this.m_historique = m_historique;
	}


}

