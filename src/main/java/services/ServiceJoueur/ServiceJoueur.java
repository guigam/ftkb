package services.ServiceJoueur;

import java.util.List;

import modeles.Joueur;

public interface ServiceJoueur {

	public abstract List<Joueur> lstJoueurs();
	
	public void saveJoueur(Joueur joueur);
	
	public Joueur rechercheJoueurParLicence(String licence);
	
}