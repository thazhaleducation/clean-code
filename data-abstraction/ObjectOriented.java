
public class ObjectOriented {
  public static void main(String[] args) {
    // Pay via cash
    Invoice invoice1 = new Invoice();
    invoice1.pay(new Cash(10));

    // Pay via card
    Invoice invoice2 = new Invoice();
    invoice2.pay(new Card("1234123412341234", 123));

    // Pay via upi
    Invoice invoice3 = new Invoice();
    invoice3.pay(new Upi("123123@upi"));
    invoice3.refund(new Upi("123123@upi"));
  }
}

class Invoice {
  public void pay(PaymentMethod paymentMethod) {
    paymentMethod.pay();
  }

  public void refund(PaymentMethod paymentMethod) {
    paymentMethod.refund();
  }
}

interface PaymentMethod {
  public void pay();
  public void refund();
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

  @Override
  public void refund() {
    System.out.println("Refunded as cash");
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

  @Override
  public void refund() {
    throw new UnsupportedOperationException();
  }

}

class Upi implements PaymentMethod {
  private String upiId;

  public Upi(String upiId) {
    this.upiId = upiId;
  }

  @Override
  public void pay() {
    sendRequestToUPIGateway();
  }

  private void sendRequestToUPIGateway() {
    System.out.println("Sending Request to UPI Gateway with upiId" + upiId);
  }

  @Override
  public void refund() {
    System.out.println("Refunded through UPI");
  }

}
