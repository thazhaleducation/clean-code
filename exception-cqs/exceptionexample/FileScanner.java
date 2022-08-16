package exceptionexample;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 


public class FileScanner {
  public static void main(String[] args) {
    try {
      File fileToRead = new File("/Users/rajbharathkannan/raj/clean-code/exception-cqs/exceptionexample/file-to-read.txt");
      Scanner fileReader = new Scanner(fileToRead);
      while (fileReader.hasNextLine()) {
        String data = fileReader.nextLine();
        System.out.println(data);
      }
      fileReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found for the given path.");
      e.printStackTrace();
    }
  }

}
