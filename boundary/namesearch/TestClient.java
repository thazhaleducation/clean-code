package boundary.namesearch;

import java.util.List;
import java.util.ArrayList;

public class TestClient {

  public static void main(String[] args) {
    // Initialize searcher with list of names
    Searcher searcher = new Searcher(new ArrayList<String>() {
      {
        add("Raj");
        add("Prabu");
        add("Arther");
      }
    });

    // Search the names
    System.out.println("Name Raj found: " + searcher.isPresent("Raj"));
    System.out.println("Name Raj1 found: " + searcher.isPresent("Raj1"));
  }
}
