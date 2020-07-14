package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable
{
    private String firstName, lastName, id, major, phoneNumber;
    private static int idCounter = 1;
    
 
    public Student(String firstName, String lastName, String major, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.phoneNumber = phoneNumber;
        this.id = String.valueOf(idCounter++);
    }
    public Student(){}


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
    public String getMajor()
    {
        return major;
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
    public void setMajor(String major)
    {
        this.major = major;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
