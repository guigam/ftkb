/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeles;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author guigam
 */
@Entity

public class Personnes implements Serializable {
   

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "adresse", length = 255)
    private String adresse;
    @Column(name = "cin", length = 255)
    private int cin;
    @Column(name = "dns")
    @Temporal(TemporalType.DATE)
    private Date dns;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "nomPrenom", length = 255)
    private String nomPrenom;
    @Column(name = "phone", length = 255)
    private String phone;
    @Column(name = "nationalité", length = 255)
    private String nationalite;

    public Personnes() {
    }

    public Personnes(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    

    public Date getDns() {
        return dns;
    }

    public void setDns(Date dns) {
        this.dns = dns;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        if (!(object instanceof Personnes)) {
            return false;
        }
        Personnes other = (Personnes) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeles.Personnes[id=" + getId() + "]";
    }

    /**
     * @return the cin
     */
    public int getCin() {
        return cin;
    }

    /**
     * @param cin the cin to set
     */
    public void setCin(int cin) {
        this.cin = cin;
    }

    /**
     * @return the nationalite
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * @param nationalite the nationalite to set
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

}
