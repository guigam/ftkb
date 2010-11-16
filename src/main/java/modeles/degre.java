package modeles;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public abstract class degre implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int idDegre;
private String nomDegre;
private String description;


public degre(){}

public int getIdDegre() {
	return idDegre;
}

public void setIdDegre(int idDegre) {
	this.idDegre = idDegre;
}

public String getNomDegre() {
	return nomDegre;
}

public void setNomDegre(String nomDegre) {
	this.nomDegre = nomDegre;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}
}
