package sandbox;
// dince16@georgefox.edu
// Program 1
// 2017.01.20


public class Circle
{
   // PROPERTIES
   private double radius = 0.0;
   private double area = 0.0;
   private double PI = 3.1415629;
   // what happens when you don't specify public or private?
   
   
   public Circle(double radius)
   {
      this.radius = radius;
   }
   
   // BEHAVIORS
   public double getRadius()
   {
      return this.radius;
   }
   
   void setRadius(double r)
   {
      if (r > 0.0)
      {
         this.radius = r;
      }
   }
   
   public double calcArea()
   {
      // area = 2(PI)r^2
      this.area = 2 * this.PI * this.radius * this.radius;
      return this.area;
   }

   public static void main(String[] args)
   {
      // TODO Auto-generated method stub
      
      
      
      
      
      
      
      
      

   }

}
