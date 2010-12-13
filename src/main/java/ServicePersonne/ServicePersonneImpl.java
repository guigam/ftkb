package ServicePersonne;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modeles.Personnes;

public  class ServicePersonneImpl implements ServicePersonne {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
	
    @Override
	public List<Personnes> listePersonneByCIN(int cin) {
        Query query = em.createQuery("select p from Personnes p where p.cin = ?1 ");
        query.setParameter(1, cin);
        return (List<Personnes>) query.getResultList();
	}

	public void savePersonne(Personnes personne) {
		em.getTransaction().begin();
        em.persist(personne);
        em.getTransaction().commit();    
	}
}
