
public class ProgramTwo
{

   private String name;
   private double salary;
   
   public ProgramTwo (String employeeName, double currentSalary)
   {
      this.name = employeeName;
      this.salary = currentSalary;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public void setSalary( double newSalary)
   {
      this.salary = newSalary;
   }
   
   public String getName()
   {
      return this.name;
   }
   public double getSalary()
   {
      return this.salary;
   }
   
   public void raiseSalary(double byPercent)
   {
      // TODO
      // raise percent
   }
   
   
   
   public static void main(String[] args)
   {

   }

}
