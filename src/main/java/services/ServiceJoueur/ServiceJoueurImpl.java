package services.ServiceJoueur;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modeles.Historique;
import modeles.Joueur;

public class ServiceJoueurImpl implements ServiceJoueur {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
	
    @Override
	public List<Joueur> lstJoueurs() {
		Query query = em.createQuery("select j from Joueur j where j.etat <> 1");
        return query.getResultList();
	}

	@Override
	public void saveJoueur(Joueur joueur) {
		em.getTransaction().begin();
		try{
        em.persist(joueur);
        }catch (Exception e) {
			em.getTransaction().rollback();
		}
        em.getTransaction().commit();

		
	}

	@Override
	public Joueur rechercheJoueurParLicence(String licence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Joueur> ListeDesJoueurActifs() {
		Date now = new Date();
		Query query = em.createQuery("from Joueur j where j.etat = 0  ");
		List<Joueur> lstJuoeur = new LinkedList<Joueur>();
		for(Joueur j : (List<Joueur>)query.getResultList()){
			for(Historique historique : j.getLsthistoriqueJoueur()){
				if (historique.getDateDebut().compareTo(now)<=0 && historique.getDateFin().compareTo(now)>=0){
					lstJuoeur.add(j);
				}
			}
			
		}
		return lstJuoeur;
	}

//	@Override
//	public Joueur rechercheJoueurParLicence(String licence) {
//		  Query query = em.createQuery("from HistoriqueJoueurs h where h.licence= ?1 ");
//	        query.setParameter(1, licence);
////	         HistoriqueJoueurs hj =  (HistoriqueJoueurs) query.getResultList().get(0);
//		return (Joueur)hj.getM_Joueur();
//	}
}
