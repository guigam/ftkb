package ServicePersonne;

import java.util.List;

import modeles.Personnes;

public interface ServicePersonne {

	
	public abstract List<Personnes> listePersonneByCIN(int cin);
	
	public abstract void savePersonne(Personnes personne);
 }