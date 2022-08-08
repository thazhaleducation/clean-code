import java.text.DecimalFormat;
import java.util.ArrayList;

public class RefactoredFunctionExample {
  final static DecimalFormat df = new DecimalFormat("0.00");
  final static String HEADER = "S.No\tProduct Name\tPrice\tDiscountPrice\tPriceWithTax\n";

  public static void main(String[] args) {
    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new Product("Mobile", 13000.0, 10.0, 12.0));
    productList.add(new Product("Monitor", 15000.0, 5.0, 15.0));
    printInvoice(productList);
  }

  public static void printInvoice(ArrayList<Product> productList) {
    StringBuffer sb = new StringBuffer();
    sb.append(HEADER);

    for (int i = 0; i < productList.size(); i++) {
      Product p = productList.get(i);
      String invoiceStr = getInvoiceStr(p);
      String line = concatSerialNo(i + 1, invoiceStr);
      sb.append(line);
    }

    System.out.println(sb.toString());
  }


  public static String getInvoiceStr(Product p) {
    String discountedPriceStr = df.format(getDiscountedPrice(p));
    String priceWithTaxStr = df.format(getPriceWithTax(p, getDiscountedPrice(p)));
    return String.format("%s\t\t%s\t%s\t%s\n",
        p.getName(),
        p.getPrice().toString(),
        discountedPriceStr,
        priceWithTaxStr);
  }

  public static String concatSerialNo(int serialNo, String invoiceLine) {
    return String.format("%d\t%s", serialNo, invoiceLine);
  }

  public static Double getDiscountedPrice(Product p) {
    Double discountedPrice = 0.0;
    if (p.getDiscountPercentage() != 0) {
      discountedPrice = p.getPrice() - p.getDiscountPercentage() * p.getPrice() / 100;
    }
    return discountedPrice;
  }

  public static Double getPriceWithTax(Product p, Double discountedPrice) {
    Double priceWithTax = 0.0;
    if (p.getTaxPercentage() != 0) {
      priceWithTax = discountedPrice + discountedPrice * p.getTaxPercentage() / 100;
    }
    return priceWithTax;
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