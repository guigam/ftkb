/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.FacesContext;

import modeles.Clubs;
import modeles.Dirigents;
import modeles.Historique;
import modeles.Personnes;
import services.serviceDirigent.ServiceDirigent;
import service.*;

/**
 *
 * @author guiga
 */
public class GestionDirigent {
	private List<Personnes> lstPersonnes = new LinkedList<Personnes>();
	private Dirigents leDirigent = new Dirigents();
    private List<Dirigents> lesDirigents = new LinkedList<Dirigents>();
    private Personnes laPersonnes = new Personnes();
    private Clubs monClub = new Clubs();
    private Historique m_historique = new Historique();
	static Date dateSysteme = new Date();
	
	
	gestionPersonnes gspersonne = (gestionPersonnes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("gestionpersonne");

	/** Creates a new instance of GestionDirigent */
    public GestionDirigent() {
    }

//    public List<Personnes> listePersonneByCIN() {
//       lstPersonnes = new gestionPersonnes().getlistePersonneByCIN(getLaPersonnes().getCin());
//       return lstPersonnes;
//    }
    
    public String saveDirigent() {
    	  //on crée un nouveau dirigent
    	List<Historique> lstHD = new LinkedList<Historique>();
    	Calendar c = Calendar.getInstance();
    	c.set(3000, 11, 30);
    	m_historique.setDateFin(c.getTime());
    	lstHD.add(m_historique);
    	leDirigent.setLst_histoDirigents(lstHD);
        leDirigent.setLaPersonne(gspersonne.getLstpersonne().get(0));      
        new ServiceDirigent().saveDirigent(leDirigent);
        return "listDirigents";
    }

    public void miseAjourHistorique(Dirigents leDirig, Historique p_HD){
    	new ServiceDirigent().miseAjourHistorique(leDirig, p_HD);
    }	
    
    public String saveDirigentEtPersonne(){
        new gestionPersonnes().enregistrerPersonne(laPersonnes);
        saveDirigent();
        return "listDirigents";
    }

     public List<Dirigents> getlisDesDirigents() {
        return new ServiceDirigent().lstdirigents();
    }

    /**
     * @return the leDirigent
     */
    public Dirigents getLeDirigent() {
        return leDirigent;
    }

    /**
     * @param leDirigent the leDirigent to set
     */
    public void setLeDirigent(Dirigents leDirigent) {
        this.leDirigent = leDirigent;
    }


    /**
     * @return the laPersonnes
     */
    public Personnes getLaPersonnes() {
        return laPersonnes;
    }

    /**
     * @param laPersonnes the laPersonnes to set
     */
    public void setLaPersonnes(Personnes laPersonnes) {
        this.laPersonnes = laPersonnes;
    }

    /**
     * @return the monClub
     */
    public Clubs getMonClub() {
        return monClub;
    }

    /**
     * @param monClub the monClub to set
     */
    public void setMonClub(Clubs monClub) {
        this.monClub = monClub;
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
 

    public List<Personnes> getLstPersonnes() {
		return lstPersonnes;
	}

	public void setLstPersonnes(List<Personnes> lstPersonnes) {
		this.lstPersonnes = lstPersonnes;
	}
	
    public Historique getM_historique() {
		return m_historique;
	}

	public void setM_historique(Historique m_historique) {
		this.m_historique = m_historique;
	}
}

