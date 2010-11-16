/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modeles.Personnes;

/**
 *
 * @author guigam
 */

public class gestionPersonnes {
    private List<Personnes> lesPersonnes = new LinkedList<Personnes>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();
    private Personnes laPersonne = new Personnes();

    /** Creates a new instance of gestionPersonnes */
    public gestionPersonnes() {
    }

 
    public List<Personnes> getlistePersonneByCIN(int cin){
        Query query = getEm().createQuery("select p from Personnes p where p.cin = ?1 ");
            query.setParameter(1, cin);
       lesPersonnes = (List<Personnes>) query.getResultList();

        return getLesPersonnes();
    }



    public void enregistrerPersonne(Personnes unePersonne){
    	em.getTransaction().begin();
        em.persist(unePersonne);
        em.getTransaction().commit();       
    }

    /**
     * @return the laPersonne
     */
    public Personnes getLaPersonne() {
        return laPersonne;
    }

    /**
     * @param laPersonne the laPersonne to set
     */
    public void setLaPersonne(Personnes laPersonne) {
        this.laPersonne = laPersonne;
    }

    /**
     * @return the lesPersonnes
     */
    public List<Personnes> getLesPersonnes() {
        return lesPersonnes;
    }

    /**
     * @param lesPersonnes the lesPersonnes to set
     */
    public void setLesPersonnes(List<Personnes> lesPersonnes) {
        this.setLesPersonnes(lesPersonnes);
    }

    /**
     * @return the emf
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @param emf the emf to set
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
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


   
   
}
