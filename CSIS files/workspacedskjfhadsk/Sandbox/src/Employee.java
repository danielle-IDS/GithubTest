
public class Employee
{
   private String _name;
   private double _salary;
   
   public Employee (String employeeName, double currentSalary)
   {
      this._name = employeeName;
      this._salary = currentSalary;
   }
   
   public void setName(String name)
   {
      this._name = name;
   }
   
   public void setSalary( double newSalary)
   {
      this._salary = newSalary;
   }
   
   public String getName()
   {
      return this._name;
   }
   public double getSalary()
   {
      return this._salary;
   }
   
   public void raiseSalary(double byPercent)
   {
      // TODO
      // raise percent
      double percentOfSalary = ((byPercent/100) + 1) * this._salary;
      this._salary = percentOfSalary;
   }
   

   public static void main(String[] args)
   {
      // TODO Auto-generated method stub

   }

}
