// Usage
public class Procedural {
  public final int PETROL_PRICE_PER_LITRE = 112;
  public final int DIESEL_PRICE_PER_LITRE = 102;

  public double costPerKmPerPerson(Object vehicle) throws UnknownVehicleException {
    if (vehicle instanceof Bike) {
      Bike bike = (Bike)vehicle;
      int seatCount = 2;
      return PETROL_PRICE_PER_LITRE/ seatCount * bike.mileage;
    } else if (vehicle instanceof Car) {
      Car car = (Car) vehicle;
      int fuelPrice = PETROL_PRICE_PER_LITRE;
      if (car.fuleType == FuelType.DIESEL) {
        fuelPrice = DIESEL_PRICE_PER_LITRE;
      }
      return fuelPrice / car.seatCount * car.mileage;
    }
    throw new UnknownVehicleException();
   }

}


// Data definitions
class Bike {
  public int tankCapacity;
  public int mileage;
}

class Car {
  public int tankCapacity;
  public int mileage;
  public FuelType fuleType;
  public int seatCount;
}

// class Tractor {
//   public int tankCapacity;
//   public int mileage;
//   public FuelType fuleType;
//   public int seatCount;
// }

enum FuelType {
  PETROL,
  DIESEL
}

class UnknownVehicleException extends Exception{}


class Invoice {
  public void pay(Object paymentMethod) throws UnsupportedPaymentMethodException {
    if (paymentMethod instanceof Cash) {
      Cash cash = (Cash) paymentMethod;
      System.out.println("Amount given in hand" + cash.amount);
    } else if(paymentMethod instanceof Card) {
      Card card = (Card) paymentMethod;
      sendRequestToVISA(card.cardNumber, card.pin);
      System.out.println("Amount paid in card");
    } else {
      throw  new UnsupportedPaymentMethodException();
    }
  }
  
  private void sendRequestToVISA(long cardNumber, int pin) {
    System.out.println("Sending Request to VISA with card number and pin" + cardNumber + " " + pin);
  }

}


class UnsupportedPaymentMethodException extends Exception{}

class Cash {
  int amount;
}

class Card {
  long cardNumber;
  int pin;
}

// class Upi {
//   String upiId;
// }