
public class ObjectOriented {
  public static void main(String[] args) {
    // Pay via cash
    Invoice invoice1 = new Invoice();
    invoice1.pay(new Cash(10));

    // Pay via card
    Invoice invoice2 = new Invoice();
    invoice2.pay(new Card("1234123412341234", 123));
  }
}

class Invoice {
  public void pay(PaymentMethod paymentMethod) {
    paymentMethod.pay();
  }
}

interface PaymentMethod {
  public void pay();
}

class Cash implements PaymentMethod {
  private int amount;

  public Cash(int amount) {
    this.amount = amount;
  }

  @Override
  public void pay() {
    System.out.println("Money given in hand is " + amount);
  }

}

class Card implements PaymentMethod {
  private String cardNumber;
  private int pin;

  Card(String cardNumber, int pin) {
    this.cardNumber = cardNumber;
    this.pin = pin;
  }

  @Override
  public void pay() {
    sendRequestToVISA();
  }

  private void sendRequestToVISA() {
    System.out.println("Sending Request to VISA with card number and pin" + cardNumber + " " + pin);
  }

}
