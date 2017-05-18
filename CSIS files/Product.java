// dince16@georgefox.edu
// Program 8
// 2016-03-06

/**
 * This class consists of and ID, description and price.  It has the ability to retrieve its particular 
 * components and also print them out.
 * @author danielleince
 *
 */
public class Product 
{
    private String _productID;
    private String _productDesc;
    private double _productPrice;
    
    /**
     * This constructs a product object with and ID, description and price
     * @param id - the product's ID
     * @param desc - the product's description
     * @param price - the product's price
     */
    public Product(String id, String desc, double price)
    {
        _productID = id;
        _productDesc = desc;
        _productPrice = price;
    }
    
    /**
     * This method gets the product's ID and returns it
     * @return _productID - the product's ID
     */
    public String getProductID()
    {
        return _productID;
    }
    
    /**
     * This method gets the product's description and returns it
     * @return _productDesc - the product's description
     */
    public String getProductDesc()
    {
        return _productDesc;
    }
    
    /**
     * This method gets the product's price and returns it
     * @return _prodcutPrice - the product's price
     */
    public double getProductPrice()
    {
        return _productPrice;
    }
    
    /**
     * This method creates and returns a string containing all the components of the product
     */
    public String toString()
    {
        return _productID + "," + _productDesc + ","
            + String.format("%1$.2f", _productPrice);
    }
}

