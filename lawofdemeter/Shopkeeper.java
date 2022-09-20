package lawofdemeter;

public class Shopkeeper {
  public void processInvoice(Customer customer, Invoice invoice) {
    if (customer.getWallet().getAmount() >= invoice.getAmount()) {
      customer.getWallet().setAmount(customer.getWallet().getAmount() - invoice.getAmount());
      System.out.println("Invoice Paid");
    } else {
      System.err.println("Insufficient Amount");
    }
  }
}
