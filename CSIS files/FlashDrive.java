// dince16@georgefox.edu
// Program 8
// 2016-03-06

/**
 * This class is a subclass of Product and has all the same qualities in addition to a a flash drive capacity.
 * @author danielleince
 *
 */
public class FlashDrive extends Product
{
    private int _flashDriveCapacity;
    
    /**
     * This constructs a flash drive object by calling the superclass's constructor and initiating
     * the flash drive capacity.
     * @param id - the flash drive's ID
     * @param desc - the flash drive's description
     * @param price - the flash drive's price
     * @param capacity - the flash drive's capacity
     */
    public FlashDrive(String id, String desc, double price, int capacity)
    {
        super(id, desc, price);
        _flashDriveCapacity = capacity;
    }
    
    /**
     * This method retrieves the flash drive's capacity
     * @return _flashDriveCapacity - the flash drive's capacity
     */
    public int getFlashDriveCapacity()
    {
        return _flashDriveCapacity;
    }
    
    /**
     * This method returns a string containing the contents of the flash drive by calling the superclass's
     * toString() and adding the flash drive capacity
     */
    public String toString()
    {
        return super.toString() + "," 
            + String.format("%1$1d", this._flashDriveCapacity);
    }
}

