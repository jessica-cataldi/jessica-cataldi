package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FinalProjectPane
{
    public static void startFinalProject(Stage primaryStage) throws Exception
    {
        College college = new College();        
        BorderPane root = new BorderPane();         
        MenuBar menuBar = new MenuBar();
                     
        Menu fileMenu = new Menu("File");       
        MenuItem exitItem = new MenuItem("EXIT");
        exitItem.setOnAction(e ->
        {
            System.exit(0);
        });
        
        Menu importMenu = new Menu("Import");
        MenuItem studentImportItem = new MenuItem("Student");
        MenuItem facultyImportItem = new MenuItem("Faculty");
        MenuItem courseImportItem = new MenuItem("Course");
        MenuItem textbookImportItem = new MenuItem("Textbook");
        MenuItem classroomImportItem = new MenuItem("Classroom");
        importMenu.getItems().addAll(studentImportItem, facultyImportItem, courseImportItem, 
                                     textbookImportItem, classroomImportItem);
        
        Menu exportMenu = new Menu("Export");
        MenuItem studentExportItem = new MenuItem("Student");
        MenuItem facultyExportItem = new MenuItem("Faculty");
        MenuItem courseExportItem = new MenuItem("Course");
        MenuItem textbookExportItem = new MenuItem("Textbook");
        MenuItem classroomExportItem = new MenuItem("Classroom");
        exportMenu.getItems().addAll(studentExportItem, facultyExportItem, courseExportItem, 
                                     textbookExportItem, classroomExportItem);
        MenuItem backupItem = new MenuItem("Backup");
        MenuItem restoreItem = new MenuItem("Restore");
        
        
        fileMenu.getItems().addAll(importMenu, exportMenu, new SeparatorMenuItem(), backupItem, 
                                   restoreItem, new SeparatorMenuItem(), exitItem);
        
        Menu editMenu = new Menu("Edit");
        MenuItem studentItem = new MenuItem("Student");
        MenuItem facultyItem = new MenuItem("Faculty");
        MenuItem courseItem = new MenuItem("Course");
        MenuItem textbookItem = new MenuItem("Textbook");
        MenuItem classroomItem = new MenuItem("Classroom");  
        
        editMenu.getItems().addAll(studentItem, facultyItem, courseItem, textbookItem, classroomItem);
        menuBar.getMenus().addAll(fileMenu, editMenu);
        
        root.setTop(menuBar);  
        
        
        //Set Center Image
//        {    
//            try
//            {
//                Image image = new Image(new FileInputStream("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\Photo.gif"));
//                ImageView imageView = new ImageView(image);
//                imageView.setFitHeight(455); 
//                imageView.setFitWidth(500); 
//                root.setCenter(imageView);
//            } catch (FileNotFoundException e1)
//            {
//                e1.printStackTrace();
//            }
//            
//        }
        
        
        //Import Items
        {
            studentImportItem.setOnAction(e -> 
            {
                
                File firstNamesFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\firstnames");
                File lastNamesFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\lastnames");
                File majorsFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\majors");
                File phoneNumbersFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\phonenumbers");
                    
                Scanner firstNameScanner, lastNameScanner, majorScanner, phoneNumberScanner;
                try
                {
                    firstNameScanner = new Scanner(firstNamesFile);
                    lastNameScanner = new Scanner(lastNamesFile);
                    majorScanner = new Scanner(majorsFile);
                    phoneNumberScanner = new Scanner(phoneNumbersFile);
                    
                    while (firstNameScanner.hasNextLine() && lastNameScanner.hasNextLine() &&
                            majorScanner.hasNextLine() && phoneNumberScanner.hasNextLine()) 
                    {   
                        String firstName = firstNameScanner.nextLine();
                        String lastName = lastNameScanner.nextLine();
                        String major = majorScanner.nextLine();
                        String phoneNumber = phoneNumberScanner.nextLine();
                        Student student = new Student(firstName, lastName, major, phoneNumber);
                        college.getStudentBag().insert(student);
                    }
                    firstNameScanner.close();
                    lastNameScanner.close();
                    majorScanner.close();
                    phoneNumberScanner.close(); 
                  } 
                  catch (FileNotFoundException e1)
                  {
                      e1.printStackTrace();
                  } 
                System.out.println("Student Import Complete.");
            });
            facultyImportItem.setOnAction(e -> 
            {
                
                File firstNamesFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\firstnames");
                File lastNamesFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\lastnames");
                File titleFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\title(faculty)");
                File phoneNumbersFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\phonenumbers");
                    
                Scanner firstNameScanner, lastNameScanner, titleScanner, phoneNumberScanner;
                try
                {
                    firstNameScanner = new Scanner(firstNamesFile);
                    lastNameScanner = new Scanner(lastNamesFile);
                    titleScanner = new Scanner(titleFile);
                    phoneNumberScanner = new Scanner(phoneNumbersFile);
                    
                    while (firstNameScanner.hasNextLine() && lastNameScanner.hasNextLine() &&
                            titleScanner.hasNextLine() && phoneNumberScanner.hasNextLine()) 
                    {   
                        String firstName = firstNameScanner.nextLine();
                        String lastName = lastNameScanner.nextLine();
                        String title = titleScanner.nextLine();
                        String phoneNumber = phoneNumberScanner.nextLine();
                        Faculty faculty = new Faculty(firstName, lastName, title, phoneNumber);
                        college.getFacultyBag().insert(faculty);
                    }
                    firstNameScanner.close();
                    lastNameScanner.close();
                    titleScanner.close();
                    phoneNumberScanner.close(); 
                  } 
                  catch (FileNotFoundException e1)
                  {
                      e1.printStackTrace();
                  } 
                System.out.println("Faculty Import Complete.");
            });
            courseImportItem.setOnAction(e -> 
            {
                
                File coursesFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\courses");
                
                Scanner coursesScanner;
                try
                {
                    coursesScanner = new Scanner(coursesFile);
                    
                    while(coursesScanner.hasNextLine()) 
                    {   
                        String courseNumber = coursesScanner.nextLine();
                        String courseTitle = coursesScanner.nextLine();
                        String courseDescription = coursesScanner.nextLine();
                        String courseCredits = coursesScanner.nextLine();
                        Course course = new Course(courseNumber, courseTitle, courseDescription, courseCredits);
                        college.getCourseBag().insertCourse(course);                      
                    }
                    coursesScanner.close();                                       
                  } 
                  catch (FileNotFoundException e1)
                  {
                      e1.printStackTrace();
                  } 
                System.out.println("Course Import Complete.");
            });
            textbookImportItem.setOnAction(e -> 
            {
                
                File titleFile = new File("C:\\Users\\jessica\\Desktop\\Cataldi_Final_Project\\src\\textFiles\\title(textbook)");
                File isbnFile = new File("C:\\Users\\jessica\\Desktop\\Cataldi_Final_Project\\src\\textFiles\\isbn");
                File authorsFile = new File("C:\\Users\\jessica\\Desktop\\Cataldi_Final_Project\\src\\textFiles\\authors");
                    
                Scanner titleScanner, isbnScanner, authorsScanner;
                try
                {
                    titleScanner = new Scanner(titleFile);
                    isbnScanner = new Scanner(isbnFile); 
                    authorsScanner = new Scanner(authorsFile);
                    
                    while (titleScanner.hasNextLine() && isbnScanner.hasNextLine() &&
                            authorsScanner.hasNextLine()) 
                    {   
                    	
                        String title = titleScanner.nextLine();
                        String isbn = isbnScanner.nextLine(); 
                        String authors = authorsScanner.nextLine();
                        Textbook textbook = new Textbook(title, isbn, authors);
                        college.getTextbookBag().insertTextbook(textbook);
                        /*
                        if (isbn != null)
                        {
                        	System.out.println(isbn);
                        }
                        */
                        System.out.println(textbook.getIsbn());
                        /*
                        if (college.getTextbookBag().getIsbn() != null)
                        {
                        	System.out.println(college.getTextbookBag().getIsbn());
                        }
                        */
                    }
                    titleScanner.close();
                    isbnScanner.close();
                    authorsScanner.close();
                  } 
                  catch (FileNotFoundException e1)
                  {
                      e1.printStackTrace();
                  }
                System.out.println("Textbook Import Complete.");
            });
            classroomImportItem.setOnAction(e -> 
            {                
                File buildingsFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\buildings");
                File roomNumbersFile = new File("C:\\Users\\jessica\\CSE148\\Cataldi_Final_Project\\src\\textFiles\\roomnumbers");
                    
                Scanner buildingsScanner, roomNumbersScanner;
                try
                {
                    buildingsScanner = new Scanner(buildingsFile);
                    roomNumbersScanner = new Scanner(roomNumbersFile); 
                    
                    while (buildingsScanner.hasNextLine()) 
                    {   
                        String building = buildingsScanner.nextLine();
                        String roomNumber = roomNumbersScanner.nextLine();
                        Classroom classroom = new Classroom(roomNumber, building);
                        college.getClassroomBag().insertClassroom(classroom);
                    }
                    buildingsScanner.close();
                    roomNumbersScanner.close();
                  } 
                  catch (FileNotFoundException e1)
                  {
                      e1.printStackTrace();
                  } 
                System.out.println("Classroom Import Complete.");
            });
        }   
        
        
        //Export Items
        {
            studentExportItem.setOnAction(e -> 
            {
                try
                {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.txt"));
                    oos.writeObject(college.getStudentBag().toString());                 
                    oos.close();
                } 
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                System.out.println("Student Export Complete.");                 
            });
            facultyExportItem.setOnAction(e -> 
            {
                try
                {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("faculty.txt"));
                    oos.writeObject(college.getFacultyBag().toString());                   
                    oos.close();
                } 
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                System.out.println("Faculty Export Complete.");                 
            });
            courseExportItem.setOnAction(e -> 
            {
                try
                {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("courses.txt"));
                    oos.writeObject(college.getCourseBag().toString());                   
                    oos.close();
                } 
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                System.out.println("Course Export Complete.");                 
            });
            textbookExportItem.setOnAction(e -> 
            {
                try
                {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("textbooks.txt"));
                    oos.writeObject(college.getTextbookBag().toString());                   
                    oos.close();
                } 
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                System.out.println("Textbook Export Complete.");                 
            });
            classroomExportItem.setOnAction(e -> 
            {
                try
                {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("classrooms.txt"));
                    oos.writeObject(college.getClassroomBag().toString());                  
                    oos.close();
                } 
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                System.out.println("Classroom Export Complete.");                 
            });
        }
        
        
        //Backup
        {
            backupItem.setOnAction(e -> 
            {
                try
                {
                    FileOutputStream fos1 = new FileOutputStream("students.dat", true);
                    ObjectOutputStream oos1 = new ObjectOutputStream(fos1);                   
                    oos1.writeObject(college.getStudentBag());
                    oos1.close();                    
                    
                    FileOutputStream fos2 = new FileOutputStream("faculty.dat", true);
                    ObjectOutputStream oos2 = new ObjectOutputStream(fos2);                   
                    oos2.writeObject(college.getFacultyBag());
                    oos2.close();                    
              
                    FileOutputStream fos3 = new FileOutputStream("courses.dat", true);
                    ObjectOutputStream oos3 = new ObjectOutputStream(fos3);                   
                    oos3.writeObject(college.getCourseBag());
                    oos3.close();                   

                    FileOutputStream fos4 = new FileOutputStream("textbooks.dat", true);
                    ObjectOutputStream oos4 = new ObjectOutputStream(fos4);                   
                    oos4.writeObject(college.getTextbookBag());
                    oos4.close();                   
            
                    FileOutputStream fos5 = new FileOutputStream("classrooms.dat", true);
                    ObjectOutputStream oos5 = new ObjectOutputStream(fos5);                   
                    oos5.writeObject(college.getClassroomBag());
                    oos5.close();  
                    
                    System.out.println("Backup Complete.");             
                } 
                catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                } 
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }                    
            });           
        }
        
        
        //Restore
        {
            restoreItem.setOnAction(e -> 
            {
                try
                {
                    FileInputStream fis1 = new FileInputStream("students.dat");
                    ObjectInputStream ois1 = new ObjectInputStream(fis1);
                    Student s = new StudentBag(10000);
                    s = (Student) ois1.readObject();
                    college.getStudentBag().insert(s);
                    ois1.close();
                    
                    FileInputStream fis2 = new FileInputStream("faculty.dat");
                    ObjectInputStream ois2 = new ObjectInputStream(fis2);
                    Faculty f = new FacultyBag(10000);
                    f = (Faculty) ois2.readObject();
                    college.getFacultyBag().insert(f);
                    ois2.close();
                    
                    FileInputStream fis3 = new FileInputStream("courses.dat");
                    ObjectInputStream ois3 = new ObjectInputStream(fis3);
                    Course c = new CourseBag(10000);
                    c = (Course) ois3.readObject();
                    college.getCourseBag().insertCourse(c);
                    ois3.close();
                    
                    FileInputStream fis4 = new FileInputStream("textbooks.dat");
                    ObjectInputStream ois4 = new ObjectInputStream(fis4);
                    Textbook t = new TextbookBag(10000);
                    t = (Textbook) ois4.readObject();
                    college.getTextbookBag().insertTextbook(t);
                    ois4.close();
                    
                    FileInputStream fis5 = new FileInputStream("classrooms.dat");
                    ObjectInputStream ois5 = new ObjectInputStream(fis5);
                    Classroom cl = new ClassroomBag(10000);
                    cl = (Classroom) ois5.readObject();
                    college.getClassroomBag().insertClassroom(cl);
                    ois5.close();
                    
                    System.out.println("Restore Complete.");
                } 
                catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                } 
                catch (ClassNotFoundException e1)
                {
                    e1.printStackTrace();
                } 
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            });               
        }
        
        
        //Edit items
        {            
            studentItem.setOnAction(e ->
            {
                Pane studentPane = new StudentPane(college).getPane();          
                root.setCenter(studentPane);               
            });
            facultyItem.setOnAction(e ->
            {
                Pane facultyPane = new FacultyPane(college).getPane();          
                root.setCenter(facultyPane);                
            });
            courseItem.setOnAction(e ->
            {
                Pane coursePane = new CoursePane(college).getPane();          
                root.setCenter(coursePane);               
            });
            textbookItem.setOnAction(e ->
            {
                Pane textbookPane = new TextbookPane(college).getPane();          
                root.setCenter(textbookPane);                
            });
            classroomItem.setOnAction(e ->
            {
                Pane classroomPane = new ClassroomPane(college).getPane();          
                root.setCenter(classroomPane); 
            });
        }
             
        Scene scene = new Scene(root, 800, 500);  
       
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
