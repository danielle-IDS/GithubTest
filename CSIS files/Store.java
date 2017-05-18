// dince16@georgefox.edu
// Program 9
// 2016-04-03

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.io.PrintWriter;

/**
 * This class contains an inventory made up of Inventory Line Items and has the ability to load a store
 * from a file, process orders and returns, and generate a list of products with a matching product type
 * @author danielleince
 *
 */
public class Store 
{
    
    private Inventory _inventory;
    
    /**
     * This constructs a Store object by initiating the _inventory variable
     */
    public Store()
    {
        _inventory = new Inventory();
    }
    
    /**
     * This method takes in the name of a file, constructs, scans, and processes it line by line
     * @param filename - a string variable that contains the name of the store file
     */
    public void loadStore(String filename)
    {
        try
        {
            Scanner in = new Scanner(new File(filename));
            while (in.hasNext())
            {
                this.processReturn(in.nextLine());
            }
            in.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Could not find file");
        }
        catch (NoSuchElementException e)
        {
            System.err.print("No such element");
        }
        
    }
    
    /**
     * This method accepts the order and separates the product object and its quantity.  It then attempts
     * to use the pick method and returns a string that describes the result of the order.
     * @param order a string that contains the product ID and quantity of the order
     * @return resultString a string that returns the result of the order
     */
    public String processOrder(String order)
    {
        String[] productInfo = order.split(",");
        int result = _inventory.pick(productInfo[0], Integer.parseInt(productInfo[1]));
        String resultString = "";
        if (result < 1)
        {
            resultString = "Out of Stock";
        }
        else if (result == 0)
        {
            resultString = "The order was successful!";
        }
        else
        {
            resultString = "Not enough in stock, we have only " + result + " quantity on hand.";
        }
        return resultString;
        
    }
    
    /**
     * This method processes a line of the order by separating out each component and updating the inventory
     * based on the product ID
     * @param item - The line of a store file that contains all the components of a line item
     */
    public void processReturn(String item)
    {
        Product product = null;
        String[] productInfo = item.split(",");
        String productID = productInfo[0];
        String productDesc = productInfo[1];
        double productPrice = Double.parseDouble(productInfo[2]);
        int qty = Integer.parseInt(productInfo[productInfo.length-1]);
        if (productID.startsWith("CD"))
        {
            product = new CD(productID, productDesc, productPrice, productInfo[3]);
        }
        else if (productID.startsWith("BOOK"))
        {
            product = new Book(productID, productDesc, productPrice, productInfo[3], productInfo[4]);
        }
        else if (productID.startsWith("FD"))
        {
            product = new FlashDrive(productID, productDesc, productPrice, Integer.parseInt(productInfo[3]));
        }
        if (product != null)
        {
            _inventory.restock(product, qty);
        }
    }
    
    /**
     * This method creates an array of type product and fills it with all products that match the 
     * given product type.
     * @param productType - the name of the product object
     * @return productList - an array of products with matching product type
     */
    public Product[] getProductList(String productType)
    {
        ArrayList<Product> productList = new ArrayList<Product>();
        InventoryLineItem[] temp = _inventory.getInventoryListing(productType);
        for (InventoryLineItem item: temp)
        {
            productList.add(item.getProduct());
        }
        Product[] products = new Product[productList.size()];
        return productList.toArray(products);
    }
    
    /**
     * This method accepts a filename and writes the the current inventory to that file.
     * @param filename - the store file's string name
     */
    public void saveStore(String filename)
    {
    	try
    	{
        	PrintWriter out = new PrintWriter(filename);
        	InventoryLineItem[] items = _inventory.getInventoryListing("");
        	for (InventoryLineItem item: items)
        	{
        		out.println(item.toString());
        	}
        	out.close();
    	}
    	catch (FileNotFoundException e)
    	{
    		System.err.println("File not found");
    	}
    }
    
    /**
     * This method accepts an array of transactions and processes each transaction depending on whether
     * its an order or return.  It returns the result of each attempt to process a transaction
     * @param transactions - an array of transactions
     * @return an array of the string result from each attempt to process a transaction
     */
    public String[] processTransactions(Transaction[] transactions)
    {
    	String[] processed = new String[transactions.length];
    	for (int i = 0; i < processed.length; i++)
    	{
    		if (transactions[i].isReturn())
    		{
        		this.processReturn(transactions[i].getTransaction());
        		processed[i] = "Return was successful";
    		}
    		else
    		{
        		processed[i] = this.processOrder(transactions[i].getTransaction());
    		}
    	}
    	return processed;
    }

}
