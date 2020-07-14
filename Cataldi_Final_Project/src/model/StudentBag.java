package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StudentBag extends Student implements Serializable
{
    private Student[] studentArray;
    private int nElms;
    
    
    public StudentBag(int maxSize)
    {
        studentArray = new Student[maxSize];
        nElms = 0;
    }
    
    
    public void insert(Student s)
    {
        studentArray[nElms++] = s;
    }
        
    public Student searchById(String id)
    {
        for(int i = 0; i < nElms; i++)
        {
            if(studentArray[i].getId().equals(id))
            {
                return studentArray[i];
            }
        }
        return null;
    }
        
    public Student removeById(String id)
    {
        int i;
        for(i = 0; i < nElms; i++)
        {
            if(studentArray[i].getId().contentEquals(id))
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
            Student temp = studentArray[i];
            for(int j = i; j < nElms - 1; j++)
            {
                studentArray[i] = studentArray[j + 1];
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
            stringBuilder.append(studentArray[i].getFirstName() + " " + studentArray[i].getLastName() + " " + 
                                 studentArray[i].getMajor() + " " + studentArray[i].getPhoneNumber() + '\n');            
        }       
        return stringBuilder.toString();
    }
}
