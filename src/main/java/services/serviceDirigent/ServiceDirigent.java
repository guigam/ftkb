package services.serviceDirigent;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modeles.Clubs;
import modeles.Dirigents;
import modeles.Historique;

public class ServiceDirigent implements ServiceIterfaceDirigent {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
    
    
    
	/* (non-Javadoc)
	 * @see services.serviceDirigent.ServiceIterfaceDirigent#lstdirigents()
	 */
	@Override
	public List<Dirigents> lstdirigents() {
		 Query query = em.createQuery("from Dirigents");
	        return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see services.serviceDirigent.ServiceIterfaceDirigent#saveDirigent(modeles.Dirigents)
	 */
	@Override
	public void saveDirigent(Dirigents dirigent) {
		em.getTransaction().begin();
		try{
	        em.persist(dirigent);
		}catch (Exception e) {
			em.getTransaction().rollback();
		}
	        em.getTransaction().commit();
		
	}

	
	/* (non-Javadoc)
	 * @see services.serviceDirigent.ServiceIterfaceDirigent#mergeDirigen(modeles.Dirigents)
	 */
	@Override
	public void mergeDirigen(Dirigents dirigent) {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see services.serviceDirigent.ServiceIterfaceDirigent#deleteDirigent(modeles.Dirigents)
	 */
	@Override
	public void deleteDirigent(Dirigents dirigent) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void miseAjourHistorique(Dirigents leDirig, Historique p_HD) {
//	 	Query query = em.createQuery("from HistoriqueDirigent h where h.m_dirigents = 1? and h.dateDebut = ?2 and h.dateFin = ?3");
//    	query.setParameter(1, leDirig);
//    	query.setParameter(2, p_HD.getDateDebut());
//    	query.setParameter(3, p_HD.getDateFin());
////    	HistoriqueDirigent hd = (HistoriqueDirigent) query.getResultList().get(0);
//    	hd.setDateFin(p_HD.getDateDebut());
//    	saveHistorique(hd);
//		
//	}
	public void saveHistorique(Historique hd){
		em.getTransaction().begin();
    	try{
    		em.persist(hd);
    	}catch (Exception e) {
			// TODO: handle exception
    		em.getTransaction().rollback();
		}
    	em.getTransaction().commit();
		
		
	}

	@Override
	public void miseAjourHistorique(Dirigents leDirig, Historique p_HD) {
		// TODO Auto-generated method stub
		
	}


}
