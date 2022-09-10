
public class ObjectOriented {
   public static void main(String[] args) {
    Invoice i = new Invoice();
    i.pay(new Cash(10));
   }
}


class Invoice {
  private PaymentMethod paymentMethod;

  Invoice(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public void pay() {
    paymentMethod.pay();
  }
}


interface PaymentMethod {
   public void pay();
}

class Cash implements PaymentMethod {
  private int amount;

  @Override
  public void pay() {
    System.out.println("Money given in hand is " + amount);
  }

}

class Card implements PaymentMethod {
  private long cardNumber;
  private int pin;

  Card(long cardNumber, int pin) {
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

// class Upi implements PaymentMethod {
//   private String upiId;

//   @Override
//   public void pay() {
//     sendRequestToUPIGateway();
//   }

//   private void sendRequestToUPIGateway() {
//     System.out.println("Sending Request to UPI Gateway with upiId" + upiId);
//   }
// }