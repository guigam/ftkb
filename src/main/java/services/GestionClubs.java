/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modeles.Clubs;
import modeles.Entraineurs;


/**
 *
 * @author guigam
 */
public class GestionClubs {
    private List<Clubs> lesClubs = new ArrayList<Clubs>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
    private List<SelectItem> mesClubs = new LinkedList<SelectItem>();    
    private Clubs leClub = new Clubs();

    /** Creates a new instance of GestionClubs */
    public GestionClubs() {
    }

    
    /**
     * @retourner la liste des clubs
     */
    protected void getlisteDesClubs(){
        Query query = getEm().createQuery("from Clubs");

        for (Clubs c : (List<Clubs>) query.getResultList()){
              lesClubs.add(c);
        }
    }

    /**
     * @pour remplir les combo box en Item
     */
    public List<SelectItem> getlisteDesClubsItem(){
        Query query =   em.createQuery("FROM Clubs)");
        List<SelectItem> m_Clubs = new LinkedList<SelectItem>();
        for (Clubs c : (List<Clubs>)query.getResultList()) {
            m_Clubs.add(new SelectItem(c,c.getNomClub()));
        }
        return (List<SelectItem>)m_Clubs;
    }
    
    
    
    /**
     * @Enregistrer un Cub
     */
    public String saveClub(){
        em.getTransaction().begin();
        em.persist(getLeClub());
        em.getTransaction().commit();
        return "club";
    }

    
    /**
     * @return the lesClubs
     */
    public List<Clubs> getLesClubs() {
        getlisteDesClubs();
        return lesClubs;
    }
   
    /**
     * @param lesClubs the lesClubs to set
     */
    public void setLesClubs(List<Clubs> lesClubs) {
        this.lesClubs = lesClubs;
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

    /**
     * @return the mesClubs
     */
    public List<SelectItem> getMesClubs() {
        return mesClubs;
    }

    /**
     * @param mesClubs the mesClubs to set
     */
    public void setMesClubs(List<SelectItem> mesClubs) {
        this.mesClubs = mesClubs;
    }

    public Object getClubFromID(Integer valueOf) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    
    /**
     * @return the leClub
     */
    public Clubs getLeClub() {
        return leClub;
    }

    /**
     * @param leClub the leClub to set
     */
    public void setLeClub(Clubs leClub) {
        this.leClub = leClub;
    }

}
