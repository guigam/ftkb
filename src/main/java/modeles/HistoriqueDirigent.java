package modeles;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Entity
public class HistoriqueDirigent extends Historique {
	
	@ManyToOne
	private Dirigents m_dirigents;
	
	public HistoriqueDirigent(){}
	
	
	
	public Dirigents getM_dirigents() {
		return m_dirigents;
	}

	

	public void setM_dirigents(Dirigents m_dirigents) {
		this.m_dirigents = m_dirigents;
	}



	
	
	
	
	


	
}
