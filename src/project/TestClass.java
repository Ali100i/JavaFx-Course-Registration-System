package project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Just a test class to check whether the data is read or not.

public class TestClass extends Application{
	public static Scene scene = new Scene(new MainUI(),800,600);
	public static String title;
	
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		title = "Main";
		primaryStage.setScene(scene);
		primaryStage.setTitle(title);
		primaryStage.show();
	}
	public static void main(String[] args) {
		CommonClass.loadBinaryData();
	      Application.launch(args);
	   }
}
