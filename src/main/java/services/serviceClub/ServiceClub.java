package services.serviceClub;

import java.util.List;

import javax.faces.model.SelectItem;

import modeles.Clubs;

public abstract interface ServiceClub {
	
	public abstract List<Clubs> lstClubs();
	
	public abstract List<SelectItem> lstClubsItem();
	
	public abstract void saveClub(Clubs club);
	
	public abstract void mergeClub(Clubs club);
	
	public abstract void deleteClub(Clubs club);
	

}