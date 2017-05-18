// dince16@georgefox.edu
// Program 8
// 2016-03-06

// !!!!!!!
// READ THROUGH PUBLIC INTERFACE

public class InventoryLineItem 
{
    private static int _numLineItems = 0;
    
    private int _lineItemNum;
    private Product _product;
    private int _lineItemQty;
    private double _lineItemDiscountRate;
    private double _lineItemSubtotal;
    
    
    public InventoryLineItem(Product product, int lineItemQty)
    {
        _product = product;
        _lineItemQty = lineItemQty;
        _numLineItems++;
        _lineItemNum = _numLineItems;
        this.setLineItemDiscountRate();
        this.setLineItemSubtotal();
    }
    
    public void setLineItemDiscountRate()
    {
        if (_lineItemQty < 10)
        {
            _lineItemDiscountRate = 0.0;
        }
        else if (_lineItemQty < 25)
        {
            this._lineItemDiscountRate = 0.10;
        }
        else if (_lineItemQty < 50)
        {
            _lineItemDiscountRate = 0.20;
        }
        else
        {
            _lineItemDiscountRate = 0.25;
        }
    }
    
    public void setLineItemSubtotal()
    {
        double price = _product.getProductPrice();
        _lineItemSubtotal = _lineItemQty * price * (1 + _lineItemDiscountRate);
    }
    
    public int getLineItemNum()
    {
        return _lineItemNum;
    }
    
    public Product getProduct()
    {
        return _product;
    }
    
    public int getLineItemQty()
    {
        return _lineItemQty;
    }
    
    public double getLineItemDiscountRate()
    {
        return _lineItemDiscountRate;
    }
    
    public double getLineItemSubtotal()
    {
        return _lineItemSubtotal;
    }
    
    public String toString()
    {
        return "Line Item Num: " + String.format("%1$1d", this._lineItemNum) + "\n"
                + _product.toString() + "\n"
                + "Quantity: " + String.format("%1$1d", this._lineItemQty) + "\n"
                + "Discount Rate: " + String.format("%1$.2f", this._lineItemDiscountRate) + "\n"
                + "Subtotal: $" + String.format("%1$,.2f", this._lineItemSubtotal) + "\n";
    }
}
