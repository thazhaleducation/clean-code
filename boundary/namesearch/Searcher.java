package boundary.namesearch;

import java.util.List;

public class Searcher {
  private List<String> names;

  Searcher(List<String> names) {
    this.names = names;
    names.clear();
  }

  public Boolean isPresent(String nameToSearch) {
    return names.indexOf(nameToSearch) > -1;
  }
}
