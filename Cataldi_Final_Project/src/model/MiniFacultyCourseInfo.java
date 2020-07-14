package model;

public class MiniFacultyCourseInfo 
{
    enum CourseStatus {TAUGHT, TEACHING};
    private CourseStatus courseStatus;
        
    private String courseNumber, courseTitle;
    private int numberOfCredits;
    
    
    public MiniFacultyCourseInfo(String courseNumber, String courseTitle, 
                                 CourseStatus courseStatus, int numberOfCredits)
    {
        this.courseNumber = courseNumber;
        this.courseTitle = courseTitle;
        this.courseStatus = courseStatus;
        this.numberOfCredits = numberOfCredits;
    }
    public MiniFacultyCourseInfo(){}


    public String getCourseNumber()
    {
        return courseNumber;
    }
    public String getCourseTitle()
    {
        return courseTitle;
    }
    public CourseStatus getCourseStatus()
    {
        return courseStatus;
    }
    public int getNumberOfCredits()
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
    public void setCourseStatus(CourseStatus courseStatus)
    {
        this.courseStatus = courseStatus;
    }
    public void setNumberOfCredits(int numberOfCredits)
    {
        this.numberOfCredits = numberOfCredits;
    } 
}
