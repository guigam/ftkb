/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;


import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modeles.Joueur;
import modeles.specialite;

/**
 *
 * @author guigam
 */

public class GestionSpecialite {
   private List<specialite> lesSpecialites = new LinkedList<specialite>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
    /** Creates a new instance of GestionSpecialite */
    public GestionSpecialite() {
    }


    

     public List<SelectItem> getlistSpecialiteItem(){
             Query query = em.createQuery("select s from specialite s ");
                LinkedList<SelectItem> lesSpecia = new LinkedList<SelectItem>();
            for (specialite s : (List<specialite>)query.getResultList()) {
            lesSpecia.add(new SelectItem(s, s.getNomSpecialite()));
        }
                      return (List<SelectItem>) lesSpecia;

        }
      
     public List<SelectItem> lsSpecialiteduJoueur(Joueur joueur){
     	List<SelectItem> listSpecialite = new LinkedList<SelectItem>(); 
     	for(specialite s : joueur.getLesSpecialite()){
     		listSpecialite.add(new SelectItem(s, s.getNomSpecialite()));
     	}
     	return listSpecialite;
     }

    public Object getspecFromID(Integer valueOf) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
