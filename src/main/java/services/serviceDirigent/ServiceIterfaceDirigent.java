package services.serviceDirigent;

import java.util.List;

import modeles.Clubs;
import modeles.Dirigents;
import modeles.Historique;

public interface ServiceIterfaceDirigent {

	public abstract List<Dirigents> lstdirigents();

	public abstract void saveDirigent(Dirigents dirigent);

	public abstract void mergeDirigen(Dirigents dirigent);

	public abstract void deleteDirigent(Dirigents dirigent);
	
	void miseAjourHistorique(Dirigents leDirig, Historique p_HD);

}