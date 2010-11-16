/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeles;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author guigam
 */
@Entity
public class EntraineurAdjoint extends Acteurs {

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeb;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    private String licence;
    private String degre;
    
   


	public String getDegre() {
		return degre;
	}

	public void setDegre(String degre) {
		this.degre = degre;
	}

	@ManyToOne
    @JoinColumn(name = "club_id")
    private Clubs leClubAdjoint;
    private String grade;
    private boolean  etat;

    /**
     * @return the dateDeb
     */
    public Date getDateDeb() {
        return dateDeb;
    }

    /**
     * @param dateDeb the dateDeb to set
     */
    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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
     * @return the leClubAdjoint
     */
    public Clubs getLeClubAdjoint() {
        return leClubAdjoint;
    }

    /**
     * @param leClubAdjoint the leClubAdjoint to set
     */
    public void setLeClubAdjoint(Clubs leClubAdjoint) {
        this.leClubAdjoint = leClubAdjoint;
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
