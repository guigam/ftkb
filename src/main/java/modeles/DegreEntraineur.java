package modeles;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DegreEntraineur implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDegre;	
	private Date dateDebut;
	private Date dateFin;
	@ManyToOne
	private degre degre;
	public degre getDegre() {
		return degre;
	}

	public void setDegre(degre degre) {
		this.degre = degre;
	}

	public Entraineurs getEntraineur() {
		return entraineur;
	}

	public void setEntraineur(Entraineurs entraineur) {
		this.entraineur = entraineur;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	@ManyToOne 
	private Entraineurs entraineur;
	public DegreEntraineur(){}
	
	public int getIdDegre() {
		return idDegre;
	}
	public void setIdDegre(int idDegre) {
		this.idDegre = idDegre;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebu(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
