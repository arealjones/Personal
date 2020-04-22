package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Make sure you are closing the file at the end.
 */

public class MainBasic {

  public static void main(String[] args) {
    FileReader inputFile = null;

    System.out.println(System.getProperty("user.dir"));

    try {
      inputFile = new FileReader("country_code.csv");

      int character;
      while ((character = inputFile.read()) != -1) {
        System.out.println("Read : " + character);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
    } finally {
      if (inputFile != null) {
        try {
          inputFile.close();
        } catch (IOException e) {
          System.out.println("Failed to close input stream");
        }
      }
    }
  }

}
