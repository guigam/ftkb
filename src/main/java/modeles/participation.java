/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author guiga
 */
@Entity
public class participation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int poidJoueur;
    private String spec;
    @ManyToOne
    private Joueur leJoueur;

    @ManyToOne
    private Tournois leTournois;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof participation)) {
            return false;
        }
        participation other = (participation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeles.participation[id=" + id + "]";
    }

    /**
     * @return the leJoueur
     */
    public Joueur getLeJoueur() {
        return leJoueur;
    }

    /**
     * @param leJoueur the leJoueur to set
     */
    public void setLeJoueur(Joueur leJoueur) {
        this.leJoueur = leJoueur;
    }

    /**
     * @return the leTournois
     */
    public Tournois getLeTournois() {
        return leTournois;
    }

    /**
     * @param leTournois the leTournois to set
     */
    public void setLeTournois(Tournois leTournois) {
        this.leTournois = leTournois;
    }

    /**
     * @return the poidJoueur
     */
    public int getPoidJoueur() {
        return poidJoueur;
    }

    /**
     * @param poidJoueur the poidJoueur to set
     */
    public void setPoidJoueur(int poidJoueur) {
        this.poidJoueur = poidJoueur;
    }

    /**
     * @return the spec
     */
    public String getSpec() {
        return spec;
    }

    /**
     * @param spec the spec to set
     */
    public void setSpec(String spec) {
        this.spec = spec;
    }

}
