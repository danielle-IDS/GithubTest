// tstock15@georgefox.edu
// dince16@georgefox.edu
// Lab 1
// 2017-1-18

import java.util.Scanner;

public class Lab_1
{
   public static void main(String[] args)
   {
      double gpa;
      int age;
      String name;
      String city;
      Scanner in = new Scanner(System.in);
      // Scanner in2 = new Scanner(System.in);

      
      // Second block of inputs
      System.out.print("Enter GPA: ");
      gpa = in.nextDouble();
      System.out.print("Enter Age: ");
      age = in.nextInt();
      
      // First block of inputs
      
      System.out.print("Enter Full Name: ");
      in.skip("\n");
      name = in.nextLine();
      System.out.print("Enter Birth City: ");
      city = in.nextLine();



      // Show Results
      System.out.println("\n\nName: " + name);
      System.out.println("City: " + city);
      System.out.println("GPA: " + gpa);
      System.out.println("Age: " + age);
   }
}