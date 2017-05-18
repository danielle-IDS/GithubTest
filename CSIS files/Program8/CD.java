// dince16@georgefox.edu
// Program 8
// 2016-03-06

public class CD extends Product
{
    private String _cdTitle;
    
    public CD(String id, String desc, double price, String title)
    {
        super(id, desc, price);
        _cdTitle = title;
    }
    
    public String getCDTitle()
    {
        return _cdTitle;
    }
    
    public String toString()
    {
        return super.toString() + "\n" + "Title: " + _cdTitle;
    }
}

