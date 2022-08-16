package exceptionexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RefactoredFileScanner {

  public static void main(String[] args) {
    try {
      printFileContent("/Users/rajbharathkannan/raj/clean-code/exception-cqs/exceptionexample/file-to-read.txt");
    } catch (FileNotFoundException e) {
      logError(e);
    } 
  }

  public static void printFileContent(String filePath) throws FileNotFoundException{
    File file = new File(filePath);
    Scanner fileReader = new Scanner(file);
    while (fileReader.hasNextLine()) {
      String data = fileReader.nextLine();
      System.out.println(data);
    }
    fileReader.close();
  }

  public static void logError(Exception e) {
    System.out.println("File not found for the given path.");
    e.printStackTrace();
  }

}
