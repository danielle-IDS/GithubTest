// dince16@georgefox.edu
// Program 8
// 2016-03-06

/**
  * This class is a subclass of Product and has all the same qualities in addition to a book title and author.
 * @author danielleince
 *
 */
public class Book extends Product
{
    private String _bookTitle;
    private String _bookAuthor;
    
    /**
     * This constructs a Book by calling the superclass's constructor and initializing the title and author
     * @param id - the book's ID
     * @param desc - the book's description
     * @param price - the book's price
     * @param title - the book's title
     * @param author - the book's author
     */
    public Book(String id, String desc, double price, String title, String author)
    {
        super(id, desc, price);
        _bookTitle = title;
        _bookAuthor = author;
    }
    
    /**
     * This method retrieves the book's title
     * @return _bookTitle - the book's title
     */
    public String getBookTitle()
    {
        return _bookTitle;
    }
    
    /**
     * This method retrieves the book's author
     * @return _bookAuthor - the book's author
     */
    public String getBookAuthor()
    {
        return _bookAuthor;
    }
    
    /**
     * This method returns a string containing the contents of the book by calling the superclass's
     * toString() and adding the book title and author
     */
    public String toString()
    {
        return super.toString() +"," + _bookTitle + "," + _bookAuthor;
    }

}

