package argumentsexample;

import java.util.HashMap;
import java.util.Map;

public class ArgumentsExample {
  public static void main(String[] args) {
    UserInfo userInfo = new UserInfo("Karthee", "Nataraj", Gender.MALE);
    Map<String, String> enhancedUserDetails = getEnhancedUserDetails(userInfo);
    System.out.println(enhancedUserDetails);
  }

  public static Map<String, String> getEnhancedUserDetails(UserInfo userInfo) {
    String name = userInfo.name();
    String address = findAddressFor(userInfo.getPincode());
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

class UserInfo {
  private String firstName, lastName, pincode;
  private Gender gender;

  public UserInfo(String firstName, String lastName, Gender gender) {
    this.firstName = firstName;
    this.lastName = lastName;
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