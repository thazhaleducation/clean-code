package boundary.teamA.search;

import java.util.Set;
import java.util.HashSet;

import boundary.teamA.names.*;

public class Searcher {
  private Set<String> names;

  public Searcher() {
    // Initialize the fake names
    this.names = new NamesAdapter().getNames();
  }

  public Boolean isPresent(String nameToSearch) {
    return names.contains(nameToSearch);
  }
}
