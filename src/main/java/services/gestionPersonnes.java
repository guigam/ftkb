/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import modeles.Personnes;
import ServicePersonne.ServicePersonneImpl;

/**
 *
 * @author guigam
 */

public class gestionPersonnes {
   private int cin = 0;
   private List<Personnes> lstpersonne = new LinkedList<Personnes>();






	public List<Personnes> getLstpersonne() {
	return lstpersonne;
}


public void setLstpersonne(List<Personnes> lstpersonne) {
	this.lstpersonne = lstpersonne;
}


	/** Creates a new instance of gestionPersonnes */
    public gestionPersonnes() {
    }

 
//    public List<Personnes> getlistePersonneByCIN(int cin){        
//       return  new ServicePersonneImpl().listePersonneByCIN(cin);
//    }
    public List<Personnes> listePersonneByCIN(){        
          lstpersonne =  new ServicePersonneImpl().listePersonneByCIN(cin);
          return lstpersonne;
     }



    public void enregistrerPersonne(Personnes personne){
    	new ServicePersonneImpl().savePersonne(personne); 
		
    }

 
	public int getCin() {
	return cin;
}


public void setCin(int cin) {
	this.cin = cin;
}
   
   
}
