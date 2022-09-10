interface Vehicle {
  public final int PETROL_PRICE_PER_LITRE = 112;
  public final int DIESEL_PRICE_PER_LITRE = 102;
  public double costPerKmPerPerson();
  // public double isCommuter();
}

class Bike implements Vehicle{
  private int mileage = 40;
  private int seatCount = 2;

  @Override
  public double costPerKmPerPerson() {
      return PETROL_PRICE_PER_LITRE/ seatCount * mileage;
  }
}

class Car implements Vehicle{
  private int mileage;
  private int seatCount = 4;
  private FuelType fuelType;

  public Car(int mileage, int seatCount, FuelType fuelType) {
    this.mileage = mileage;
    this.seatCount = seatCount;
    this.fuelType = fuelType;
  }

  @Override
  public double costPerKmPerPerson() {
      return getFuelPrice()/ seatCount * mileage;
  }

  private int getFuelPrice() {
    if (fuelType == FuelType.PETROL) {
      return PETROL_PRICE_PER_LITRE;
    }
    return DIESEL_PRICE_PER_LITRE;
  }
}


enum FuelType {
  PETROL,
  DIESEL
}



interface ContentManager {
  public void read();
  public void append();
}

class JsonFile implements ContentManager {
  public String content;

  public JsonFile(String jsonContent) {
    this.content = jsonContent;
  }
  @Override
  public void read() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void append() {
    // TODO Auto-generated method stub
    
  }

}

// Calculator
// Post message to a social media
// Travel - book ticket, cancel ticket, bus,train, aeroplane
// payment device - (data - cash, card, upi) (functions - pay, refund)
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




class Upi implements PaymentMethod {
  private String upiId;

  @Override
  public void pay() {
    sendRequestToUPIGateway();
  }

  private void sendRequestToUPIGateway() {
    System.out.println("Sending Request to UPI Gateway with upiId" + upiId);
  }
}