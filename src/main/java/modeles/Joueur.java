/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeles;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author guigam
 */
@Entity


public class Joueur extends Acteurs {
 
    private String grade;
    private String categorie;


	@ManyToMany
    private List<specialite> lesSpecialite = new LinkedList<specialite>();
  

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Clubs leClubJoueur;
    @OneToMany(mappedBy= "leJoueur")
    private List<participation> lesParticipations = new LinkedList<participation>();
    private boolean etat;
    
    @OneToMany(cascade=CascadeType.ALL)
    public List<Historique> lsthistoriqueJoueur = new LinkedList<Historique>();


	@Transient
    public Historique getCurrentHistorique() {
    	Date now = new Date();
    	if (lsthistoriqueJoueur.size() > 0) {
    		for (Historique hj : lsthistoriqueJoueur) {
    			if (hj.getDateDebut().compareTo(now)<=0 && hj.getDateFin().compareTo(now)>=0)
    				return hj;
    		}
    	}
    		
    	return null;
    }



    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

   

    /**
     * @return the leClubJoueur
     */
    public Clubs getLeClubJoueur() {
        return leClubJoueur;
    }

    /**
     * @param leClubJoueur the leClubJoueur to set
     */
    public void setLeClubJoueur(Clubs leClubJoueur) {
        this.leClubJoueur = leClubJoueur;
    }


    /**
     * @return the lesParticipations
     */
    public List<participation> getLesParticipations() {
        return lesParticipations;
    }

    /**
     * @param lesParticipations the lesParticipations to set
     */
    public void setLesParticipations(List<participation> lesParticipations) {
        this.lesParticipations = lesParticipations;
    }



    /**
     * @return the etat
     */
    public boolean isEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    
    
    
    public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}    



    public List<Historique> getLsthistoriqueJoueur() {
		return lsthistoriqueJoueur;
	}

	public void setLsthistoriqueJoueur(List<Historique> lsthistoriqueJoueur) {
		this.lsthistoriqueJoueur = lsthistoriqueJoueur;
	}
	
	public List<specialite> getLesSpecialite() {
			return lesSpecialite;
		}

		public void setLesSpecialite(List<specialite> lesSpecialite) {
			this.lesSpecialite = lesSpecialite;
		}
}
