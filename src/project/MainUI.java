package project;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MainUI extends BorderPane {
	 
	 
   public MainUI() {
	   Button viewCourse = new Button("View Course");
	   Button StudentsDetails = new Button("View Students Details");
	   Button Save = new Button("Save");
		 
	   HBox hbox = new HBox();
	   hbox.setAlignment(Pos.CENTER);
	   hbox.getChildren().addAll(viewCourse,StudentsDetails,Save);
	   hbox.setSpacing(10);
	   Label lbl = new Label("Registration System");
	   Font font1 = Font.font("Verdana", FontWeight.BOLD, null, 25);
	   lbl.setFont(font1);
	   
	   
	   setCenter(lbl);
	   setBottom(hbox);
	   
		viewCourse.setOnAction(e->{
			TestClass.scene.setRoot(new CoursesUI());
		});
		StudentsDetails.setOnAction(e->{
			TestClass.scene.setRoot(new studentsUI());
		});
	   
   }
  
   
 }