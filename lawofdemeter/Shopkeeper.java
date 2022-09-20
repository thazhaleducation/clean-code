package lawofdemeter;

public class Shopkeeper {
  public void processInvoice(Customer customer, Invoice invoice) {
    Boolean isPaid = customer.payInvoice(invoice);
    if (isPaid) {
      System.out.println("Invoice Paid");
    } else {
      System.err.println("Insufficient Amount");
    }
  }
}
