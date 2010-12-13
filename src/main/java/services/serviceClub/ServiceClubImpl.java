package services.serviceClub;

import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modeles.Clubs;

public class ServiceClubImpl implements ServiceClub {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
    
	@Override
	public List<Clubs> lstClubs() {
		 Query query = em.createQuery("from Clubs");
	        return query.getResultList();
	}

	@Override
	public void saveClub(Clubs club) {
		em.getTransaction().begin();
		try{
	        em.persist(club);
		}catch (Exception e) {
			em.getTransaction().rollback();
		}
	        em.getTransaction().commit();
		
	}

	@Override
	public void mergeClub(Clubs club) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClub(Clubs club) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SelectItem> lstClubsItem() {
		 Query query =   em.createQuery("FROM Clubs)");
	        List<SelectItem> m_Clubs = new LinkedList<SelectItem>();
	        for (Clubs c : (List<Clubs>)query.getResultList()) {
	            m_Clubs.add(new SelectItem(c,c.getNomClub()));
	        }
	        return (List<SelectItem>)m_Clubs;
	}

}
