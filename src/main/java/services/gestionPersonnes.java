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

import ServicePersonne.ServicePersonneImpl;
import modeles.Personnes;

/**
 *
 * @author guigam
 */

public class gestionPersonnes {
   

    /** Creates a new instance of gestionPersonnes */
    public gestionPersonnes() {
    }

 
    public List<Personnes> getlistePersonneByCIN(int cin){        
       return  new ServicePersonneImpl().listePersonneByCIN(cin);
    }



    public void enregistrerPersonne(Personnes personne){
    	new ServicePersonneImpl().savePersonne(personne); 
		
    }




   
   
}
