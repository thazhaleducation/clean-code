public class Comments {
  public static void main(String[] args) {
    int numberOfSoldTickets = 1;
    while (hasTickets(numberOfSoldTickets)) { 
      System.out.println("No of tickets sold:" + numberOfSoldTickets);
      numberOfSoldTickets = numberOfSoldTickets + 1;
    }
  }

  public static boolean hasTickets(int counter) {
    int MAX_NO_OF_TICKETS  = 10;
    return counter <= MAX_NO_OF_TICKETS;
  }

  // public static void increaseTickets() {
  //   // Do some logic to increase tickets
  // }
}