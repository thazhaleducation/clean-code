import java.text.SimpleDateFormat;
import java.util.Date;

public class Comments {

  public static void main(String[] args) {
    int numberOfSoldTickets = 1;
    while (hasTickets(numberOfSoldTickets)) { 
      String date = getDate();
      System.out.println("Date: "+ date +" No of tickets sold:" + numberOfSoldTickets);
      numberOfSoldTickets = numberOfSoldTickets + 1;
    }

    Line l = new Line(new Point(1, 1), new Point(2, 1));
    System.out.println(l.length());
  }

  private static String getDate() {
    Date date = new Date();
    // Formats date into this format. Ex. Wed, 24 Aug 2022 19:34:57 IST
    SimpleDateFormat DateFor = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
    return DateFor.format(date);
  }

  public static boolean hasTickets(int counter) {
    int MAX_NO_OF_TICKETS  = 10;
    return counter <= MAX_NO_OF_TICKETS;
  }
}


class Point {
  Integer x;
  Integer y;
  
  public Point(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  } 
 }

class Line {
  private Point a;
  private Point b;
  
  public Line(Point a, Point b) {
    this.a = a;
    this.b = b;
  }

  /*
   * Uses distance formula between two points in cartesian system.
   * Reference: http://somelink
   */
  public Double length() {
    return Math.sqrt(square(a.x - b.x) + square(a.y - b.y));
  }

  // WARNING: Don't choose the 'n' more than 46340 i.e square root of max integer range.
  // TODO: implement to accept & return for datatype Double
  private Integer square(Integer n)  {
    // Preferred multiplication operator to Math.pow for better performance
    return n * n;
  }
 }
