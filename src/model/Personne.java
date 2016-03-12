package model;

public class Personne {
	
	
	private String nom;
	private String prenom;
	private String dateDeNaissance;
	
	
	
	public Personne(String name, String prenom, String dateDeNaissance){
		
		this.nom = name;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		
	}
	
	public Personne(String name, String prenom){
		this(name, prenom , null);	
	}

	public String getName() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}



	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	
	
	public void setName(String name) {
		this.nom = name;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	
	
	

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", dateDeNaissance=");
		builder.append(dateDeNaissance);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	

}
