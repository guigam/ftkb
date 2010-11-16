package services;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modeles.Dirigents;
import modeles.HistoriqueDirigent;

public class gestionHistorique {
	 private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
	    private EntityManager em = emf.createEntityManager();
	    static Date dateSysteme = new Date();	    
	    public gestionHistorique(){
	    	
	    }
	
	public List<HistoriqueDirigent> licenceCourantduDirigent(Dirigents p_dirigent){
		List<HistoriqueDirigent> hd = new LinkedList<HistoriqueDirigent>();
		Query rq= em.createQuery("from HistoriqueDirigent h where h.dateFin > ?1 ");
      	rq.setParameter(1,dateSysteme);
		hd =  rq.getResultList();
		return hd;
	}
	
	public void mettreAJourHistoriqueDirigent(HistoriqueDirigent p_histoDirigent, Dirigents dirig){
		Query qr = em.createQuery("from HistoriqueDirigent h where h.m_dirigents = ?1 and h.dateFin > ?2");
    	qr.setParameter(1,dirig);
    	qr.setParameter(2, dateSysteme);
    	HistoriqueDirigent m_histo = new HistoriqueDirigent();
    	m_histo.setDateFin(p_histoDirigent.getDateDebut());
    	m_histo.setLicence(p_histoDirigent.getLicence());
		em.getTransaction().begin();
		em.merge(p_histoDirigent);
		em.getTransaction().commit();		
	}
	public void AjouterHistoriqueDirigent(HistoriqueDirigent p_histoDirigent, Dirigents dirig){
		Query qr = em.createQuery("from HistoriqueDirigent h where h.m_dirigents = ?1 and h.dateFin > ?2");
    	qr.setParameter(1,dirig);
    	qr.setParameter(2, dateSysteme);
		em.getTransaction().begin();
		em.persist(p_histoDirigent);
		em.getTransaction().commit();	
	}
	
}
