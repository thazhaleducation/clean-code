package lawofdemeter;

public class Invoice {
  private int amount;

  public Invoice(int billAmount) {
    this.amount = billAmount;
  }

  public int getAmount() {
    return amount;
  }
}
