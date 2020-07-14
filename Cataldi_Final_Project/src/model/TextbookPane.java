package model;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class TextbookPane
{
 private College college;
    
    private TextField isbnField, authorField, priceField;
    private TextArea bookTitleField;
    
    private Button insertButton, searchButton, updateButton, removeButton, clearButton;
    
    private VBox root;
    
    private HBox textFieldBox, buttonBox;
    
    
    public TextbookPane(College college)
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
        
        bookTitleField.setMaxSize(150, 60);
        bookTitleField.setWrapText(true);
        
        textFieldBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        
        textFieldBox.getChildren().addAll(bookTitleField, isbnField, authorField, priceField);
        buttonBox.getChildren().addAll(insertButton, searchButton, updateButton, removeButton, clearButton);
    }
    private void buildTextFields()
    {
        bookTitleField = new TextArea();
        isbnField = new TextField();
        authorField = new TextField();
        priceField = new TextField();
        bookTitleField.setPromptText("BOOK TITLE");
        isbnField.setPromptText("ISBN");
        authorField.setPromptText("AUTHOR");
        priceField.setPromptText("PRICE");
    }        
    private void buildButtons()
    {
        insertButton = new Button("INSERT");
        searchButton = new Button("SEARCH");
        updateButton = new Button("UPDATE");
        removeButton = new Button("REMOVE");
        clearButton = new Button ("CLEAR");
    }
    
    
    public void handleEvent()
    {
      priceField.setDisable(true);
      insertButton.setOnAction(e ->
      {
          String bookTitle = bookTitleField.getText();
          String isbn = isbnField.getText();
          String author = authorField.getText();
          @SuppressWarnings("unused")
          String price = priceField.getText();
          if(bookTitle.length() != 0 && isbn.length() != 0 && author.length() != 0)
          {
          Textbook textbook = new Textbook(bookTitle, isbn, author);
          college.getTextbookBag().insertTextbook(textbook);
          bookTitleField.clear();
          isbnField.clear();
          authorField.clear();
          priceField.clear();    
          }
          else
          {
              Alerts.wrongTextbookAlert();
          }
      });  
      searchButton.setOnAction(e ->
      {
          String isbn = isbnField.getText();
          isbnField.setDisable(true);
          Textbook textbook = college.getTextbookBag().findByIsbn(isbn);
          if(textbook != null)
          {
              bookTitleField.setText(textbook.getBookTitle());
              isbnField.setText(textbook.getIsbn());
              authorField.setText(textbook.getAuthor());
              priceField.setText(textbook.getPrice());
          }
          else
          {
              Alerts.errorSearchAlert();
          }         
      });  
      updateButton.setOnAction(e ->
      {
          String isbn = isbnField.getText();
          Textbook textbook = college.getTextbookBag().findByIsbn(isbn);
          String bookTitle = bookTitleField.getText();
          String author = authorField.getText();
          @SuppressWarnings("unused")
          String price = priceField.getText();
          if(bookTitle.length() != 0 && isbn.length() != 0 && author.length() != 0)
          {
          textbook.setBookTitle(bookTitle);
          textbook.setAuthor(author);
          textbook.setIsbn(isbn);
          bookTitleField.clear();
          isbnField.clear();
          authorField.clear();
          priceField.clear();
          
          isbnField.setDisable(false);
          }
          else
          {
              Alerts.wrongTextbookAlert();
          }
      });  
      removeButton.setOnAction(e ->
      {
          String isbn = isbnField.getText();
          @SuppressWarnings("unused")
          Textbook textbook = college.getTextbookBag().removeByIsbn(isbn);
          bookTitleField.clear();
          isbnField.clear();
          authorField.clear();
          priceField.clear();
          
          isbnField.setDisable(false);
      }); 
      clearButton.setOnAction(e -> 
      {        
          bookTitleField.clear();
          isbnField.clear();
          authorField.clear();
          priceField.clear();
          
          isbnField.setDisable(false);
      });
    }
    
    
    public Pane getPane()
    {
        return root;
    }
}