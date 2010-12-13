package services.ServiceEntraineurs;

import java.util.List;

import modeles.Entraineurs;

public interface ServiceEntraineur {
	
	public void saveEntraineur(Entraineurs entraine);
	
	public abstract List<Entraineurs> lstEntraineur();

}