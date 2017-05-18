// dince16@georgefox.edu
// Program 8
// 2016-03-06

public class FlashDrive extends Product
{
    private int _flashDriveCapacity;
    
    public FlashDrive(String id, String desc, double price, int capacity)
    {
        super(id, desc,price);
        _flashDriveCapacity = capacity;
    }
    
    public int getFlashDriveCapacity()
    {
        return _flashDriveCapacity;
    }
    
    public String toString()
    {
        return super.toString() + "\n" 
    + "Capacity: " + String.format("%1$1d", this._flashDriveCapacity);
    }
}

