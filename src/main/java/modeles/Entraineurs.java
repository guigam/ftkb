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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author guigam
 */
@Entity

public  class Entraineurs extends Acteurs {
 
  
    private String grade;
    private String degre;
    @OneToMany(cascade=CascadeType.ALL)
	private List<Historique> lsthistoriqueEntraineur = new LinkedList<Historique>();


	@Transient
    public Historique getCurrentHistorique() {
    	Date now = new Date();
    	if (getLsthistoriqueEntraineur().size() > 0) {
    		for (Historique hj : getLsthistoriqueEntraineur()) {
    			if (hj.getDateDebut().compareTo(now)<=0 && hj.getDateFin().compareTo(now)>=0)
    				return hj;
    		}
    	}
    		
    	return null;
    }



	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="club_id")
    private Clubs leClubEntraineur;
    private boolean etat;
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    

    @Override
    public String toString() {
        return "modeles.NewEntity[id=" + getId() + "]";
    }


	public String getDegre() {
		return degre;
	}

	public void setDegre(String degre) {
		this.degre = degre;
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
     * @return the leClubEntraineur
     */
    public Clubs getLeClubEntraineur() {
        return leClubEntraineur;
    }

    /**
     * @param leClubEntraineur the leClubEntraineur to set
     */
    public void setLeClubEntraineur(Clubs leClubEntraineur) {
        this.leClubEntraineur = leClubEntraineur;
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



	public void setLsthistoriqueEntraineur(List<Historique> lsthistoriqueEntraineur) {
		this.lsthistoriqueEntraineur = lsthistoriqueEntraineur;
	}



	public List<Historique> getLsthistoriqueEntraineur() {
		return lsthistoriqueEntraineur;
	}




}
