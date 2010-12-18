package service;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.inject.Qualifier;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modeles.Clubs;
@Named
@ApplicationScoped
public class serviceClubImpl implements serviceClub {
	 
	     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
	    private EntityManager em = emf.createEntityManager();
	    
	 
	    public serviceClubImpl(){}
	    
	   
	    public List<Clubs> getlistedesClubs(){
	        Query query = em.createQuery("from Clubs");
	        return query.getResultList();
	       
	    }

		@Override
		public List<SelectItem> listeDesClubsItem(){
	        Query query =   em.createQuery("FROM Clubs)");
	        List<SelectItem> m_Clubs = new LinkedList<SelectItem>();
	        for (Clubs c : (List<Clubs>)query.getResultList()) {
	            m_Clubs.add(new SelectItem(c,c.getNomClub()));
	        }
	        return (List<SelectItem>)m_Clubs;
	    }

		@Override
		  public String saveClub(Clubs club){
	        em.getTransaction().begin();
	        em.persist(club);
	        em.getTransaction().commit();
	        return "club";
	    }
}
