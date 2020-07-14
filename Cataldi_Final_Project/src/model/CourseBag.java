package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CourseBag extends Course implements Serializable
{
    private Course[] courseArray;
    private int nElms;
    
    
    public CourseBag(int maxSize)
    {
        courseArray = new Course[maxSize];
        nElms = 0;
    }
    
    
    public void insertCourse(Course course)
    {
        courseArray[nElms++] = course;
    }  
    
    public Course removeByCourseNumber(String courseNumber)
    {
        int i;
        for(i = 0; i < nElms; i++)
        {
           if(courseArray[i].getCourseNumber().equals(courseNumber))
           {
               break;
           }
        }
        if(i == nElms)
        {
            return null;
        }
        else
        {
            Course c = courseArray[i];
            for(int j = i; j < nElms - 1; j++)
            {
                courseArray[j] = courseArray[j+1];
            }
            nElms--;
            return c;
        }
    } 
    
    public Course findByCourseNumber(String courseNumber)
    {
        for(int i = 0; i < nElms; i++)
        {
            if(courseArray[i].getCourseNumber().equals(courseNumber))
            {
                return courseArray[i];
            }
        }
        return null;
    }
    
    
    public String toString()
    {
        StringBuilder  stringBuilder = new StringBuilder();
        
        for(int i = 0; i < nElms; i++)
        {         
            stringBuilder.append(courseArray[i].getCourseNumber() + " " + courseArray[i].getCourseTitle() + " " + 
                                 courseArray[i].getCourseDescription() + " " + courseArray[i].getNumberOfCredits() + '\n');            
        }       
        return stringBuilder.toString();
    }
}
