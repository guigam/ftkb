/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeles;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author guigam
 */
@Entity
public class Clubs implements Serializable {
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
    private String nomClub;
    private String adresse;
    private String phone;
    private String fax;
    private String email;
    @OneToMany(mappedBy="leClubEntraineur")
    private List<Entraineurs> lesEntraineur;
    @OneToMany(mappedBy = "leClubDirigent")
    private List<Dirigents> lesDirigents;
    @OneToMany(mappedBy = "leClubJoueur")
    private List<Joueur> lesJoueurs;
    @OneToMany(mappedBy = "leClubAdjoint")
    private List<EntraineurAdjoint> lesEntraineurAdjoint;



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
        if (!(object instanceof Clubs)) {
            return false;
        }
        Clubs other = (Clubs) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeles.Clubs[id=" + getId() + "]";
    }

    /**
     * @return the nomClub
     */
    public String getNomClub() {
        return nomClub;
    }

    /**
     * @param nomClub the nomClub to set
     */
    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the lesEntraineur
     */
    public List<Entraineurs> getLesEntraineur() {
        return lesEntraineur;
    }

    /**
     * @param lesEntraineur the lesEntraineur to set
     */
    public void setLesEntraineur(List<Entraineurs> lesEntraineur) {
        this.setLesEntraineur(lesEntraineur);
    }

   

    /**
     * @return the lesDirigents
     */
    public List<Dirigents> getLesDirigents() {
        return lesDirigents;
    }

    /**
     * @param lesDirigents the lesDirigents to set
     */
    public void setLesDirigents(List<Dirigents> lesDirigents) {
        this.lesDirigents = lesDirigents;
    }

    /**
     * @return the lesJoueurs
     */
    public List<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

    /**
     * @param lesJoueurs the lesJoueurs to set
     */
    public void setLesJoueurs(List<Joueur> lesJoueurs) {
        this.lesJoueurs = lesJoueurs;
    }

    /**
     * @return the lesEntraineurAdjoint
     */
    public List<EntraineurAdjoint> getLesEntraineurAdjoint() {
        return lesEntraineurAdjoint;
    }

    /**
     * @param lesEntraineurAdjoint the lesEntraineurAdjoint to set
     */
    public void setLesEntraineurAdjoint(List<EntraineurAdjoint> lesEntraineurAdjoint) {
        this.lesEntraineurAdjoint = lesEntraineurAdjoint;
    }

    
    

}
