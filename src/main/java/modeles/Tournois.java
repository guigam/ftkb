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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author guiga
 */
@Entity
public class Tournois implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomTournois;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateTournois;
    private String endroit;
   
    
    @ManyToMany(mappedBy = "mesTournois")
    private List<Arbitres> lesArbitres;
    @OneToMany(mappedBy = "leTournois")
    private List<participation> lesParticipations;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tournois)) {
            return false;
        }
        Tournois other = (Tournois) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeles.Tournois[id=" + getId() + "]";
    }

    /**
     * @return the nomTournois
     */
    public String getNomTournois() {
        return nomTournois;
    }

    /**
     * @param nomTournois the nomTournois to set
     */
    public void setNomTournois(String nomTournois) {
        this.nomTournois = nomTournois;
    }

    /**
     * @return the dateTournois
     */
    public Date getDateTournois() {
        return dateTournois;
    }

    /**
     * @param dateTournois the dateTournois to set
     */
    public void setDateTournois(Date dateTournois) {
        this.dateTournois = dateTournois;
    }

    /**
     * @return the endroit
     */
    public String getEndroit() {
        return endroit;
    }

    /**
     * @param endroit the endroit to set
     */
    public void setEndroit(String endroit) {
        this.endroit = endroit;
    }

   

    /**
     * @return the lesArbitres
     */
    public List<Arbitres> getLesArbitres() {
        return lesArbitres;
    }

    /**
     * @param lesArbitres the lesArbitres to set
     */
    public void setLesArbitres(List<Arbitres> lesArbitres) {
        this.lesArbitres = lesArbitres;
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

        

}
