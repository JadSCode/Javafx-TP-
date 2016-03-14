package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Etudiant;

public class DataSet {

	
	private ObservableList<Etudiant> dataEtudiant = FXCollections.observableArrayList();
	
	
	
	
	public DataSet(){
		dataEtudiant.add(new Etudiant("B00006","aaa", "bbbb"));
		dataEtudiant.add(new Etudiant("A12516","cccc", "ddd"));
		dataEtudiant.add(new Etudiant("A12516","jaouad", "ddd"));

	}
	
	public ObservableList<Etudiant> getDataEtudiant() {
	        return dataEtudiant;
	}
	
	public void addEtudiant(Etudiant e){
		dataEtudiant.add(e);
	}
    
}
