package modeles;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class HistoriqueJoueurs extends Historique {
	
	@ManyToOne
	private Joueur m_Joueur;
	
	public HistoriqueJoueurs(){}

    /**
     * @return the m_Joueur
     */
    public Joueur getM_Joueur() {
        return m_Joueur;
    }

    /**
     * @param m_Joueur the m_Joueur to set
     */
    public void setM_Joueur(Joueur m_Joueur) {
        this.m_Joueur = m_Joueur;
    }
	
	

}
