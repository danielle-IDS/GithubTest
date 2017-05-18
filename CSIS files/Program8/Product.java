// dince16@georgefox.edu
// Program 8
// 2016-03-06

public class Product 
{
    private String _productID;
    private String _productDesc;
    private double _productPrice;
    
    public Product(String id, String desc, double price)
    {
        _productID = id;
        _productDesc = desc;
        _productPrice = price;
    }
    
    public String getProductID()
    {
        return _productID;
    }
    
    public String getProductDesc()
    {
        return _productDesc;
    }
    
    public double getProductPrice()
    {
        return _productPrice;
    }
    
    public String toString()
    {
        return "ID: " + _productID + "\n" + "Description: " + _productDesc + "\n"
        + "Price: $" + String.format("%1$.2f", this._productPrice);
        
    }
}

