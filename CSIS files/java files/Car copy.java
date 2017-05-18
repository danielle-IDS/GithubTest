// dince16@georgefox.edu
// Program 3
// 2017-01-30

/**
 * A car that has a set mpg, amount of fuel in the tank, odometer
 * and fuel capacity.  Its capable of driving, adding gases, and
 * filling the tank up.
 */
public class Car
{
   private double _mpg;
   private double _fuelInTank;
   private double _odometer;
   private int _fuelCapacity;
   
   public Car()
   {
      _mpg = 20.0;
      _fuelInTank = 30.0;
      _odometer = 0.0;
      _fuelCapacity = 30;
   }
   
   public Car(double mpg, int capacity, double odometer)
   {
      this._mpg = mpg;
      this._fuelCapacity = capacity;
      this._odometer = odometer;
      this._fuelInTank = capacity;
   }
   
   /**
    * This method takes in the number of gallons that the user wants
    * and adds that amount to the fuel tank
    * 
    * @param the number of gallons
    */
   public void addGas(double gallons)
   {
      this._fuelInTank += gallons;
   }
   
   /**
    * This method sets the amount of fuel in the tank to tank fuel
    * capacity
    */
   public void fillUp()
   {
      this._fuelInTank = this._fuelCapacity;
   }
   
   /**
    * This method takes in the amount of miles the car has driven
    * and updates the odometer and fuel in tank.
    * 
    * @param the amount of miles the car has driven
    */
   public void drive(double miles)
   {
	  this._odometer += miles
      double numGallonsUsed = miles /this._mpg;
	  this._fuelInTank -= numGallonsUsed; 
   }
  
   /**
    * This method returns the amount of fuel in the objects tank
    * at that time.
    */
   public double getGasInTank()
   {
      return this._fuelInTank;
   }
   
   /**
    * This method returns the mpg of the car
    */
   public double getMPH()
   {
      return this._mph;
   }
   
   /**
    * This method returns how many miles are on the odometer
    */
   public double getOdometer()
   {
      return this._odometer;
   }
   
   /**
    * This method returns the car's tank capacity
    */
   public int getTankCapacity()
   {
      return this._fuelCapacity;
   }

   public static void main(String[] args)
   {
	   
   }

}
