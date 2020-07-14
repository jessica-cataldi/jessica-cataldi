package model;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class FacultyPane
{
    private College college;
    
    private TextField firstNameField, lastNameField, idField, titleField, phoneNumberField;
    
    private Button insertButton, searchButton, updateButton, removeButton, clearButton;
    
    private VBox root;
    
    private HBox textFieldBox, buttonBox;
    
    private ComboBox<String> comboBox;
    
    
    public FacultyPane(College college)
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
        comboBox.setPromptText("-TITLE-");
        comboBox.setTranslateX(160);
        textFieldBox = new HBox(10);
        buttonBox = new HBox(10);
        
        textFieldBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        
        comboBox.setItems(FXCollections.observableArrayList("Professor", "Associate Professor", 
                                                            "Assistant Professor", "Instructor"));
        textFieldBox.getChildren().addAll(firstNameField, lastNameField, idField, titleField, phoneNumberField);
        buttonBox.getChildren().addAll(insertButton, searchButton, updateButton, removeButton, clearButton);
    }
    private void buildTextFields()
    {
        firstNameField = new TextField();
        lastNameField = new TextField();
        idField = new TextField();
        titleField = new TextField();
        phoneNumberField = new TextField();
        firstNameField.setPromptText("FIRST NAME");
        lastNameField.setPromptText("LAST NAME");
        idField.setPromptText("ID");
        titleField.setPromptText("TITLE");
        phoneNumberField.setPromptText("OFFICE PHONE");
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
      titleField.setDisable(true);
      insertButton.setOnAction(e ->
      {
          String firstName = firstNameField.getText();
          String lastName = lastNameField.getText();
          String title = comboBox.getValue();
          String officePhone = phoneNumberField.getText();
          if(officePhone.length() == 10 && officePhone.matches("[0-9]*") && 
             firstName.length() != 0 && lastName.length() != 0 && comboBox.getValue() != null) 
          {                           
              Faculty faculty = new Faculty(firstName, lastName, title, officePhone);
              college.getFacultyBag().insert(faculty);
              comboBox.setValue(null);
              firstNameField.clear();
              lastNameField.clear();         
              phoneNumberField.clear();
          }
          else
          {
              Alerts.wrongFacultyAlert();;           
          }                           
      });  
      searchButton.setOnAction(e ->
      {
          String id = idField.getText();
          idField.setDisable(true);
          Faculty faculty = college.getFacultyBag().searchById(id);
          if(faculty != null)
          {
              firstNameField.setText(faculty.getFirstName());
              lastNameField.setText(faculty.getLastName());
              titleField.setText(faculty.getTitle());
              phoneNumberField.setText(faculty.getPhoneNumber());
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
          Faculty faculty = college.getFacultyBag().searchById(id);
          String firstName = firstNameField.getText();
          String lastName = lastNameField.getText();
          String title = comboBox.getValue();
          String officePhone = phoneNumberField.getText();
          if(officePhone.length() == 10 && officePhone.matches("[0-9]*") && 
             firstName.length() != 0 && lastName.length() != 0 && comboBox.getValue() != null) 
          {                           
              faculty.setFirstName(firstName);
              faculty.setLastName(lastName);
              faculty.setTitle(title);
              faculty.setPhoneNumber(officePhone);
              comboBox.setValue(null);
              firstNameField.clear();
              lastNameField.clear();
              idField.clear();
              phoneNumberField.clear();
              titleField.clear();
              
              idField.setDisable(false);
          }
          else
          {
              Alerts.wrongFacultyAlert();;           
          }                                    
      });  
      removeButton.setOnAction(e ->
      {
          String id = idField.getText();
          @SuppressWarnings("unused")
          Faculty faculty = college.getFacultyBag().removeById(id);
          comboBox.setValue(null);
          firstNameField.clear();
          lastNameField.clear();
          idField.clear();
          phoneNumberField.clear();
          titleField.clear();
          
          idField.setDisable(false);
      });  
      clearButton.setOnAction(e -> 
      {        
          comboBox.setValue(null);
          firstNameField.clear();
          lastNameField.clear();
          idField.clear();
          phoneNumberField.clear();
          titleField.clear();
          
          idField.setDisable(false);
      });
    }
    
    
    public Pane getPane()
    {
        return root;
    }
}