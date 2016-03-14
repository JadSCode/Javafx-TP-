package view;

import app.Data;
import app.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Etudiant;
import util.DateHelper;

public class HomeController {
    @FXML
    private TableView<Etudiant> personTable;
    @FXML
    private TableColumn<Etudiant, String> codeEtudiant;
    @FXML
    private TableColumn<Etudiant, String> nomEtudiant;
    @FXML
    private TableColumn<Etudiant, String> prenomEtudiant;

    @FXML
    private Label codeEtudiantLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label dateDeNaissanceLabel;
    @FXML
    private Label MasterLabel;
    @FXML
    private Label SemestreLabel;

    // Reference to the main application.
    private Main mainApp;
	private Data data;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public HomeController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        codeEtudiant.setCellValueFactory(cellData -> cellData.getValue().getCodeEtudiantProp());
        nomEtudiant.setCellValueFactory(cellData -> cellData.getValue().getNomProp());
        prenomEtudiant.setCellValueFactory(cellData -> cellData.getValue().getPrenomProp());
        showEtudiantDetails(null);
        
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showEtudiantDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Main mainApp, Data dataProvider) {
        this.mainApp = mainApp;
        
        this.data = dataProvider;
        // Add observable list data to the table
        personTable.setItems(this.data.getDataEtudiant());
    }
    
    private void showEtudiantDetails(Etudiant etudiant) {
        if (etudiant != null) {
            
        	codeEtudiantLabel.setText(etudiant.getCodeEtudiant());
        	nomLabel.setText(etudiant.getNom());
        	prenomLabel.setText(etudiant.getPrenom());
        	dateDeNaissanceLabel.setText(DateHelper.format(etudiant.getDateDeNaissance()));
        	MasterLabel.setText(etudiant.getMasterIntitule());
        	SemestreLabel.setText(Integer.toString(etudiant.getSemestreEns()));


        	
        } else {
        	codeEtudiantLabel.setText("");
        	nomLabel.setText("");
        	prenomLabel.setText("");
        	dateDeNaissanceLabel.setText("");
        	MasterLabel.setText("");
        	SemestreLabel.setText("");

        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteEtudiant() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        try {
            personTable.getItems().remove(selectedIndex);

        } catch(ArrayIndexOutOfBoundsException e){
        	
        	Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getMainStage());
            alert.setTitle("Erreur");
            alert.setHeaderText("Aucune personne sélectionnée!");
            alert.setContentText("Veuillez séléctionner une personne !");

            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleNewEtudiant() {
        Etudiant tempEtudiant = new Etudiant();
        boolean okClicked = mainApp.showAjoutEtudiantDialog(tempEtudiant);
        if (okClicked) {
            data.addEtudiant(tempEtudiant);
        }
    }
}