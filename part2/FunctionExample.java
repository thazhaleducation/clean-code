import java.text.DecimalFormat;
import java.util.ArrayList;

public class FunctionExample {
  public static void main(String[] args) {
    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new Product("Mobile", 13000.0, 10.0, 12.0));
    productList.add(new Product("Monitor", 15000.0, 5.0, 15.0));
    productList.add(new Product("Speaker", 15000.0, 5.0, 0.0));
    productList.add(new Product("Mouse", 1000.0, 0.0, 5.0));
    printInvoice(productList);
  }

  public static void printInvoice(ArrayList<Product> productList) {
    // String buffer initialization
    StringBuffer sb = new StringBuffer();
    
    // Adding HEADER to String buffer
    sb.append("S.No\tProduct Name\tPrice\tDiscountPrice\tPriceWithTax\n");
    // Declare and initializse a Formatter for double with 2 decimal
    DecimalFormat df = new DecimalFormat("0.00");

    // Looping the products
    for (int i = 0; i < productList.size(); i++) {
      
      // Declare local variables
      Product p = productList.get(i);
      Double discountedPrice;
      String discountedPriceStr;
      Double priceWithTax;
      String priceWithTaxStr;

      // if product has discountPercentage other than 0 then calculate discounted
      // price and discounted price string
      // Otherwise set discounted price to product price
      if(p.getDiscountPercentage() != 0) {
        discountedPrice = p.getPrice() - p.getDiscountPercentage() * p.getPrice()/100;
        discountedPriceStr = df.format(discountedPrice).toString();
      } else {
        discountedPrice = p.getPrice();
        discountedPriceStr = p.getPrice().toString();
      }
      
      // if product has taxPercentage other than 0 then calculate tax for the discounted prices
      // and its string format
      // Otherwise set price with tax equal to the discountedPrice of the product
      if(p.getTaxPercentage() != 0) {
        priceWithTax = discountedPrice + discountedPrice * p.getTaxPercentage()/100;
        priceWithTaxStr = df.format(priceWithTax).toString();
      } else {
        priceWithTax = discountedPrice;
        priceWithTaxStr = discountedPrice.toString();
      }
      // Format the string to be added with all values
      String line = String.format("%d\t%s\t\t%s\t%s\t%s\n",
          i + 1, 
          p.getName(),
          p.getPrice().toString(),
          discountedPriceStr,
          priceWithTaxStr);
      // Add invoice line to string buffer
      sb.append(line);
    }
    // print the complete invoice string
    System.out.println(sb.toString());
  }
}













class Product {
  private String name;
  private Double price;
  private Double discountPercentage;
  private Double taxPercentage;
  public Product(String name, Double price, Double discountPercentage, Double taxPercentage) {
    this.name = name;
    this.price = price;
    this.discountPercentage = discountPercentage;
    this.taxPercentage = taxPercentage;
  }
  public Double getDiscountPercentage() {
    return discountPercentage;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public Double getTaxPercentage() {
    return taxPercentage;
  }
}