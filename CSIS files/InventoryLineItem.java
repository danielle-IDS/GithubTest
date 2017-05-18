// dince16@georgefox.edu
// Program 8
// 2016-03-06

/**
 * This class has a product, quantity, discount rate and subtotal.It has the ability to set its discount
 * rate and subtotal, and retrieve all of its individual components
 * @author danielleince
 *
 */
public class InventoryLineItem 
{
    private static int _numLineItems = 0;
    
    private int _lineItemNum;
    private Product _product;
    private int _lineItemQty;
    private double _lineItemDiscountRate;
    private double _lineItemSubtotal;
    
    /**
     * This constructs an InventoryLineItem object with the given product and quantity.  It also sets
     * the discount rate and subtotal
     * @param product
     * @param lineItemQty
     */
    public InventoryLineItem(Product product, int lineItemQty)
    {
        _product = product;
        _lineItemQty = lineItemQty;
        _numLineItems++;
        _lineItemNum = _numLineItems;
        this.setLineItemDiscountRate();
        this.setLineItemSubtotal();
    }
    
    /**
     * This method sets the line item's discount rate based off of predetermined limits.
     */
    public void setLineItemDiscountRate()
    {
        if (_lineItemQty < 10)
        {
            _lineItemDiscountRate = 0.0;
        }
        else if (_lineItemQty < 25)
        {
            _lineItemDiscountRate = 0.10;
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
    
    /**
     * This method sets the subtotal by multiplying the price by the quantity by the discount rate.
     */
    public void setLineItemSubtotal()
    {
        double price = _product.getProductPrice();
        _lineItemSubtotal = _lineItemQty * price * (1 - _lineItemDiscountRate);
    }
    
    /**
     * This method returns the line item's number
     * @return the line item number
     */
    public int getLineItemNum()
    {
        return _lineItemNum;
    }
    
    /**
     * This method returns the inventoryLineItem's product
     * @return the product
     */
    public Product getProduct()
    {
        return _product;
    }
    
    /**
     * This method returns the line item's quantity
     * @return the line item's quantity
     */
    public int getLineItemQty()
    {
        return _lineItemQty;
    }
    
    /**
     * This method returns the line item's discount rate 
     * @return the line item's discount rate 
     */
    public double getLineItemDiscountRate()
    {
        return _lineItemDiscountRate;
    }
    
    /**
     * This method returns the line item's subtotal
     * @return the line item's subtotal
     */
    public double getLineItemSubtotal()
    {
        return _lineItemSubtotal;
    }
    
    /**
     * This method adjusts the line item's quantity by the given amount assuming the quantity does not 
     * fall below 0.
     * @param adjustment
     */
    public void adjustLineItemQty(int adjustment)
    {
        if (_lineItemQty + adjustment > 0)
        {
            _lineItemQty += adjustment;
            this.setLineItemDiscountRate();
            this.setLineItemSubtotal();
        }
        else
        {
            System.out.println("Not enough product in stock");
        }
    }
    
    /**
     * This method creates a string that contains all the components of the line item.
     */
    public String toString()
    {
        return _product.toString() + ","
                + String.format("%1$1d", this._lineItemQty) + ","
                + String.format("%1$.2f", this._lineItemDiscountRate) + ","
                + String.format("%1$,.2f", this._lineItemSubtotal);
        /*  ORIGINAL
         * return "Line Item Num: " + String.format("%1$1d", this._lineItemNum) + "\n"
                + _product.toString() + "\n"
                + "Quantity: " + String.format("%1$1d", this._lineItemQty) + "\n"
                + "Discount Rate: " + String.format("%1$.2f", this._lineItemDiscountRate) + "\n"
                + "Subtotal: $" + String.format("%1$,.2f", this._lineItemSubtotal) + "\n";
         */
    }
}
