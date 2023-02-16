package rest.entities;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
@ApiModel(description = "entité enrigistrer dans swager")
public class Employees {
String cin;
String nom;
String prenom;
@ApiModelProperty(value = "unique cin")
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
@ApiModelProperty(value = "get nom")
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
@ApiModelProperty(value = "get prenom")
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
@Override
public String toString() {
	return "Employees [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", getCin()=" + getCin() + ", getNom()="
			+ getNom() + ", getPrenom()=" + getPrenom() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}
public Employees(String cin, String nom, String prenom) {
	super();
	this.cin = cin;
	this.nom = nom;
	this.prenom = prenom;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cin == null) ? 0 : cin.hashCode());
	result = prime * result + ((nom == null) ? 0 : nom.hashCode());
	result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employees other = (Employees) obj;
	if (cin == null) {
		if (other.cin != null)
			return false;
	} else if (!cin.equals(other.cin))
		return false;
	if (nom == null) {
		if (other.nom != null)
			return false;
	} else if (!nom.equals(other.nom))
		return false;
	if (prenom == null) {
		if (other.prenom != null)
			return false;
	} else if (!prenom.equals(other.prenom))
		return false;
	return true;
}
public Employees() {
	super();
	// TODO Auto-generated constructor stub
}
}
