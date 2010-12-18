package service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import modeles.Clubs;
@Named
@ApplicationScoped
public interface serviceClub {
	
	
public List<Clubs> getlistedesClubs();

public List<SelectItem> listeDesClubsItem();

public String saveClub(Clubs club);
}