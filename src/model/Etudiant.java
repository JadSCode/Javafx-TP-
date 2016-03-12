package model;

public class Etudiant extends Personne {

	
	private String codeEtudiant;
	
	
	public Etudiant(String codeEtudiant, String nom, String prenom, String dateDeNaissance) {
		super(nom, prenom, dateDeNaissance);
		this.codeEtudiant = codeEtudiant;
	}
	
	public Etudiant(String codeEtudiant, String nom, String prenom) {
		this(codeEtudiant, nom, prenom, null);
	}

	
	public String getCodeEtudiant() {
		return codeEtudiant;
	}

	public void setCodeEtudiant(String codeEtudiant) {
		this.codeEtudiant = codeEtudiant;
	}
	
	
	

}
