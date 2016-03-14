package app;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Etudiant;
import view.EtudiantAjoutController;
import view.HomeController;

public class Main extends Application {

	
	private Stage mainStage;
	private BorderPane homePane; 
	
	
	@Override
	public void start(Stage mainStage) {
		this.mainStage = mainStage;
		this.mainStage.setTitle("test");
		launchStage();
		launchHome();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
   private void launchStage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/Main.fxml"));
            homePane = (BorderPane) loader.load();

            Scene scene = new Scene(homePane);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
   private void launchHome() {
       try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(Main.class.getResource("../view/Home.fxml"));
           AnchorPane personOverview = (AnchorPane) loader.load();

           homePane.setCenter(personOverview);
           
           HomeController controller = loader.getController();           
           Data dp = new Data();
           
           controller.setMainApp(this,dp);

           

       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   
   public Stage getMainStage(){
	   return mainStage;
   }

   
   public boolean showAjoutEtudiantDialog(Etudiant person) {
	    try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("../view/EtudiantAjoutDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        
	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Ajouter un nouvel étudiant");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(mainStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        EtudiantAjoutController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setEtudiant(person);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}
