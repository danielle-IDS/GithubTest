// dince16@georgefox.edu
// Program 8
// 2016-03-06

public class Book extends Product
{
    
    private String _bookTitle;
    private String _bookAuthor;
    
    public Book(String id, String desc, double price, String title, String author)
    {
        super(id, desc, price);
        _bookTitle = title;
        _bookAuthor = author;
    }
    
    public String getBookTitle()
    {
        return _bookTitle;
    }
    
    public String getBookAuthor()
    {
        return _bookAuthor;
    }
    
    public String toString()
    {
        return super.toString() +"\n" + "Title: " + _bookTitle + "\n" + "Author: " + _bookAuthor;
    }

}

