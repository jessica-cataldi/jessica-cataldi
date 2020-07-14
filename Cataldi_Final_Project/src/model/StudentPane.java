package model;

import helper.CourseRequirementsHelper;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class StudentPane
{
    private College college;
    
    private TextField firstNameField, lastNameField, idField, majorField, phoneNumberField;
    
    private Button insertButton, searchButton, updateButton, removeButton, clearButton;
    
    private VBox root;
    
    private HBox textFieldBox, buttonBox;
    
    private ComboBox<String> comboBox;
    
    
    public StudentPane(College college)
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
        root.getChildren().addAll(comboBox, textFieldBox, buttonBox);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void buildHBoxes()
    {
        comboBox = new ComboBox();
        comboBox.setPromptText("-MAJOR-");
        comboBox.setTranslateX(158);
        textFieldBox = new HBox(10);
        buttonBox = new HBox(10);
        
        textFieldBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);        
        
        comboBox.setItems(FXCollections.observableArrayList("CSE", "MAT", "ENG"));
        textFieldBox.getChildren().addAll(firstNameField, lastNameField, idField, majorField, phoneNumberField);
        buttonBox.getChildren().addAll(insertButton, searchButton, updateButton, removeButton, clearButton);  
    }
    private void buildTextFields()
    {
        firstNameField = new TextField();
        lastNameField = new TextField();
        idField = new TextField();
        majorField = new TextField();
        phoneNumberField = new TextField();
        firstNameField.setPromptText("FIRST NAME");
        lastNameField.setPromptText("LAST NAME");
        idField.setPromptText("ID");
        majorField.setPromptText("MAJOR");
        phoneNumberField.setPromptText("PHONE NUMBER");
        idField.setDisable(false);
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
      majorField.setDisable(true);
      
      insertButton.setOnAction(e ->
      {         
          String firstName = firstNameField.getText();
          String lastName = lastNameField.getText();
          String major = comboBox.getValue();
          String phoneNumber = phoneNumberField.getText();
          if(phoneNumber.length() == 10 && phoneNumber.matches("[0-9]*") && 
             firstName.length() != 0 && lastName.length() != 0 && comboBox.getValue() != null) 
          {                           
              Student student = new Student(firstName, lastName, major, phoneNumber);
              college.getStudentBag().insert(student);
              comboBox.setValue(null);
              firstNameField.clear();
              lastNameField.clear();
              majorField.clear();
              phoneNumberField.clear();
          }
          else
          {
              Alerts.wrongStudentAlert();;           
          }          
      });       
      searchButton.setOnAction(e ->
      {
          String id = idField.getText();
          idField.setDisable(true);
          Student student = college.getStudentBag().searchById(id);
          if(student != null)
          {
              firstNameField.setText(student.getFirstName());
              lastNameField.setText(student.getLastName());
              majorField.setText(student.getMajor());
              if(student.getMajor().equals("CSE"))
              {
                  CourseRequirementsHelper.cseCourseRequirements();
              }
              else if(student.getMajor().equals("MAT"))
              {
                  CourseRequirementsHelper.matCourseRequirements();
              }
              else if(student.getMajor().equals("ENG"))
              {
                  CourseRequirementsHelper.engCourseRequirements();
              } 

              phoneNumberField.setText(student.getPhoneNumber());
              comboBox.setValue(null);             
          }
          else
          {
              Alerts.errorSearchAlert();
          }         
      });  
      updateButton.setOnAction(e ->
      {
          String id = idField.getText();         
          Student student = college.getStudentBag().searchById(id);
          String firstName = firstNameField.getText();
          String lastName = lastNameField.getText();
          String major = comboBox.getValue();
          String phoneNumber = phoneNumberField.getText();
          if(phoneNumber.length() == 10 && phoneNumber.matches("[0-9]*") && 
             firstName.length() != 0 && lastName.length() != 0 && comboBox.getValue() != null) 
          {                           
              student.setFirstName(firstName);
              student.setLastName(lastName);
              student.setMajor(major);
              student.setPhoneNumber(phoneNumber);
              comboBox.setValue(null);
              firstNameField.clear();
              lastNameField.clear();
              idField.clear();
              majorField.clear();
              phoneNumberField.clear();
              
              idField.setDisable(false);
          }
          else
          {
              Alerts.wrongStudentAlert();;           
          }                   
      });  
      removeButton.setOnAction(e ->
      {
          String id = idField.getText();
          @SuppressWarnings("unused")
          Student student = college.getStudentBag().removeById(id);
          comboBox.setValue(null);
          firstNameField.clear();
          lastNameField.clear();
          idField.clear();
          majorField.clear();
          phoneNumberField.clear();
          
          idField.setDisable(false);
      }); 
      clearButton.setOnAction(e -> 
      {        
          comboBox.setValue(null);
          firstNameField.clear();
          lastNameField.clear();
          idField.clear();
          majorField.clear();
          phoneNumberField.clear();
          
          idField.setDisable(false);
      });
    }
    
    
    public Pane getPane()
    {
        return root;
    }
}