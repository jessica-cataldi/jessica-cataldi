package model;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ClassroomPane
{
    private College college;
    
    private TextField roomNumberField, buildingNameField;
    
    private Button insertButton, searchButton, updateButton, removeButton, clearButton;
    
    private VBox root;
    
    private HBox textFieldBox, buttonBox;
    
    private ComboBox<String> comboBox;
    
    
    public ClassroomPane(College college)
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
        comboBox.setPromptText("-BUILDING NAME-");
        comboBox.setTranslateX(79);
        textFieldBox = new HBox(10);
        buttonBox = new HBox(10);
        
        textFieldBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        
        comboBox.setItems(FXCollections.observableArrayList("Riverhead", "Islip", "Smithtown", "NFL"));
        textFieldBox.getChildren().addAll(roomNumberField, buildingNameField);
        buttonBox.getChildren().addAll(insertButton, searchButton, updateButton, removeButton, clearButton);
    }
    private void buildTextFields()
    {
        roomNumberField = new TextField();
        buildingNameField = new TextField();
        roomNumberField.setPromptText("ROOM NUMBER");
        buildingNameField.setPromptText("BUILDING NAME");        
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
      buildingNameField.setDisable(true);
      
      insertButton.setOnAction(e ->
      {
          String roomNumber = roomNumberField.getText();
          String buildingName = comboBox.getValue();               
          if(roomNumber.length() != 0 && comboBox.getValue() != null)
          {
          Classroom classroom = new Classroom(roomNumber, buildingName);
          college.getClassroomBag().insertClassroom(classroom);
          comboBox.setValue(null);
          roomNumberField.clear(); 
          }
          else
          {
              Alerts.wrongClassroomAlert();;
          }
      });  
      searchButton.setOnAction(e ->
      {
          String roomNumber = roomNumberField.getText();
          roomNumberField.setDisable(true);
          Classroom classroom = college.getClassroomBag().findByRoomNumber(roomNumber);
          if(classroom != null)
          {
              roomNumberField.setText(classroom.getRoomNumber());
              buildingNameField.setText(classroom.getBuildingName());
              comboBox.setValue(null);
          }
          else
          {
              Alerts.errorSearchAlert();
          }                  
      });  
      updateButton.setOnAction(e ->
      {
          String roomNumber = roomNumberField.getText();
          Classroom classroom = college.getClassroomBag().findByRoomNumber(roomNumber);
          String buildingName = comboBox.getValue();
          if(roomNumber.length() != 0 && comboBox.getValue() != null) 
          {                           
              classroom.setRoomNumber(roomNumber);
              classroom.setBuildingName(buildingName);
              comboBox.setValue(null);
              roomNumberField.clear();
              buildingNameField.clear();
              
              roomNumberField.setDisable(false);
          }
          else
          {
              Alerts.wrongClassroomAlert();;           
          }                   
          classroom.setRoomNumber(roomNumber);
      });  
      removeButton.setOnAction(e ->
      {
          String roomNumber = roomNumberField.getText();
          @SuppressWarnings("unused")
          Classroom classroom = college.getClassroomBag().removeByRoomNumber(roomNumber);
          comboBox.setValue(null);
          roomNumberField.clear();
          buildingNameField.clear();
          
          roomNumberField.setDisable(false);
      });
      clearButton.setOnAction(e ->
      {
          comboBox.setValue(null);
          roomNumberField.clear();
          buildingNameField.clear();
          
          roomNumberField.setDisable(false);
      });
    }

    
    public Pane getPane()
    {
        return root;
    }
}
