package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Etudiant;
import util.DateHelper;

public class EtudiantAjoutController {

	@FXML
    private TextField codeEtudiant;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField dateDeNaissance;
    @FXML
    private TextField Master;
    @FXML
    private TextField Semestre;


    private Stage dialogStage;
    private Etudiant etudiant;
    private boolean okClicked = false;

   
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

 
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
        codeEtudiant.setText("");
        nom.setText("");
        prenom.setText("");
        dateDeNaissance.setText("");
        dateDeNaissance.setPromptText("dd/mm/yyyy");
        Master.setText("");
        Semestre.setText("");
    }

    
    public boolean isOkClicked() {
        return okClicked;
    }

    
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            etudiant.setCodeEtudiant(codeEtudiant.getText());
            etudiant.setNom(nom.getText());
            etudiant.setPrenom(prenom.getText());
            etudiant.setDateDeNaissance(DateHelper.parse(dateDeNaissance.getText()));
            etudiant.setMasterIntitule(Master.getText());
            etudiant.setSemestreEns(Integer.parseInt(Semestre.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

   
    private boolean isInputValid() {
        String errorMessage = "";
        
        if (nom.getText() == null || nom.getText().length() == 0) {
            errorMessage += "Nom invalide !\n";
        }
        if (prenom.getText() == null || prenom.getText().length() == 0) {
            errorMessage += "Prenom invalide !\n";
        }
        if (dateDeNaissance.getText() == null || dateDeNaissance.getText().length() == 0) {
            errorMessage += "Date de naissance invalide !\n";
        } else {
        	if (!DateHelper.validDate(dateDeNaissance.getText())) {
                errorMessage += "Date de naissance invalide :  dd/MM/yyyy !\n";
            }
        }

        if (Master.getText() == null || Master.getText().length() == 0) {
            errorMessage += "Master invalide !\n";
        }

        if (Semestre.getText() == null || Semestre.getText().length() == 0) {
            errorMessage += "Semestre invalude!\n";
        }  else {
        	
        	int sem = Integer.parseInt(Semestre.getText());
        	if(sem < 0 || sem > 4){
        		errorMessage += "Semestre invalide !\n";
        	}
        	
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Champs invalides !!");
            alert.setHeaderText("Veuillez corriger les erreurs suivants :");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}