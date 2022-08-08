import java.text.DecimalFormat;
import java.util.ArrayList;

public class FunctionExample {
  public static void main(String[] args) {
    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new Product("Mobile", 13000.0, 10.0, 12.0));
    productList.add(new Product("Monitor", 15000.0, 5.0, 15.0));
    printInvoice(productList);
  }

  public static void printInvoice(ArrayList<Product> productList) {
    StringBuffer sb = new StringBuffer();
    sb.append("S.No\tProduct Name\tPrice\tDiscountPrice\tPriceWithTax\n");
    DecimalFormat df = new DecimalFormat("0.00");
    for (int i = 0; i < productList.size(); i++) {
      
      Product p = productList.get(i);
      Double discountedPrice;
      String discountedPriceStr;
      Double priceWithTax;
      String priceWithTaxStr;

      if(p.getDiscountPercentage() != 0) {
        discountedPrice = p.getPrice() - p.getDiscountPercentage() * p.getPrice()/100;
        discountedPriceStr = df.format(discountedPrice).toString();
      } else {
        discountedPrice = 0.0;
        discountedPriceStr = "-";
      }
      
      if(p.getTaxPercentage() != 0) {
        priceWithTax = discountedPrice + discountedPrice * p.getTaxPercentage()/100;
        priceWithTaxStr = df.format(priceWithTax).toString();
      } else {
        priceWithTaxStr = "-";
      }
      
      String line = String.format("%d\t%s\t\t%s\t%s\t%s\n",
          i + 1, p.getName(),
          p.getPrice().toString(),
          discountedPriceStr,
          priceWithTaxStr);
      sb.append(line);
    }
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