public class Procedural {
  public static void main(String[] args) {
    try {
      payInvoice();
    } catch (UnsupportedPaymentMethodException e) {
      System.err.println(e.toString());
    }
  }

  public static void payInvoice() {
    Invoice i = new Invoice();
    i.pay(new Cash(10));
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
    } else {
      throw new UnsupportedPaymentMethodException();
    }
  }

  private void sendRequestToVISA(String cardNumber, int pin) {
    System.out.println("Sending Request to VISA with card number and pin" + cardNumber + " " + pin);
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
}
