package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Increases efficiency of read operations.
 */

public class MainBasicBuffered {
  public static void main(String[] args) {
    BufferedReader inputFile = null;

    try {
      inputFile = new BufferedReader(new FileReader("country_code.csv"));

      String line;
      while ((line = inputFile.readLine()) != null) {

        System.out.println("Read : " + line);
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
