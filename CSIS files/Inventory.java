// dince16@georgefox.edu
// Program 9
// 2016-04-03

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains an arrayList of Inventory Line Items and has the ability to find a particular 
 * line item, pick/restock a certain quantity of a product, get the quantity of a product in stock, get the
 * value of the entire inventory, and generate an array of InventoryLineItems with matching product types
 * @author danielleince
 *
 */
public class Inventory 
{
    private ArrayList<InventoryLineItem> _lineItems;
    
    /**
     * This constructs an Inventory object by initiating the _lineItems ArrayList
     */
    public Inventory()
    {
        _lineItems = new ArrayList<InventoryLineItem>();
    }
    
    /**
     * This searches through the ArrayList in the inventory and finds the object with the matching 
     * productID if there is one and then either returns the object or null.
     * @param productID
     * @return Either the InventoryLineItem or null if it cannot be found
     */
    public InventoryLineItem findInventoryItem(String productID)
    {
    	InventoryLineItem newItem = null;
    	InventoryLineItem tempItem;
    	for (InventoryLineItem item: _lineItems)
        {
            if (item.getProduct().getProductID().equals(productID))
            {
                newItem = item;
            }
        }
        return newItem;
    }

    /**
     * This method finds uses the findInventoryLineItem() method to find the object in the inventory and
     * returns the quantity if there's not enough in stock to pick, -1 if the object does not exist or 0
     * if the product exists and there's enough in stock to pick.
     * @param productID
     * @param qty
     * @return
     */
    public int pick(String productID, int qty)
    {
        int result;
        InventoryLineItem target = this.findInventoryItem(productID);
        if (target == null)
        {
            result = -1;
        }
        else if (target.getLineItemQty() - qty < 0)
        {
            result = this.getQtyInStock(productID);
        }
        else
        {
            this.findInventoryItem(productID).adjustLineItemQty(qty);
            result = 0;
        }
        return result;
    }
    
    /**
     * This method either adjusts the quantity of the given product if it exists or creates a new product
     * with the given quantity if it doesn't exist.
     * @param product
     * @param qty
     */
    public void restock(Product product, int qty)
    {
        if (this.findInventoryItem(product.getProductID()) == null)
        {
            _lineItems.add(new InventoryLineItem(product, qty));
        }
        else
        {
            this.findInventoryItem(product.getProductID()).adjustLineItemQty(qty);
        }
    }
    
    /**
     * This method uses the findInventoryLineItem method and returns the quantity of that product.
     * @param productID
     * @return the InventoryLineItem's quantity in stock
     */
    public int getQtyInStock(String productID)
    {
    	int quantity = 0;
        InventoryLineItem item = this.findInventoryItem(productID);
        if (item != null)
        {
        	quantity = item.getLineItemQty();
        }
        return quantity;
    }
    
    /**
     * This method traverses the ArrayList _inventory and calculates the sum of the entire inventory
     * @return the sum of the entire inventory
     */
    public double getInventoryValue()
    {
        double value = 0.0;
        for (InventoryLineItem item: _lineItems)
        {
            value += item.getLineItemSubtotal();
        }
        return value;
    }
    
    /**
     * This method constructs an array of InventoryLineItem objects and fills it with InventoryLineItems
     * whose products match that of the productType
     * @param productType
     * @return an array of Inventory line items of the same product type
     */
    public InventoryLineItem[] getInventoryListing(String productType)
    {
        ArrayList<InventoryLineItem> items = new ArrayList<InventoryLineItem>();
        InventoryLineItem[] itemsArray;
        if (productType.equals(""))
        {
            for (InventoryLineItem item: _lineItems)
            {
                items.add(item);
            }
        }
        else
        {
            for (InventoryLineItem item: _lineItems)
            {
                if (item.getProduct().getProductID().startsWith(productType))
                {
                    items.add(item);
                }
            }
        }
        itemsArray = new InventoryLineItem[items.size()];
        return items.toArray(itemsArray);
    }
    
}
