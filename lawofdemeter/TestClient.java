package lawofdemeter;

public class TestClient {

    public static void main(String[] args) {
      Invoice invoice1 = new Invoice(45);
      Customer customer = new Customer();
      
      // Process invoice1
      Shopkeeper shopkeeper =  new Shopkeeper();
      shopkeeper.processInvoice(customer, invoice1);
      
      // Process invoice2
      Invoice invoice2 = new Invoice(65);
      shopkeeper.processInvoice(customer, invoice2);
    }
}
