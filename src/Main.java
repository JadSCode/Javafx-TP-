
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
            loader.setLocation(Main.class.getResource("view/Main.fxml"));
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
           loader.setLocation(Main.class.getResource("view/Home.fxml"));
           AnchorPane personOverview = (AnchorPane) loader.load();

           homePane.setCenter(personOverview);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   
   public Stage getMainStage(){
	   return mainStage;
   }

}
