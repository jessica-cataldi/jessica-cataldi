package model;

public class MiniFacultyCourseBag
{
    private MiniFacultyCourseInfo[] miniFacultyCourseInfoArray;
    private int nElms;
    
    
    public MiniFacultyCourseBag(int maxSize)
    {
        miniFacultyCourseInfoArray = new MiniFacultyCourseInfo[maxSize];
        nElms = 0;
    }
    
    
    public void insert(MiniFacultyCourseInfo miniFacultyCourseInfo) 
    {
        miniFacultyCourseInfoArray[nElms++] = miniFacultyCourseInfo;
    }
       
    public MiniFacultyCourseInfo findByCourseNumber(String courseNumber) 
    {
        for(int i = 0; i < nElms; i++) 
        {
            if(miniFacultyCourseInfoArray[i].getCourseNumber().contentEquals(courseNumber)) 
            {
                return miniFacultyCourseInfoArray[i];
            }
        }
        return null;
    }
        
    public MiniFacultyCourseInfo removeByCourseNumber(String courseNumber) 
    {
        int i;
        for(i = 0; i < nElms; i++) 
        {
            if(miniFacultyCourseInfoArray[i].getCourseNumber().contentEquals(courseNumber)) 
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
            MiniFacultyCourseInfo temp = miniFacultyCourseInfoArray[i];
            for(int j = i; j<nElms-1; j++) 
            {
                miniFacultyCourseInfoArray[i] = miniFacultyCourseInfoArray[i+1];
            }
            nElms--;
            return temp;
        }
    }
}
