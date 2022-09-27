package boundary;

import boundary.teamA.search.Searcher;

public class TestClient {

  public static void main(String[] args) {
    
    Searcher searcher = new Searcher();

    // Search the names
    System.out.println("Name Raj found: " + searcher.isPresent("Raj"));
    System.out.println("Name Raj1 found: " + searcher.isPresent("Raj1"));
  }
}
