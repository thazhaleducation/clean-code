package boundary.teamA.names;

import java.util.Set;
import java.util.HashSet;

public class FakeNames implements Names {

  @Override
  public Set<String> getNames() {
    return new HashSet<String>() {
      {
        add("Raj");
        add("Prabu");
        add("Arther");
      }
    };
  }

  
}
