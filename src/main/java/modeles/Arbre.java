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
import javax.persistence.OneToOne;

/**
 *
 * @author guiga
 */
@Entity
public class Arbre implements Serializable {
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Joueur joueur1;
    @OneToOne
    private Joueur Joueur2;
    private int poidMin;
    private int poindMax;
    private String spec;
    private String resultat;

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
        if (!(object instanceof Arbre)) {
            return false;
        }
        Arbre other = (Arbre) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeles.Arbre[id=" + getId() + "]";
    }

   
    /**
     * @return the resultat
     */
    public String getResultat() {
        return resultat;
    }

    /**
     * @param resultat the resultat to set
     */
    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    /**
     * @return the poidMin
     */
    public int getPoidMin() {
        return poidMin;
    }

    /**
     * @param poidMin the poidMin to set
     */
    public void setPoidMin(int poidMin) {
        this.poidMin = poidMin;
    }

    /**
     * @return the poindMax
     */
    public int getPoindMax() {
        return poindMax;
    }

    /**
     * @param poindMax the poindMax to set
     */
    public void setPoindMax(int poindMax) {
        this.poindMax = poindMax;
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

    /**
     * @return the joueur1
     */
    public Joueur getJoueur1() {
        return joueur1;
    }

    /**
     * @param joueur1 the joueur1 to set
     */
    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    /**
     * @return the Joueur2
     */
    public Joueur getJoueur2() {
        return Joueur2;
    }

    /**
     * @param Joueur2 the Joueur2 to set
     */
    public void setJoueur2(Joueur Joueur2) {
        this.Joueur2 = Joueur2;
    }

    
}
