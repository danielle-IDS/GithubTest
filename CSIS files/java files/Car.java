package sandbox;

public class Car
{
   private double _mph;
   private double _fuelInTank;
   private double _odometer;
   private int _fuelCapacity;
   
   public Car()
   {
      _mph = 0.0;
      _fuelInTank = 0.0;
      _odometer = 0.0;
      _fuelCapacity = 0;
   }
   
   public Car(double mpg, int capacity, double odometer)
   {
      this._mph = mpg;
      this._fuelCapacity = capacity;
      this._odometer = odometer;
      this._fuelInTank = capacity;
   }
   
   public void addGas(double gallons)
   {
      this._fuelInTank += gallons;
   }
   
   public void fillUp()
   {
      this._fuelInTank = this._fuelCapacity;
   }
   
   public void drive(double miles)
   {
      // update odometer
      // update fuel amount
   }
  
   public double getGasInTank()
   {
      return this._fuelInTank;
   }
   
   public double getMPH()
   {
      return this._mph;
   }
   
   public double getOdometer()
   {
      return this._odometer;
   }
   
   public int getTankCapacity()
   {
      return this._fuelCapacity;
   }

   public static void main(String[] args)
   {
      // TODO Auto-generated method stub

   }

}
