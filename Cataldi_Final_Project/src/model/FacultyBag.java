package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FacultyBag extends Faculty implements Serializable
{
    private Faculty[] facultyArray;
    private int nElms;
    
    
    public FacultyBag(int maxSize)
    {
        facultyArray = new Faculty[maxSize];
        nElms = 0;
    }
    
    
    public void insert(Faculty f)
    {
        facultyArray[nElms++] = f;
    }
    
    
    public Faculty searchById(String id)
    {
        for(int i = 0; i < nElms; i++)
        {
            if(facultyArray[i].getId().equals(id))
            {
                return facultyArray[i];
            }
        }
        return null;
    }
    
    
    public Faculty removeById(String id)
    {
        int i;
        for(i = 0; i < nElms; i++)
        {
            if(facultyArray[i].getId().contentEquals(id))
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
            Faculty temp = facultyArray[i];
            for(int j = i; j < nElms - 1; j++)
            {
                facultyArray[i] = facultyArray[j + 1];
            }
            nElms--;
            return temp;
        }
    }
    
    
    public String toString()
    {
        StringBuilder  stringBuilder = new StringBuilder();
        
        for(int i = 0; i < nElms; i++)
        {         
            stringBuilder.append(facultyArray[i].getFirstName() + " " + facultyArray[i].getLastName() + " " + 
                                 facultyArray[i].getTitle() + " " + facultyArray[i].getPhoneNumber() + '\n');            
        }       
        return stringBuilder.toString();
    }
}
