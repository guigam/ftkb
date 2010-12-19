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

import service.serviceClubImpl;
import services.serviceClub.ServiceClub;
import services.serviceClub.ServiceClubImpl;
import modeles.Clubs;
import modeles.Entraineurs;


/**
 *
 * @author guigam
 */
public class GestionClubs {
    private List<Clubs> lesClubs = new ArrayList<Clubs>();
	private Clubs leClub = new Clubs();
	private List<SelectItem> lstClubsItem = new LinkedList<SelectItem>();
    
	ServiceClub clubSservice; 

     /**
     * @Enregistrer un Cub
     */
    public String saveClub(){
    	clubSservice.saveClub(leClub);
        return "club";
    }

    public List<Clubs> getLesClubs() {
    	return new ServiceClubImpl().lstClubs();
	}



	public void setLesClubs(List<Clubs> lesClubs) {
		this.lesClubs = lesClubs;
	}

    public Object getClubFromID(Integer valueOf) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public List<Clubs> getlistedesClub(){
    	return new serviceClubImpl().getlistedesClubs();
    }
    
    public List<SelectItem> listedesClubItem(){
    	return new serviceClubImpl().listeDesClubsItem();
    }

    public List<SelectItem> getLstClubsItem() {
		return new ServiceClubImpl().lstClubsItem();
	}

	public void setLstClubsItem(List<SelectItem> lstClubsItem) {
		this.lstClubsItem = lstClubsItem;
		
	}

}
