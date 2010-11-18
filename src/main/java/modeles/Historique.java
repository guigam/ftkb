package modeles;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Historique implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateDebut;
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name="dateFin")
	private Date dateFin;
	private String licence;
	
	
	


	public Historique(){}
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	public Date getDateFin() {
		return dateFin;
	}



	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public String getLicence() {
		return licence;
	}


	public void setLicence(String licence) {
		this.licence = licence;
	}


	
}
