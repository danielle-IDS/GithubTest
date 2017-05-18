package sandbox;
// dince16@georgefox.edu
// Program 1
// 2016-01-23

import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class ProgramOne
{

   public static void main(String[] args)
   {
      
      Scanner in = new Scanner(System.in);
      
      System.out.print("Please enter your birth month: ");
      int month = in.nextInt();
      month--;
      System.out.print("Please enter your birth day: ");
      int day = in.nextInt();
      System.out.print("Please enter your birth year: ");
      int year = in.nextInt();
      
      GregorianCalendar cal = new GregorianCalendar(year, month, day);
      int birthday = cal.get(Calendar.DAY_OF_WEEK);
      String[] WEEKDAYS = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
      
      System.out.println();
      System.out.println("Your birthday was on a " + WEEKDAYS[birthday - 1]);
      
      cal.add(Calendar.YEAR, 21);
      int twentyFirstBirthday = cal.get(Calendar.DAY_OF_WEEK);
      System.out.println("Your 21st birthday is on a " + WEEKDAYS[twentyFirstBirthday - 1]);
      
     

   }

}
