package view;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import app.Main;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Marco Jakob
 */
public class MainController {

    private Main mainApp;

    
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

   
  
   
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Système de gestion de masters");
        alert.setHeaderText("A propos : ");
        alert.setContentText("J.Boudouar , Master IAO 2016");

        alert.showAndWait();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
