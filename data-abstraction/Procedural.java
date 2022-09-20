public class Procedural {
  public static void main(String[] args) {
    try {
      payInvoice();
    } catch (UnsupportedPaymentMethodException e) {
      System.err.println(e.toString());
    }
  }

  public static void payInvoice() throws UnsupportedPaymentMethodException {
    // Pay via cash
    Invoice invoice1 = new Invoice();
    invoice1.pay(new Cash(10));

    // Pay via card
    Invoice invoice2 = new Invoice();
    invoice2.pay(new Card("1234123412341234", 123));

    // Pay and Refund via upi
    Invoice invoice3 = new Invoice();
    invoice3.pay(new Upi("123123@upi"));
    invoice3.refund(new Upi("123123@upi"));
    
  }
}

class Invoice {
  public void pay(Object paymentMethod) throws UnsupportedPaymentMethodException {
    if (paymentMethod instanceof Cash) {
      Cash cash = (Cash) paymentMethod;
      System.out.println("Amount given in hand" + cash.amount);
    } else if (paymentMethod instanceof Card) {
      Card card = (Card) paymentMethod;
      sendRequestToVISA(card.cardNumber, card.pin);
      System.out.println("Amount paid in card");
    } else if (paymentMethod instanceof Upi) {
      Upi upi = (Upi) paymentMethod;
      sendRequestUpiGateway(upi.upiId);
      System.out.println("Paid via Upi " + upi.upiId);
    } else {
      throw new UnsupportedPaymentMethodException();
    }

  }


  public void refund(Object paymentMethod) throws UnsupportedPaymentMethodException {
    if (paymentMethod instanceof Cash) {
      Cash cash = (Cash) paymentMethod;
      System.out.println("Amount refunded" + cash.amount);
    } else if (paymentMethod instanceof Upi) {
      Upi upi = (Upi) paymentMethod;
      sendRequestUpiGateway(upi.upiId);
      System.out.println("Refunded via Upi " + upi.upiId);
    } else {
      throw new UnsupportedPaymentMethodException();
    }
  }

  private void sendRequestToVISA(String cardNumber, int pin) {
    System.out.println("Sending Request to VISA with card number and pin" + cardNumber + " " + pin);
  }

  private void sendRequestUpiGateway(String upiId) {
    System.out.println("Sending request to Upi gateway");
  }

}

class UnsupportedPaymentMethodException extends Exception {
}

class Cash {
  int amount;

  public Cash(int amount) {
    this.amount = amount;
  }
}

class Card {
  String cardNumber;
  int pin;

  public Card(String cardNumber, int pin) {
    this.cardNumber = cardNumber;
    this.pin = pin;
  }
}

class Upi {
  String upiId;

  public Upi(String upiId) {
    this.upiId = upiId;
  }
}