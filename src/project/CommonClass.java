package project;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CommonClass {
	public static ArrayList<Course> courseList = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();
      
    private static final  File FILE = new File("res\\Registration.dat"); 
    
   
    
	public static final void loadBinaryData() {
        System.out.println("start loading");
  try (
      FileInputStream fos = new FileInputStream(FILE);
      ObjectInputStream oos = new ObjectInputStream(fos);
      ){
	  CommonClass.courseList = (ArrayList<Course> ) oos.readObject();
	  CommonClass.studentList = (ArrayList<Student> ) oos.readObject();
	  for ( int i = 0 ; i<  CommonClass.courseList.size(); i++)
		  System.out.println(CommonClass.courseList.get(i));
	  
	  System.out.print(CommonClass.studentList.size());
	  for ( int i = 0 ; i<  CommonClass.studentList.size(); i++)
		  System.out.println(CommonClass.studentList.get(i));
      
  }   
  
  
  catch (FileNotFoundException  ex) {
      System.out.println(ex.getMessage());
  }

  catch (IOException |  ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
      }
  
  
}
    
    
}
