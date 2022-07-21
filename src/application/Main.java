package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// This is Main View Class. It impements Observer as well
						
			
			
						StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("HomeMenu.fxml"));
						
						
						
						
						
						
						
						
						Scene scene = new Scene(root,900,600);
					
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						primaryStage.setScene(scene);
						//primaryStage.setResizable(false);
						
						primaryStage.setMinWidth(500);
						primaryStage.setMinHeight(530);
						
						
						primaryStage.setMaxWidth(970);
						primaryStage.setMaxHeight(680);
						
						primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
