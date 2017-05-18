// dince16@georgefox.edu
// Program 2
// 2017-01-30

/**
 * An employee with a name and salary.
 */
public class Employee
{
   private String _name = "";
   private double _salary = 0.0;
   
   public Employee (String employeeName, double currentSalary)
   {
      this._name = employeeName;
      this._salary = currentSalary;
   }
   
   /**
    * This method sets the employee's name
    * 
    * @param the new name of the employee
    */
   public void setName(String newName)
   {
      this._name = newName;
   }
   
   /**
    * This method sets the employee's salary
    * 
    * @param the employee's new salary
    */
   public void setSalary(double newSalary)
   {
      this._salary = newSalary;
   }
   
   /**
    * This method returns the employee's name
    */
   public String getName()
   {
      return this._name;
   }
   
   /**
    * This method returns the employee's salary
    */
   public double getSalary()
   {
      return this._salary;
   }
   
   /**
    * This method takes in a percent, and calculate a new salary by
    * raising the original salary by the given percent
    * 
    * @param the percent to raise the salary
    */
   public void raiseSalary(double byPercent)
   {
	   this._salary = ((byPercent/100) + 1) * this._salary;
   }
   
   public static void main(String[] args)
   {

   }

}
