package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Textbook implements Serializable
{       
    private String bookTitle, isbn, author, price;
    @SuppressWarnings("unused")
    private static double priceCounter = 0.00;
    
    
    public Textbook(String bookTitle, String isbn, String author)
    {
        this.bookTitle = bookTitle;
        this.isbn = isbn;
        this.author = author;
        this.price = String.valueOf(String.format("%.2f", priceCounter = (Math.random() * 200)));       
    }
    public Textbook(String isbn)
    {
        this.isbn = isbn;
    }
    public Textbook(){}


    public String getBookTitle()
    {
        return bookTitle;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getPrice()
    {
        return price;
    }


    public void setBookTitle(String bookTitle)
    {
        this.bookTitle = bookTitle;
    }
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
}
