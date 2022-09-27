package boundary.teamA.search;

import java.util.Set;
import java.util.HashSet;

public class Searcher {
  private Set<String> names;

  public Searcher() {
    // Initialize the fake names
    this.names = new HashSet<String>() {
      {
        add("Raj");
        add("Prabu");
        add("Arther");
      }
    };
  }

  public Boolean isPresent(String nameToSearch) {
    return names.contains(nameToSearch);
  }
}
