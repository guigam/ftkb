package services;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modeles.Dirigents;
import modeles.Historique;
import modeles.Joueur;

public class gestionHistorique {
	 private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
	    private EntityManager em = emf.createEntityManager();
	    static Date dateSysteme = new Date();	    
	    public gestionHistorique(){
	    	
	    }
	public Historique rechercheLicenceCourante(String licence){
		Query query = em.createQuery("from Historique h where h.licence = ?1");
		query.setParameter(1, licence);
		Historique hj = (Historique) query.getSingleResult();
		return hj;
	}
	public List<Historique> licenceCourantduDirigent(Dirigents p_dirigent){
		List<Historique> hd = new LinkedList<Historique>();
		Query rq= em.createQuery("from HistoriqueDirigent h where h.dateFin > ?1 ");
      	rq.setParameter(1,dateSysteme);
		hd =  rq.getResultList();
		return hd;
	}
	
	public void mettreAJourHistoriqueDirigent(Historique p_histoDirigent, Dirigents dirig){
		Query qr = em.createQuery("from HistoriqueDirigent h where h.m_dirigents = ?1 and h.dateFin > ?2");
    	qr.setParameter(1,dirig);
    	qr.setParameter(2, dateSysteme);
    	Historique m_histo = new Historique();
    	m_histo.setDateFin(p_histoDirigent.getDateDebut());
    	m_histo.setLicence(p_histoDirigent.getLicence());
		em.getTransaction().begin();
		em.merge(p_histoDirigent);
		em.getTransaction().commit();		
	}
	public void AjouterHistoriqueDirigent(Historique p_histoDirigent, Dirigents dirig){
		Query qr = em.createQuery("from HistoriqueDirigent h where h.m_dirigents = ?1 and h.dateFin > ?2");
    	qr.setParameter(1,dirig);
    	qr.setParameter(2, dateSysteme);
		em.getTransaction().begin();
		em.persist(p_histoDirigent);
		em.getTransaction().commit();	
	}

	
}
