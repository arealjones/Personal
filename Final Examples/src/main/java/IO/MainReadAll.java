package IO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Not a good idea for very large files.
 * Resources automatically cleaned up.
 */

public class MainReadAll {
    public static void main(String[] args) {
        try {
            Path in = Paths.get("country_code.csv");
            Path out = Paths.get("country_code.out.csv");
            List<String> lines = Files.readAllLines(in);
            for (String line: lines)
                System.out.println("Read: " + line);
            Files.write(out, lines);
        } catch (NoSuchFileException nsf) {
            System.out.println("*** OOPS! A file was not found : " + nsf.getMessage());
            nsf.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("Something went wrong! : " + ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
