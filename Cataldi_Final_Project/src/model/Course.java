package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Course implements Serializable
{
    private String courseNumber, courseTitle, courseDescription, numberOfCredits;
    
    
    public Course(String courseNumber, String courseTitle, 
                  String courseDescription, String numberOfCredits)
    {
        this.courseNumber = courseNumber;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.numberOfCredits = numberOfCredits;
    }
    public Course(){}


    public String getCourseNumber()
    {
        return courseNumber;
    }
    public String getCourseTitle()
    {
        return courseTitle;
    }
    public String getCourseDescription()
    {
        return courseDescription;
    }
    public String getNumberOfCredits()
    {
        return numberOfCredits;
    }


    public void setCourseNumber(String courseNumber)
    {
        this.courseNumber = courseNumber;
    }
    public void setCourseTitle(String courseTitle)
    {
        this.courseTitle = courseTitle;
    }
    public void setCourseDescription(String courseDescription)
    {
        this.courseDescription = courseDescription;
    }
    public void setNumberOfCredits(String numberOfCredits)
    {
        this.numberOfCredits = numberOfCredits;
    }  
}
