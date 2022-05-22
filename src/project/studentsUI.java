package project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class studentsUI extends BorderPane{
	private int index = -1;
	
	studentsUI(){
		
		Button back = new Button("Back");
		Button previous = new Button("<Previous");
		Button next = new Button("Next>");
		Button register = new Button("Register");
		Button drop = new Button("Drop");
		Button search = new Button("Search");

		
		Label lb1 = new Label("students ID");
		Label lb2 = new Label("Registered Courses");
		Label lb3 = new Label("Not Registered Courses");

		TextField tf = new TextField();
		ListView registered = new ListView();
		ComboBox cbo = new ComboBox();
		
		
		HBox hbox1 = new HBox();
		hbox1.setPadding(new Insets(50,50,50,50));
		hbox1.setSpacing(90);
		hbox1.getChildren().addAll(lb1,tf);
		
		HBox hbox2 = new HBox();
		hbox2.setPadding(new Insets(50,50,50,50));
		hbox2.setSpacing(50);
		hbox2.getChildren().addAll(lb2,registered);
		
		HBox hbox3 = new HBox();
		hbox3.setPadding(new Insets(50,50,50,50));
		hbox3.setSpacing(26);
		hbox3.getChildren().addAll(lb3,cbo);
		
		HBox hbox4 = new HBox();
		hbox4.setSpacing(10);
		hbox4.setAlignment(Pos.CENTER);
		hbox4.getChildren().addAll(back,previous,next,register,drop,search);
		
		VBox vbox = new VBox();
		vbox.setSpacing(-90);
		vbox.getChildren().addAll(hbox1,hbox2,hbox3);
		
		setCenter(vbox);
		setBottom(hbox4);
		
		back.setOnAction(e->{
			TestClass.scene.setRoot(new MainUI());
		});
		previous.setOnAction(e->{
			registered.getItems().clear();
			cbo.getItems().clear();
			
			if (index > 0) {
				index--;
			}
			else {
				index = CommonClass.studentList.size() - 1;
			}
			tf.setText(CommonClass.studentList.get(index).getStudID());
			for(int i=0;i<CommonClass.courseList.size();i++) {
				if (CommonClass.studentList.get(index).getCourses().contains(CommonClass.courseList.get(i))) {
					registered.getItems().add(CommonClass.courseList.get(i).getCourseID());
				}
			}
			
			for(int i=0;i<CommonClass.courseList.size();i++) {
				if (!registered.getItems().contains(CommonClass.courseList.get(i)) && CommonClass.courseList.get(i).getAvailableSeats() > 0) {
					cbo.getItems().add(CommonClass.courseList.get(i).getCourseID());
				}
			}
			
			
		});
		next.setOnAction(e->{
			registered.getItems().clear();
			cbo.getItems().clear();
			
			if(index < CommonClass.studentList.size()-1) {
				index++;
			}
			else {
				index = 0;
			}
			tf.setText(CommonClass.studentList.get(index).getStudID());
			for(int i=0;i<CommonClass.courseList.size();i++) {
				if (CommonClass.studentList.get(index).getCourses().contains(CommonClass.courseList.get(i))) {
					registered.getItems().add(CommonClass.courseList.get(i).getCourseID());
				}
			}
			
			for(int i=0;i<CommonClass.courseList.size();i++) {
				if (!registered.getItems().contains(CommonClass.courseList.get(i)) && CommonClass.courseList.get(i).getAvailableSeats() > 0) {
					cbo.getItems().add(CommonClass.courseList.get(i).getCourseID());
				}
			}
			
		});
		register.setOnAction(e->{
			for (int i=0;i<CommonClass.studentList.size();i++) {
				if (CommonClass.studentList.get(i).getStudID().equals(tf.getText())) {
					
					for(int j=0;j<CommonClass.courseList.size();j++) {
						if (CommonClass.courseList.get(j).getCourseID().equals(cbo.getValue())) {
							
							CommonClass.studentList.get(i).getCourses().add(CommonClass.courseList.get(j));
							registered.getItems().add(CommonClass.courseList.get(j).getCourseID());
							CommonClass.courseList.get(j).register();
							
							break;
						}
					}
					
					
				}
			}
			cbo.getItems().clear(); // to clear all items before adding new ones
			for (Course course: CommonClass.courseList)  // to add courses that are not registered and have available seats to combo box
				if (!registered.getItems().contains(course.getCourseID()) && course.getAvailableSeats() > 0)
					cbo.getItems().add(course.getCourseID());
		});
		drop.setOnAction(e->{
			for (int i=0;i<CommonClass.studentList.size();i++) {
				if (CommonClass.studentList.get(i).getStudID().equals(tf.getText())) {
					
					for(int j=0;j<CommonClass.courseList.size();j++) {
						if (CommonClass.courseList.get(i).getCourseID().equals(registered.getSelectionModel().getSelectedItem())) {
							
							CommonClass.courseList.get(j).drop();
						}
					}
					CommonClass.studentList.get(i).getCourses().remove(registered.getSelectionModel().getSelectedIndex());
					registered.getItems().remove(registered.getSelectionModel().getSelectedIndex());
					break;
				}
			}
			cbo.getItems().clear(); // to clear all items before adding new ones
			for (Course course: CommonClass.courseList)  // to add courses that are not registered and have available seats to combo box
				if (!registered.getItems().contains(course.getCourseID()) && course.getAvailableSeats() > 0)
					cbo.getItems().add(course.getCourseID());
		});
		
		
		
		
	}
}
