package lawofdemeter;

public class Customer {
  private WalletUpdated wallet;

  Customer() {
    this.wallet = new WalletUpdated();
    wallet.addAmount(100);
  }

  public WalletUpdated getWallet() {
    return wallet;
  }

  public boolean payInvoice(Invoice invoice) {
    if (wallet.hasSufficientBalance(invoice.getAmount())) {
      wallet.deductAmount(invoice.getAmount());
      return true;
    }
    return false;
  }

}
