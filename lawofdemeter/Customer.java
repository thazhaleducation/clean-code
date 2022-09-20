package lawofdemeter;

public class Customer {
  private Wallet wallet;

  Customer() {
    this.wallet = new Wallet();
    wallet.setAmount(100);
  }

  public Wallet getWallet() {
    return wallet;
  }

}
