package model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import util.DateHelper;

public class Etudiant extends Personne {

	
	private StringProperty codeEtudiant;
	private StringProperty masterIntitule;
	private IntegerProperty semestreEns;
	
	public Etudiant(StringProperty codeEtudiant, StringProperty nom, StringProperty prenom,ObjectProperty<LocalDate> dateDeNaissance, StringProperty masterIntitule, SimpleIntegerProperty semestreEns) {
		super(nom, prenom, dateDeNaissance);
		this.codeEtudiant = codeEtudiant;
		this.masterIntitule = masterIntitule;
		this.semestreEns = semestreEns;
	}
	
	public Etudiant(String codeEtudiant, String nom, String prenom,LocalDate dateDeNaissance, String masterIntitule, int semestreEns){
		this(new SimpleStringProperty(codeEtudiant), new SimpleStringProperty(nom), new SimpleStringProperty(prenom), new SimpleObjectProperty<LocalDate>(dateDeNaissance), new SimpleStringProperty(masterIntitule), new SimpleIntegerProperty(semestreEns));
	}
	
	public Etudiant(String codeEtudiant, String nom, String prenom) {
		this(codeEtudiant, nom, prenom, DateHelper.parse("01/01/2016"), "--", 0);
	}
	
	public Etudiant(){
		this("", "","");
	}

	
	public String getCodeEtudiant() {
		return codeEtudiant.get();
	}

	public void setCodeEtudiant(String codeEtudiant) {
		this.codeEtudiant.set(codeEtudiant);
	}
	
	
	public StringProperty getCodeEtudiantProp(){
		return codeEtudiant;
	}
	
	
	public String getMasterIntitule() {
		return masterIntitule.get();
	}

	public void setMasterIntitule(String masterIntitule) {
		this.masterIntitule.set(masterIntitule);
	}
	
	
	public StringProperty getMasterIntituleProp(){
		return masterIntitule;
	}
	
	public Integer getSemestreEns() {
		return semestreEns.get();
	}

	public void setSemestreEns(Integer semestreEns) {
		this.semestreEns.set(semestreEns);
	}
	
	
	public IntegerProperty getSemestreEnsProp(){
		return semestreEns;
	}

}
