package model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Personne {
	
	

	
	private final StringProperty nom;
    private final StringProperty prenom;
    private final ObjectProperty<LocalDate> dateDeNaissance;
	
	public Personne(StringProperty name, StringProperty prenom, ObjectProperty<LocalDate> dateDeNaissance){
		
		this.nom = name;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		
	}
	
	public Personne(){
		this(null, null);	
	}
	
	public Personne(StringProperty name, StringProperty prenom){
		this(name, prenom , null);	
	}

	public String getNom() {
		return nom.get();
	}

	public String getPrenom() {
		return prenom.get();
	}


	public LocalDate getDateDeNaissance() {
		return dateDeNaissance.get();
	}

	
	
	public void setNom(String name) {
		this.nom.set(name);
	}

	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}


	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance.set(dateDeNaissance);
	}
	
	
	
	public StringProperty getNomProp(){
		return nom;
	}
	
	public StringProperty getPrenomProp(){
		return prenom;
	}
	
	public ObjectProperty<LocalDate> getDateDeNaissanceProp() {
	     return dateDeNaissance;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [nom=");
		builder.append(nom.get());
		builder.append(", prenom=");
		builder.append(prenom.get());
		builder.append(", dateDeNaissance=");
		builder.append(dateDeNaissance.get());
		builder.append("]");
		return builder.toString();
	}


	
	
	
	

}
