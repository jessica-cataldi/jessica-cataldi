package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Faculty implements Serializable
{
    private String firstName, lastName, id, title, phoneNumber;
    private static int idCounter = 1;
    
 
    public Faculty(String firstName, String lastName, String title, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.id = String.valueOf(idCounter++);
    }
    public Faculty(){}


    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getId()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }


    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }  
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }    
}
