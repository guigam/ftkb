/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modeles.Arbre;
import modeles.Joueur;
import modeles.Poid;
import modeles.Tournois;
import modeles.participation;
import modeles.specialite;
import org.richfaces.component.UIDataTable;


/**
 *
 * @author guiga
 */
public class GestionCompetition {
    private Joueur leJoueur = new Joueur();
	private participation m_participation = new participation();
    private Tournois m_Tournoi = new Tournois();
    private List<Tournois> l_tournois = new LinkedList<Tournois>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
    private UIDataTable dataTable;
    private Arbre m_arbre = new Arbre();

    /** Creates a new instance of GestionCompetition */
    public GestionCompetition() {
    }


    public List<Tournois> getlistDesTournois(){
        Query query = em.createQuery("from Tournois");
        l_tournois = query.getResultList();
        return l_tournois;
    }
    public String DetailTournois(){
        m_Tournoi = (Tournois) dataTable.getRowData();
        
        return "detailTournois";
    }


    public String saveJoueurAffectation(){
        m_participation.setLeJoueur(leJoueur);
        m_participation.setLeTournois(m_Tournoi);
        em.getTransaction().begin();
        em.persist(m_participation);
        em.getTransaction().commit();
        
        return "detailTournois";
    }

    public String saveTournois(){
        em.getTransaction().begin();
        em.persist(m_Tournoi);
        em.getTransaction().commit();
        return "listTournois";
    }

    public List<SelectItem> getspecialiteduJoueur(){
    	return new GestionSpecialite().lsSpecialiteduJoueur(leJoueur);
    }
    
    public void joueurChoisit(){
    	leJoueur = (Joueur) dataTable.getRowData();
    	
    }
    
    public String genererArbre(){ 
        
       List<specialite> lesSpec=  em.createQuery("from specialite s ").getResultList();        
       List<Poid> lespoids = (List<Poid>) em.createQuery("select p from Poid p").getResultList();
    
        for (specialite s : lesSpec){
                  for(Poid p : lespoids){
                      List<participation> lesparticip = new LinkedList<participation>();
                       int test = 0;
                       Joueur j1 = null;
                       Joueur j2 = null;
                      Query query = em.createQuery("select p from participation p where p.leTournois = ?1 and p.spec = ?2 and p.poidJoueur <= ?3 and p.poidJoueur >= ?4");
                      query.setParameter(1, m_Tournoi);
                      query.setParameter(2, s.getNomSpecialite());
                      query.setParameter(3, p.getMaxpoid());
                      query.setParameter(4, p.getMinPoid());
                      lesparticip = query.getResultList();
                     participation p1 = null;
                     participation p2 = null;
                    	   for(Iterator<participation> particip = lesparticip.iterator(); particip.hasNext();){
                            m_arbre = new Arbre();
                            if(particip.hasNext()){
                            if(p1==null){
                            	p1 = particip.next();
                            }else {
                            	p2 = particip.next();
                            	 m_arbre.setJoueur1(p1.getLeJoueur());
                                 m_arbre.setJoueur2(p2.getLeJoueur());
                                 m_arbre.setPoidMin(p.getMinPoid());
                                 m_arbre.setPoindMax(p.getMaxpoid());
                                 m_arbre.setSpec(s.getNomSpecialite());
                                 em.getTransaction().begin();
                                 em.persist(m_arbre);
                                 em.getTransaction().commit();
                            }
                            }else{
                            	
                            	
                            }
                            
                     
                       
                      }

                      

                  }
        }
        return null;
    }



    /**
     * @return the m_Tournoi
     */
    public Tournois getM_Tournoi() {
        return m_Tournoi;
    }

    /**
     * @param m_Tournoi the m_Tournoi to set
     */
    public void setM_Tournoi(Tournois m_Tournoi) {
        this.m_Tournoi = m_Tournoi;
    }

    /**
     * @return the l_tournois
     */
    public List<Tournois> getL_tournois() {
        return l_tournois;
    }

    /**
     * @param l_tournois the l_tournois to set
     */
    public void setL_tournois(List<Tournois> l_tournois) {
        this.l_tournois = l_tournois;
    }

    /**
     * @return the dataTable
     */
    public UIDataTable getDataTable() {
        return dataTable;
    }

    /**
     * @param dataTable the dataTable to set
     */
    public void setDataTable(UIDataTable dataTable) {
        this.dataTable = dataTable;
    }

    /**
     * @return the leJoueur
     */
    public Joueur getLeJoueur() {
        return leJoueur;
    }

    /**
     * @param leJoueur the leJoueur to set
     */
    public void setLeJoueur(Joueur leJoueur) {
        this.leJoueur = leJoueur;
    }

    /**
     * @return the m_participation
     */
    public participation getM_participation() {
        return m_participation;
    }

    /**
     * @param m_participation the m_participation to set
     */
    public void setM_participation(participation m_participation) {
        this.m_participation = m_participation;
    }

}
