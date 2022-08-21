public class Comments {

  public static void main(String[] args) {
    int numberOfSoldTickets = 1;
    while (hasTickets(numberOfSoldTickets)) { 
      System.out.println("No of tickets sold:" + numberOfSoldTickets);
      // My team lead asked not to use increment operator. So used '+'
      numberOfSoldTickets = numberOfSoldTickets + 1;
    } //while
  } // main function

  // ######### Has tickets ########
  public static boolean hasTickets(int counter) {
    // Very small hall so only it has 10 tickets. I would not go here.
    int MAX_NO_OF_TICKETS  = 10;
    return counter <= MAX_NO_OF_TICKETS;
  }
}