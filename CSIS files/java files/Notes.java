package sandbox;
// 1.18.17


import java.util.GregorianCalendar;
import java.util.Calendar;
public class Notes
{

   public static void main(String[] args)
   {
      // TODO Auto-generated method stub
      // Ex. shape - properties
      //    radius, circumfirence, angle, sides, area, perimeter
      Calendar cal = new GregorianCalendar(1, 2, 2016);
      int day = cal.getFirstDayOfWeek();
      System.out.println(day);
      
      String message = "hello, world";
      
      message.replace(",", "");
      message.replace(".", "");
      message.replace("!", "");
      message.replace("?", "");
      message.replace(":", "");
      message.replace(";", "");
      
      System.out.print(message);
      
      /*
      System.out.println(cal.get(cal.DAY_OF_WEEK));
      System.out.println("WEEK_OF_MONTH: " + cal.get(cal.WEEK_OF_MONTH));
      */
      
      
      //FIGURE OUT THE SYNTAX FOR .ADD
      /*
      cal.add(Calendar.YEAR, 21);
      int weekdayOf21 = cal.get(Calendar.DAY_OF_WEEK);
      
      System.out.println();
      System.out.println("You were born on a " + weekdays[weekdayOf21 - 1]);
      */
      
      /*
      int minimal = cal.getMinimalDaysInFirstWeek();
      int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
      int firstDayOfWeek = cal.getFirstDayOfWeek();
      int month2 = cal.get(Calendar.MONTH);
      int year2 = cal.get(Calendar.YEAR);
      int weekDay = cal.get(Calendar.DAY_OF_WEEK);
      
      
      System.out.println(dayOfMonth);
      System.out.println(month2);
      System.out.println(year2);
      System.out.println(weekDay);
      System.out.println(firstDayOfWeek);
      System.out.println(minimal);
      */
      

   }

}
