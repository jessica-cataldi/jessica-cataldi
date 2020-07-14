package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MiniStudentCourseBag extends MiniStudentInfo implements Serializable
{
    private static MiniStudentInfo[] miniStudentInfoArray;
    private static int nElms;
    
    
    public MiniStudentCourseBag(int maxSize)
    {
        miniStudentInfoArray = new MiniStudentInfo[maxSize];
        nElms = 0;
    }
    
    
    public void insert(MiniStudentInfo miniStudentInfo) 
    {
        miniStudentInfoArray[nElms++] = miniStudentInfo;
    }
       
    public MiniStudentInfo findByCourseNumber(String courseNumber) 
    {
        for(int i = 0; i < nElms; i++) 
        {
            if(miniStudentInfoArray[i].getCourseNumber().contentEquals(courseNumber)) 
            {
                return miniStudentInfoArray[i];
            }
        }
        return null;
    }
        
    public MiniStudentInfo removeByCourseNumber(String courseNumber) 
    {
        int i;
        for(i = 0; i < nElms; i++) 
        {
            if(miniStudentInfoArray[i].getCourseNumber().contentEquals(courseNumber)) 
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
            MiniStudentInfo temp = miniStudentInfoArray[i];
            for(int j = i; j<nElms-1; j++) 
            {
                miniStudentInfoArray[i] = miniStudentInfoArray[i+1];
            }
            nElms--;
            return temp;
        }
    }
}
