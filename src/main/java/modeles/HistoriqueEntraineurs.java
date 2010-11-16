package modeles;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class HistoriqueEntraineurs extends Historique {
	@ManyToOne
	private Entraineurs m_entraineurs;
	
	public Entraineurs getM_entraineurs() {
		return m_entraineurs;
	}

	public void setM_entraineurs(Entraineurs m_entraineurs) {
		this.m_entraineurs = m_entraineurs;
	}

	public HistoriqueEntraineurs(){}
	
	
	
}
