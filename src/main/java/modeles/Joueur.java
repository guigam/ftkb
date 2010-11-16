/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeles;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author guigam
 */
@Entity


public class Joueur extends Acteurs {
    private String licence;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    private String grade;
    private String categorie;
    
    
    
    public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	@ManyToMany
    private List<specialite> lesSpecialite;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Clubs leClubJoueur;
    @OneToMany(mappedBy= "leJoueur")
    private List<participation> lesParticipations;
    private boolean etat;
    

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
     * @return the lesSpecialite
     */
    public List<specialite> getLesSpecialite() {
        return lesSpecialite;
    }

    /**
     * @param lesSpecialite the lesSpecialite to set
     */
    public void setLesSpecialite(List<specialite> lesSpecialite) {
        this.setLesSpecialite(lesSpecialite);
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
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
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
