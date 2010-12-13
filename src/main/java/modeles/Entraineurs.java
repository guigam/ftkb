/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeles;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author guigam
 */
@Entity

public  class Entraineurs extends Acteurs {
 
    private String licence;
    private String grade;
    private String degre;




	public String getDegre() {
		return degre;
	}



	public void setDegre(String degre) {
		this.degre = degre;
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

   
    /**
     * @return the licence
     */
    public String getLicence() {
        return licence;
    }

    /**
     * @param licence the licence to set
     */
    public void setLicence(String licence) {
        this.licence = licence;
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


}
