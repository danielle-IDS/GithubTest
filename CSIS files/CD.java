// dince16@georgefox.edu
// Program 8
// 2016-03-06

/**
 * This class is a subclass of Product and has all the same qualities in addition to a cd title.
 * @author danielleince
 *
 */
public class CD extends Product
{
    private String _cdTitle;
    
    /**
     * This constructs a CD object by passing the first 3 parameters to the super class and initiating
     * the CD title parameter
     * @param id - the CD's ID
     * @param desc - the CD's description
     * @param price - the CD's price
     * @param title - the CD's title
     */
    public CD(String id, String desc, double price, String title)
    {
        super(id, desc, price);
        _cdTitle = title;
    }
    
    /**
     * The method gets the CD's title and returns it
     * @return _cdTitle - the CD title
     */
    public String getCDTitle()
    {
        return _cdTitle;
    }
    
    /**
     * This method returns a string containing the contents of the CD by calling the superclass's
     * toString() and adding the CD title.
     */
    public String toString()
    {
        return super.toString() + "," + _cdTitle;
    }
}

