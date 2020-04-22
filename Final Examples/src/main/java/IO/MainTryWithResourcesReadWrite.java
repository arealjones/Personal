package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by therapon on 7/11/16.
 */
public class MainTryWithResourcesReadWrite {

  public static void main(String[] args) {

    System.out.println(System.getProperty("user.dir"));

    try (BufferedReader inputFile =new BufferedReader(new FileReader("country_code.csv"));
         BufferedWriter outputFile = new BufferedWriter(new FileWriter("country_code.out.csv"))) {

      String line;

      while ((line = inputFile.readLine()) != null) {
        System.out.println("Read : " + line);
        outputFile.write(line + System.lineSeparator());
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }
}
