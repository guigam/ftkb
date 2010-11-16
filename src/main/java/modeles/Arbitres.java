/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeles;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Temporal;

/**
 *
 * @author guigam
 */
@Entity

public  class Arbitres extends Acteurs {

   
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeb;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    private String licence;    
    private String grade;
 

	@ManyToMany
    private List<Tournois> mesTournois;
    private boolean  etat;
    

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
     * @return the mesTournois
     */
    public List<Tournois> getMesTournois() {
        return mesTournois;
    }

    /**
     * @param mesTournois the mesTournois to set
     */
    public void setMesTournois(List<Tournois> mesTournois) {
        this.mesTournois = mesTournois;
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
