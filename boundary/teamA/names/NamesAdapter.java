package boundary.teamA.names;

import java.util.HashSet;
import java.util.Set;

import boundary.teamB.*;
public class NamesAdapter implements Names{
  private OriginalNames names;
  public NamesAdapter() {
    this.names = new OriginalNames();
  }

  @Override
  public Set<String> getNames() {
    return new HashSet<>(names.names().values());
  }
  
}
