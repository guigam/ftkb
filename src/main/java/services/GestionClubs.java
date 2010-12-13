/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

    
    /**
     * @return the leClub
     */
    public Clubs getLeClub() {
        return leClub;
    }

    /**
     * @param leClub the leClub to set
     */
    public void setLeClub(Clubs leClub) {
        this.leClub = leClub;
    }

    public List<SelectItem> getLstClubsItem() {
		return new ServiceClubImpl().lstClubsItem();
	}

	public void setLstClubsItem(List<SelectItem> lstClubsItem) {
		this.lstClubsItem = lstClubsItem;
		
	}

}
