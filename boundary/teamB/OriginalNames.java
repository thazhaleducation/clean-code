package boundary.teamB;

import java.util.HashMap;

public class OriginalNames {
  public HashMap<String, String> names() {
    return new HashMap<String,String>() {
      {
        put("name1", "Raj");
        put("name2", "Prabu");
        put("name3", "Arther");
      }
    };
  }
}
