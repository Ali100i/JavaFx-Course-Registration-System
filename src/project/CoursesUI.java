package project;


import java.util.ArrayList;

// Listing 14.8 FontDemo.java
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

 public class CoursesUI extends BorderPane {
	 private int Index = -1;
    
	 public CoursesUI() {
		 
		 ArrayList<String> Status = new ArrayList<>();
		 
		 Status.add("closed");
		 Status.add("opend");
		 
		 ListView<String> Courses = new ListView(FXCollections.observableArrayList());
		 ListView<String> Students = new ListView(FXCollections.observableArrayList());
		 TextField id = new TextField();
		 TextField name = new TextField();
		 TextField days = new TextField();
		 TextField location = new TextField();
		 TextField time = new TextField();
		 ComboBox<String> cbo = new ComboBox<String>(FXCollections.observableArrayList(Status));
		 Button back = new Button("Back");
		 Button previous = new Button("< Previous");
		 Button next = new Button("Next >");
		 Button search = new Button("Search");
		 
		 
	   for(int i=0; i<CommonClass.courseList.size();i++) {
		   Courses.getItems().add(CommonClass.courseList.get(i).getCourseID());
	   }
	   
	   
	   VBox vboxL = new VBox();
	   VBox vboxR = new VBox();
	   VBox vboxC = new VBox();
	   
	   vboxL.getChildren().add(Courses);
	   vboxR.getChildren().add(Students);
	   
	   HBox hbox1 = new HBox();
	   HBox hbox2 = new HBox();
	   HBox hbox3 = new HBox();
	   HBox hbox4 = new HBox();
	   HBox hbox5 = new HBox();
	   HBox hbox6 = new HBox();
	   HBox hbox7 = new HBox();
	   
	   Label lbl1 = new Label("ID");
	   Label lbl2 = new Label("Name");
	   Label lbl3 = new Label("Days");
	   Label lbl4 = new Label("Location");
	   Label lbl5 = new Label("Time");
	   Label lbl6 = new Label("Status");
	   
	   hbox1.getChildren().addAll(lbl1,id);
	   hbox2.getChildren().addAll(lbl2,name);
	   hbox3.getChildren().addAll(lbl3,days);
	   hbox4.getChildren().addAll(lbl4,location);
	   hbox5.getChildren().addAll(lbl5,time);
	   hbox6.getChildren().addAll(lbl6,cbo);
	   hbox7.getChildren().addAll(back,previous,next,search);
	   
	   hbox7.setAlignment(Pos.CENTER);
	   hbox7.setSpacing(10);
	   
	   hbox1.setPadding(new Insets(10,10,10,10));
	   hbox1.setSpacing(55);
	   hbox2.setPadding(new Insets(10,10,10,10));
	   hbox2.setSpacing(35);
	   hbox3.setPadding(new Insets(10,10,10,10));
	   hbox3.setSpacing(40);
	   hbox4.setPadding(new Insets(10,10,10,10));
	   hbox4.setSpacing(20);
	   hbox5.setPadding(new Insets(10,10,10,10));
	   hbox5.setSpacing(40);
	   hbox6.setPadding(new Insets(10,10,10,10));
	   hbox6.setSpacing(40);
	   vboxC.getChildren().addAll(hbox1,hbox2,hbox3,hbox4,hbox5,hbox6);
	   
		back.setOnAction(e->{
			TestClass.scene.setRoot(new MainUI());
		});
		previous.setOnAction(e->{
			if (Index > 0) 
				Index--;
			
			else 
				Index = CommonClass.courseList.size() - 1;
			
			Students.getItems().clear();
			Courses.getSelectionModel().select(Index);
			id.setText(CommonClass.courseList.get(Index).getCourseID());
			name.setText(CommonClass.courseList.get(Index).getCourseName());
			days.setText(CommonClass.courseList.get(Index).getCourseDays());
			location.setText(CommonClass.courseList.get(Index).getCourseLocation());
			time.setText(CommonClass.courseList.get(Index).getCourseTime());
			for (int i = 0; i<CommonClass.studentList.size(); i++) 
				if (CommonClass.studentList.get(i).getCourses().contains(CommonClass.courseList.get(Index))) 
					Students.getItems().add(CommonClass.studentList.get(i).getStudID());
				
			
			Label numberRegistered = new Label("There are " + Students.getItems().size() + " students registered in " + CommonClass.courseList.get(Index).getCourseID());
			setTop(numberRegistered);
			
			if (CommonClass.courseList.get(Index).getAvailableSeats() == 0) 
				cbo.getSelectionModel().select(0);
			else
				cbo.getSelectionModel().select(1);
		});
		next.setOnAction(e->{
			if (Index < CommonClass.courseList.size()-1) {
				Index++;
			}
			else {
				Index = 0;
			}
			Students.getItems().clear();
			Courses.getSelectionModel().select(Index);
			id.setText(CommonClass.courseList.get(Index).getCourseID());
			name.setText(CommonClass.courseList.get(Index).getCourseName());
			days.setText(CommonClass.courseList.get(Index).getCourseDays());
			location.setText(CommonClass.courseList.get(Index).getCourseLocation());
			time.setText(CommonClass.courseList.get(Index).getCourseTime());
			for (int i = 0; i<CommonClass.studentList.size(); i++) 
				if (CommonClass.studentList.get(i).getCourses().contains(CommonClass.courseList.get(Index))) 
					Students.getItems().add(CommonClass.studentList.get(i).getStudID());
				
			
			Label numberRegistered = new Label("There are " + Students.getItems().size() + " students registered in " + CommonClass.courseList.get(Index).getCourseID());
			setTop(numberRegistered);
			
			if (CommonClass.courseList.get(Index).getAvailableSeats() == 0) 
				cbo.getSelectionModel().select(0);
			else
				cbo.getSelectionModel().select(1);
	
		});
		search.setOnAction(e->{
			Students.getItems().clear();
			 if (Courses.getItems().contains(id.getText().toUpperCase())){
				 for (int i=0;i<CommonClass.courseList.size();i++) {
					 if(id.getText().toUpperCase().equals(CommonClass.courseList.get(i).getCourseID())) {
						 name.setText(CommonClass.courseList.get(i).getCourseName());
						 days.setText(CommonClass.courseList.get(i).getCourseDays());
						 location.setText(CommonClass.courseList.get(i).getCourseLocation());
						 time.setText(CommonClass.courseList.get(i).getCourseTime());
						 
						 for(int j=0;j<CommonClass.studentList.size();j++) {
							 if (CommonClass.studentList.get(j).getCourses().contains(CommonClass.courseList.get(i))) {
								 Students.getItems().add(CommonClass.studentList.get(j).getStudID());
							 }
						 }
						 Label numberRegistered = new Label("There are " + Students.getItems().size() + " students registered in " + CommonClass.courseList.get(Index).getCourseID());
						 setTop(numberRegistered);
						 
						 if (CommonClass.courseList.get(Index).getAvailableSeats() == 0) 
								cbo.getSelectionModel().select(0);
							else
								cbo.getSelectionModel().select(1);
						 
						 
						 break;
					 }
					 else {
						 continue;
					 }
				 }
			 }
			 else {
				 Label notFound = new Label("Could not find "+id.getText());
				 setTop(notFound);
			 }
				 
			   
		});
		
		
		
		
	   vboxL.setAlignment(Pos.CENTER);
	   vboxR.setAlignment(Pos.CENTER);
	   vboxC.setAlignment(Pos.CENTER);
	   
	   setLeft(vboxL);
	   setRight(vboxR);
	   setCenter(vboxC);
	   setBottom(hbox7);
	   setPadding(new Insets(20,20,20,20));
	   
	   
   }
	 
	 
  
 }