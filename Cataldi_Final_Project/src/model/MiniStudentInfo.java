package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MiniStudentInfo implements Serializable
{
    private enum LetterGrade {A, B_PLUS, B, C_PLUS, C, D_PLUS,D, F, NO_GRADE};
    private LetterGrade letterGrade;
    private enum CourseStatus {TAKEN, TAKING, TO_TAKE};
    private CourseStatus courseStatus;
    
    private String courseNumber, courseTitle, courseDescription, numberOfCredits;
    private int numberOfCreditss;
    
    
    public MiniStudentInfo(String courseNumber, String courseTitle, String courseDescription, String numberOfCredits)
    {
        this.courseNumber = courseNumber;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.numberOfCredits = numberOfCredits;
    }
    public MiniStudentInfo(){}
    public MiniStudentInfo(String courseNumber, LetterGrade letterGrade, 
                           CourseStatus courseStatus, int numberOfCreditss)
    {
        this.courseNumber = courseNumber;
        this.letterGrade = letterGrade;
        this.courseStatus = courseStatus;
        this.numberOfCreditss = numberOfCreditss;
    }
    @SuppressWarnings("static-access")
    public MiniStudentInfo(String courseNumber)
    {
        this.courseNumber = courseNumber;
        this.letterGrade = letterGrade.NO_GRADE;
        this.courseStatus = courseStatus.TO_TAKE;
    }


    public String getCourseNumber()
    {
        return courseNumber;
    }
    public LetterGrade getLetterGrade()
    {
        return letterGrade;
    }
    public CourseStatus getCourseStatus()
    {
        return courseStatus;
    }
    public int getNumberOfCredits()
    {
        return numberOfCreditss;
    }


    public void setCourseNumber(String courseNumber)
    {
        this.courseNumber = courseNumber;
    }
    public void setLetterGrade(LetterGrade letterGrade)
    {
        this.letterGrade = letterGrade;
    }
    public void setCourseStatus(CourseStatus courseStatus)
    {
        this.courseStatus = courseStatus;
    }
    public void setNumberOfCredits(int numberOfCreditss)
    {
        this.numberOfCreditss = numberOfCreditss;
    }
  
    
    public String toString()
    {
        return courseNumber + "\n" + courseTitle + "\n" + courseDescription + "\n" + numberOfCredits + "\n\n";
    }      
}
