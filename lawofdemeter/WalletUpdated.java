package lawofdemeter;

public class WalletUpdated {
  private int amount = 0;

  public boolean hasSufficientBalance(int amountToPay) {
    return amount >= amountToPay;
  }

  public void addAmount(int amountToAdd) {
    this.amount += amountToAdd;
  }

  public void deductAmount(int amountToDeduct) {
    this.amount -= amountToDeduct;
  }
} 
