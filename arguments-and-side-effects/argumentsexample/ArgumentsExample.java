package argumentsexample;

import java.util.HashMap;
import java.util.Map;

public class ArgumentsExample {
  public static void main(String[] args) {
    Map<String, String> enhancedUserDetails =  getEnhancedUserDetails("Karthee", "Nataraj", Gender.MALE, "123123");  
    System.out.println(enhancedUserDetails);
  }


  public static Map<String, String> getEnhancedUserDetails(String firstName, String lastName, Gender gender, String pincode) {
    String greeting = "";
    switch (gender) {
      case MALE:
        greeting = "Mr.";
        break;
      case FEMALE:
        greeting = "Ms.";
        break;
      default:
        greeting = "Mr./Ms.";
        break;
    }
    String name = String.format("%s %s %s", greeting, firstName, lastName);
    String address = findAddressFor(pincode);
    return new HashMap<String, String>() {{
      put("name", name);
      put("address", address);
    }};
  }

  public static String findAddressFor(String pincode) {
    return "Some Address";
  }
}

enum Gender {
  MALE,
  FEMALE
}