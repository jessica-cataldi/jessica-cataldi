package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts
{
    public static void errorSearchAlert()
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("NO RESULTS: Invalid Search Criteria");
        alert.setContentText("You are receiving this alert because the item "
                              + "you searched for is either invalid or no longer exits.");
        alert.showAndWait();
    }    
    public static void wrongClassroomAlert()
    {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("INPUT ERROR: Invalid Input");
        alert.setContentText("Room Number field cannot be empty.");
        alert.showAndWait();
    }
    public static void wrongCourseAlert()
    {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("INPUT ERROR: Invalid Input");
        alert.setContentText("Please make sure you fill out all required information including: Course Number"
                                + ", Course Title, Course Description, and Number of Credits.");
        alert.showAndWait();
    }   
    public static void wrongTextbookAlert()
    {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("INPUT ERROR: Invalid Input");
        alert.setContentText("Please make sure you enter a valid book title along with"
                              + " the authors name and the ISBN");
        alert.showAndWait();
    }      
    public static void wrongStudentAlert()
    {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("INPUT ERROR: Invalid Input" );
        alert.setContentText("Please make sure you enter a first and last name "
                              + "along with a major and a valid 10 digit phonenumber.");
        alert.showAndWait();
    }
    public static void wrongFacultyAlert()
    {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("INPUT ERROR: Invalid Input" );
        alert.setContentText("Please make sure you enter a first and last name "
                              + "along with a title and a valid 10 digit phonenumber.");
        alert.showAndWait();
    }
}
