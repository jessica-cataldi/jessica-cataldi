package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.College;
import model.MiniStudentInfo;

public class CourseRequirementsHelper
{
    private static College college = new College();
    private static TextArea t = new TextArea();
    
    public static void cseCourseRequirements()
    {       
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp, 450, 300);
        Stage stage = new Stage();
        HBox continueBox = new HBox();
        HBox textBox = new HBox();
        Button continueButton = new Button("CONTINUE");
        continueBox.getChildren().addAll(continueButton);
        continueBox.setAlignment(Pos.CENTER);
               
        Text text = new Text();
        Font font = Font.font(15);
        text.setText("   To view course requirements for the CSE major press continue. \n   Otherwise"
                      + " press the red X in the top right corner to exit.");
        text.setFont(font);
        textBox.getChildren().add(text);

        bp.setTop(textBox);
        bp.setCenter(continueBox);
        
        continueButton.setOnAction(y -> 
        {
            File cseFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\cseRequirements");                    
            Scanner cseScanner;
            try
            {
                cseScanner = new Scanner(cseFile);                        
                while(cseScanner.hasNextLine()) 
                {   
                    String courseNumber = cseScanner.nextLine();
                    String courseTitle = cseScanner.nextLine();
                    String courseDescription = cseScanner.nextLine();
                    String courseCredits = cseScanner.nextLine();
                    MiniStudentInfo msi = new MiniStudentInfo(courseNumber, courseTitle, 
                                                              courseDescription, courseCredits);
                    college.getMiniStudentCourseBag().insert(msi);
                    
                    t.appendText(msi.toString());                     
                    t.setEditable(false);
                    t.setWrapText(true);
                    bp.setCenter(t);                    
                }
                cseScanner.close();                                       
            } 
            catch (FileNotFoundException e1)
            {
                e1.printStackTrace();
            }                 
        });
        stage.setOnCloseRequest(e -> 
        {
            t.clear();
        });
        stage.setTitle("Computer Science Major Requirements");
        stage.setScene(scene);
        stage.show();                  
    }
    
    
    public static void matCourseRequirements()
    {       
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp, 450, 300);
        Stage stage = new Stage();
        HBox continueBox = new HBox();
        HBox textBox = new HBox();
        Button continueButton = new Button("CONTINUE");
        continueBox.getChildren().addAll(continueButton);
        continueBox.setAlignment(Pos.CENTER);
               
        Text text = new Text();
        Font font = Font.font(15);
        text.setText("   To view course requirements for the MAT major press continue. \n   Otherwise"
                      + " press the red X in the top right corner to exit.");
        text.setFont(font);
        textBox.getChildren().add(text);

        bp.setTop(textBox);
        bp.setCenter(continueBox);
        
        continueButton.setOnAction(y -> 
        {           
            File matFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\matRequirements");                    
            Scanner matScanner;
            try
            {
                matScanner = new Scanner(matFile);                        
                while(matScanner.hasNextLine()) 
                {   
                    String courseNumber = matScanner.nextLine();
                    String courseTitle = matScanner.nextLine();
                    String courseDescription = matScanner.nextLine();
                    String courseCredits = matScanner.nextLine();
                    MiniStudentInfo msi = new MiniStudentInfo(courseNumber, courseTitle, 
                                                              courseDescription, courseCredits);                    
                    college.getMiniStudentCourseBag().insert(msi);     
                    
                    t.appendText(msi.toString());  
                    t.setEditable(false);
                    t.setWrapText(true);
                    bp.setCenter(t);                    
                }
                matScanner.close();                                       
            } 
            catch (FileNotFoundException e1)
            {
                e1.printStackTrace();
            }                 
        });
        stage.setOnCloseRequest(e -> 
        {
            t.clear();
        });
        stage.setTitle("Mathematics Major Requirements");
        stage.setScene(scene);
        stage.show();                  
    }
    
    
    public static void engCourseRequirements()
    {       
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp, 450, 300);
        Stage stage = new Stage();
        HBox continueBox = new HBox();
        HBox textBox = new HBox();
        Button continueButton = new Button("CONTINUE");
        continueBox.getChildren().addAll(continueButton);
        continueBox.setAlignment(Pos.CENTER);
               
        Text text = new Text();
        Font font = Font.font(15);
        text.setText("   To view course requirements for the ENG major press continue. \n   Otherwise"
                      + " press the red X in the top right corner to exit.");
        text.setFont(font);
        textBox.getChildren().add(text);

        bp.setTop(textBox);
        bp.setCenter(continueBox);
        
        continueButton.setOnAction(y -> 
        {
            File engFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\engRequirements");                    
            Scanner engScanner;
            try
            {
                engScanner = new Scanner(engFile);                        
                while(engScanner.hasNextLine()) 
                {   
                    String courseNumber = engScanner.nextLine();
                    String courseTitle = engScanner.nextLine();
                    String courseDescription = engScanner.nextLine();
                    String courseCredits = engScanner.nextLine();
                    MiniStudentInfo msi = new MiniStudentInfo(courseNumber, courseTitle, 
                                                              courseDescription, courseCredits);
                    college.getMiniStudentCourseBag().insert(msi);     
                    
                    t.appendText(msi.toString());  
                    t.setEditable(false);
                    t.setWrapText(true);
                    bp.setCenter(t);                    
                }
                engScanner.close();                                       
            } 
            catch (FileNotFoundException e1)
            {
                e1.printStackTrace();
            }                 
        });
        stage.setOnCloseRequest(e -> 
        {
            t.clear();
        });
        stage.setTitle("English Major Requirements");
        stage.setScene(scene);
        stage.show();                  
    }
}
