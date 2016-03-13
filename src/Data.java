import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Etudiant;

public class Data {

	
	private ObservableList<Etudiant> dataEtudiant = FXCollections.observableArrayList();
	
	
	
	
	public Data(){
		dataEtudiant.add(new Etudiant("B00006","aaa", "bbbb"));
		dataEtudiant.add(new Etudiant("A12516","cccc", "ddd"));

	}
	
	public ObservableList<Etudiant> getDataEtudiant() {
	        return dataEtudiant;
	}
    
}
