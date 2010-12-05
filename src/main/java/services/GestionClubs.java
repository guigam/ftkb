/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import service.serviceClub;
import modeles.Clubs;
import modeles.Entraineurs;


/**
 *
 * @author guigam
 */
public class GestionClubs {
	   
    

	private Clubs leClub = new Clubs();
    @Inject
    private serviceClub serviceDuClub;

    /** Creates a new instance of GestionClubs */
    public GestionClubs() {
    }

    public String getsaveClub(){
    	serviceDuClub.saveClub(leClub);
    	return "";
    }
    
    public List<Clubs> getlistedesClub(){
    	return serviceDuClub.getlistedesClubs();
    }
    
    public List<SelectItem> listedesClubItem(){
    	return serviceDuClub.listeDesClubsItem();
    }

    
    public Clubs getLeClub() {
		return leClub;
	}

	public void setLeClub(Clubs leClub) {
		this.leClub = leClub;
	}
}
