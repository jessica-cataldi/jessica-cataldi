package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TextbookBag extends Textbook implements Serializable
{
    private Textbook[] textbookArray;
    private int nElms;
    
    
    public TextbookBag(int maxSize) 
    {
        textbookArray = new Textbook[maxSize];
        nElms = 0;
    }
    
    
    public void insertTextbook(Textbook textbook)
    {
        textbookArray[nElms++] = textbook;
    } 
    
    public Textbook removeByIsbn(String isbn)
    {
        int i;
        for(i = 0; i < nElms; i++)
        {
           if(textbookArray[i].getIsbn().equals(isbn))
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
            Textbook t = textbookArray[i];
            for(int j = i; j < nElms - 1; j++)
            {
                textbookArray[j] = textbookArray[j+1];
            }
            nElms--;
            return t;
        }
    }
    
    public Textbook findByIsbn(String isbn)
    {
        for(int i = 0; i < nElms; i++)
        {
            if(textbookArray[i].getIsbn().equals(isbn))
            {
                return textbookArray[i];
            }
        }
        return null;
    }   
    
    
    public String toString()
    {
        StringBuilder  stringBuilder = new StringBuilder();
        
        for(int i = 0; i < nElms; i++)
        {         
            stringBuilder.append(textbookArray[i].getBookTitle() + " " + textbookArray[i].getIsbn() + 
                                 textbookArray[i].getAuthor() + textbookArray[i].getPrice() +'\n');            
        }       
        return stringBuilder.toString();
    }
}
