package services.ServiceEntraineurs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modeles.Entraineurs;

public class ServiceEntraineurImpl implements ServiceEntraineur {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
	@Override
	public void saveEntraineur(Entraineurs entrain) {
		 em.getTransaction().begin();
	     em.persist(entrain);
	     em.getTransaction().commit();
		
	}
	@Override
	public List<Entraineurs> lstEntraineur() {
		 Query query = em.createQuery("from Entraineurs e where e.etat <> 1");
	        return query.getResultList();
		
	}
}
