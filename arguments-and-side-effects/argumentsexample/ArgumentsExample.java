package argumentsexample;

import java.util.HashMap;
import java.util.Map;

public class ArgumentsExample {
  public static void main(String[] args) {
    Map<String, Object> userInfo = new HashMap<String, Object>() {{
      put("firstName", "Karthee");
      put("lastName", "Nataraj");
      put("gender", Gender.MALE);
      put("pincode", "123123");
    }};

    Map<String, String> enhancedUserDetails = getEnhancedUserDetails(userInfo);
    System.out.println(enhancedUserDetails);
  }

  // Casting is not a good practice can lead to issues in runtime
  // keys should be extracted into an enum
  public static Map<String, String> getEnhancedUserDetails(Map<String, Object> userInfo) {
    String greeting = ((Gender)userInfo.get("gender")).greeting();
    String name = formatName(greeting, userInfo.get("firstName").toString(), userInfo.get("lastName").toString());
    String address = findAddressFor(userInfo.get("pincode").toString());
    return new HashMap<String, String>() {
      {
        put("name", name);
        put("address", address);
      }
    };
  }

  public static String formatName(String greeting, String firstName, String lastName) {
    return String.format("%s %s %s", greeting, firstName, lastName);
  }

  public static String findAddressFor(String pincode) {
    return "Some Address";
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