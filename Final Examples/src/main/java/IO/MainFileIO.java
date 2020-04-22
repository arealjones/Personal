package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by therapon on 7/11/16.
 */
public class MainFileIO {

  public static void main(String[] args) {
    FileReader inputFile = null;
    FileWriter outputFile = null;
    String errString = new String("Failed to close input stream in finally block");

    System.out.println(System.getProperty("user.dir"));

    try {

      inputFile = new FileReader("country_code.csv");
      outputFile = new FileWriter("country_code.out.csv");
      int character;

      while ((character = inputFile.read()) != -1) {
        System.out.println("Read : " + character);
        outputFile.write(character);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    } finally {
      if (inputFile != null) {
        try {
          inputFile.close();
        } catch (IOException e) {
          System.out.println(errString);
          e.printStackTrace();
        }
      }
      if (outputFile != null) {
        try {
          outputFile.close();
        } catch (IOException e) {
          System.out.println(errString);
          e.printStackTrace();
        }
      }
    }
  }
}
