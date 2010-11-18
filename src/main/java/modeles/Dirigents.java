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
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author guigam
 */
@Entity

public  class Dirigents extends Acteurs {    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Clubs leClubDirigent;
    private boolean etat;
    @OneToMany(mappedBy="m_dirigents")
    private List<HistoriqueDirigent> lst_histoDirigents;
    
    @Transient
    public HistoriqueDirigent getCurrentHistorique() {
    	Date now = new Date();
    	if (lst_histoDirigents.size() > 0) {
    		for (HistoriqueDirigent hd : lst_histoDirigents) {
    			if (hd.getDateDebut().compareTo(now)<0 && hd.getDateFin().compareTo(now)>0)
    				return hd;
    		}
    	}
    		
    	return null;
    }
    
    public void setCurrentHistorique(HistoriqueDirigent h) {
    	
    }


	@Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    

    public List<HistoriqueDirigent> getLst_histoDirigents() {
		return lst_histoDirigents;
	}



	public void setLst_histoDirigents(List<HistoriqueDirigent> lst_histoDirigents) {
		this.lst_histoDirigents = lst_histoDirigents;
	}



	@Override
    public String toString() {
        return "modeles.NewEntity[id=" + getId() + "]";
    }

   
    /**
     * @return the leClubDirigent
     */
    public Clubs getLeClubDirigent() {
        return leClubDirigent;
    }

    /**
     * @param leClubDirigent the leClubDirigent to set
     */
    public void setLeClubDirigent(Clubs leClubDirigent) {
        this.leClubDirigent = leClubDirigent;
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
