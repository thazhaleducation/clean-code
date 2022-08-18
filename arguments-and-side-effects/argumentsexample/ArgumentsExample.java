package argumentsexample;

import java.util.HashMap;
import java.util.Map;

public class ArgumentsExample extends Thread {
  private static UserInfo userInfo;
  public static void main(String[] args) throws InterruptedException {
    userInfo = new UserInfo("Karthee", "Nataraj", Gender.MALE, "123132");
    Map<String, String> enhancedUserDetails = getEnhancedUserDetails();
    System.out.println(enhancedUserDetails);
  }

  public static Map<String, String> getEnhancedUserDetails() throws InterruptedException {
    // Simulate shared state's side effect
    simulateSideEffect();
    String name = userInfo.name();
    String address = findAddressFor(userInfo.getPincode());
    return new HashMap<String, String>() {
      {
        put("name", name);
        put("address", address);
      }
    };
  }

  public static void simulateSideEffect() throws InterruptedException {
    new ArgumentsExample().start();
    Thread.sleep(1000);
  }

  public void run() {
    userInfo.setGender(Gender.FEMALE);
  }

  
  public static String formatName(String greeting, String firstName, String lastName) {
    return String.format("%s %s %s", greeting, firstName, lastName);
  }

  public static String findAddressFor(String pincode) {
    return "Some Address";
  }


}

class UserInfo {
  private String firstName, lastName, pincode;
  private Gender gender;

  public UserInfo(String firstName, String lastName, Gender gender, String pincode) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.pincode = pincode;
    this.gender = gender;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPincode() {
    return pincode;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String name() {
    return String.format("%s %s %s", gender.greeting(), firstName, lastName);
  }
}
interface Gender {
  public static final Gender MALE = new MALE();
  public static final Gender FEMALE = new FEMALE();

  public String greeting();
}

class MALE implements Gender {
  public String greeting() {
    return "Mr.";
  }
}

class FEMALE implements Gender {
  public String greeting() {
    return "Mrs.";
  }
}