package model;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CoursePane
{
    private College college;
    
    private TextField courseNumberField, numberOfCreditsField;
    private TextArea courseDescriptionField, courseTitleField;
        
    private Button insertButton, searchButton, updateButton, removeButton, clearButton;
    
    private VBox root;
    
    private HBox textFieldBox, buttonBox;
    
    
    public CoursePane(College college)
    {
        buildTextFields();
        buildButtons();      
        buildHBoxes();
        buildVBox();
        handleEvent();
       
       this.college = college;
    }
    
    
    private void buildVBox()
    {
        root = new VBox(20);
        
        root.setAlignment(Pos.CENTER);
        
        root.getChildren().addAll(textFieldBox, buttonBox);
    }
    private void buildHBoxes()
    {
        textFieldBox = new HBox(10);
        buttonBox = new HBox(10);
        
        courseDescriptionField.setMaxSize(300, 100);
        courseDescriptionField.setWrapText(true);
        courseTitleField.setMaxSize(150, 50);
        courseTitleField.setWrapText(true);
        
        textFieldBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
               
        textFieldBox.getChildren().addAll(courseNumberField, courseTitleField, 
                                          courseDescriptionField, numberOfCreditsField);
        buttonBox.getChildren().addAll(insertButton, searchButton, updateButton, removeButton, clearButton);
    }
    private void buildTextFields()
    {
        courseNumberField = new TextField();
        courseTitleField = new TextArea();
        courseDescriptionField = new TextArea();
        numberOfCreditsField = new TextField();
        courseNumberField.setPromptText("COURSE NUMBER");
        courseTitleField.setPromptText("COURSE TITLE");
        courseDescriptionField.setPromptText("COURSE DESCRIPTION");
        numberOfCreditsField.setPromptText("NUMBER OF CREDITS");
    }    
    private void buildButtons()
    {
        insertButton = new Button("INSERT");
        searchButton = new Button("SEARCH");
        updateButton = new Button("UPDATE");
        removeButton = new Button("REMOVE");
        clearButton = new Button("CLEAR");
    }
    
    
    public void handleEvent()
    {
      insertButton.setOnAction(e ->
      {
          String courseNumber = courseNumberField.getText();
          String courseTitle = courseTitleField.getText();
          String courseDescription = courseDescriptionField.getText();
          String numberOfCredits = numberOfCreditsField.getText();
          if(courseNumber.length() != 0 && courseTitle.length() != 0 && 
             courseDescription.length() != 0 && numberOfCredits.length() != 0)
          {
          Course course = new Course(courseNumber, courseTitle, courseDescription, numberOfCredits);
          college.getCourseBag().insertCourse(course);
          courseNumberField.clear();
          courseTitleField.clear();
          courseDescriptionField.clear();
          numberOfCreditsField.clear();
          }
          else
          {
              Alerts.wrongCourseAlert();
          }
      });  
      searchButton.setOnAction(e ->
      {
          String courseNumber = courseNumberField.getText();
          courseNumberField.setDisable(true);
          Course course = college.getCourseBag().findByCourseNumber(courseNumber);
          if(course != null)
          {
              courseNumberField.setText(course.getCourseNumber());
              courseTitleField.setText(course.getCourseTitle());
              courseDescriptionField.setText(course.getCourseDescription());
              numberOfCreditsField.setText(course.getNumberOfCredits());
          }
          else
          {
              Alerts.errorSearchAlert();
          }                  
      });  
      updateButton.setOnAction(e ->
      {
          String courseNumber = courseNumberField.getText();
          Course course = college.getCourseBag().findByCourseNumber(courseNumber);
          String courseTitle = courseTitleField.getText();
          String courseDescription = courseDescriptionField.getText();
          String numberOfCredits = numberOfCreditsField.getText();
          if(courseNumber.length() != 0 && courseTitle.length() != 0 && 
             courseDescription.length() != 0 && numberOfCredits.length() != 0)
          {
          course.setCourseNumber(courseNumber);
          course.setCourseTitle(courseTitle);
          course.setCourseDescription(courseDescription);
          course.setNumberOfCredits(numberOfCredits);
          courseNumberField.clear();
          courseTitleField.clear();
          courseDescriptionField.clear();
          numberOfCreditsField.clear();
          
          courseNumberField.setDisable(false);
          }
          else
          {
              Alerts.wrongCourseAlert();
          }
      });  
      removeButton.setOnAction(e ->
      {
          String courseNumber = courseNumberField.getText();
          @SuppressWarnings("unused")
          Course course = college.getCourseBag().removeByCourseNumber(courseNumber);
          courseNumberField.clear();
          courseTitleField.clear();
          courseDescriptionField.clear();
          numberOfCreditsField.clear();
          
          courseNumberField.setDisable(false);
      }); 
      clearButton.setOnAction(e -> 
      {
          courseNumberField.clear();
          courseTitleField.clear();
          courseDescriptionField.clear();
          numberOfCreditsField.clear();
          
          courseNumberField.setDisable(false);
      });
    }
    
    
    public Pane getPane()
    {
        return root;
    }
}