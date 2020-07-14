package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ClassroomBag extends Classroom implements Serializable
{
    private Classroom[] classroomArray;
    private int nElms;
    
    
    public ClassroomBag(int maxSize)
    {
        classroomArray = new Classroom[maxSize];
        nElms = 0;
    }
    
    
    public void insertClassroom(Classroom classroom)
    {
        classroomArray[nElms++] = classroom;
    }  
    
    public Classroom removeByRoomNumber(String roomNumber)
    {
        int i;
        for(i = 0; i < nElms; i++)
        {
           if(classroomArray[i].getRoomNumber().equals(roomNumber))
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
            Classroom c = classroomArray[i];
            for(int j = i; j < nElms - 1; j++)
            {
                classroomArray[j] = classroomArray[j+1];
            }
            nElms--;
            return c;
        }
    } 
    
    public Classroom findByRoomNumber(String roomNumber)
    {
        for(int i = 0; i < nElms; i++)
        {
            if(classroomArray[i].getRoomNumber().equals(roomNumber))
            {
                return classroomArray[i];
            }
        }
        return null;
    }  
    
    
    public String toString()
    {
        StringBuilder  stringBuilder = new StringBuilder();
        
        for(int i = 0; i < nElms; i++)
        {         
            stringBuilder.append(classroomArray[i].getRoomNumber() + " " + classroomArray[i].getBuildingName() + '\n');            
        }       
        return stringBuilder.toString();
    }
}