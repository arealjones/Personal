package IO;

import java.io.*;

/**
 * Automatically closes the reader or writer.
 * No need to set the reader to null outside try-catch.
 * No need for a finally block to close the reader.
 */

public class MainTryWithResources {
    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));

        try (BufferedReader inputFile = new BufferedReader(new FileReader("country_code.csv"))) {
            String line;
            while ((line = inputFile.readLine()) != null) {
                System.out.println("Read : " + line);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("Something went wrong! : " + ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
