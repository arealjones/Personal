package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by therapon on 7/11/16.
 */
public class MainByte {

  public static void main(String[] args) {
    FileInputStream inputFile = null;
    FileOutputStream outputFile = null;
    String errString = new String("Failed to close input stream in finally block");

    System.out.println(System.getProperty("user.dir"));

    try {

      inputFile = new FileInputStream("country_code.csv");
      outputFile = new FileOutputStream("country_code.out.csv");
      int byteRead;

      while ((byteRead = inputFile.read()) != -1) {
        System.out.println("Read : " + byteRead);
        outputFile.write(byteRead);
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
