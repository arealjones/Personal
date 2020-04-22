package CommandLine.EmailLetterTemplate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class which handles processing of user input. While this class does do a bit of file
 * reading, the vast majority of processing, and writing, happens in other classes.
 */
public class Main {

    /**
     * Function which handles command line arguments.
     * @param args The arguments passed in by the user
     * @throws InvalidArgumentException Throws if the user inputs an invalid command.
     */
    public static void main(String[] args) throws InvalidArgumentException {
        CommandLineParser parser = new CommandLineParser(args);
        try (BufferedReader inputFile = new BufferedReader(new FileReader(parser.getInputFile()))) {
            String line;
            int count = 0;
            ArrayList<String> headerList = new ArrayList<>();
            while ((line = inputFile.readLine()) != null) {
                if (count == 0) {
                    CSV firstRow = new CSV(line);
                    headerList = firstRow.getLineAsList();
                }
                if (count > 0) {
                    ArrayList<String> lineAsList = (new CSV(line).getLineAsList());
                    if (parser.getEmailTemplateLocation() != null) {
                        TemplateProcessor newEmailDoc = new
                                TemplateProcessor(parser.getEmailTemplateLocation(),
                                parser.getOutputFileLocation(), headerList, lineAsList);
                        newEmailDoc.createFiles();
                    }
                    if (parser.getLetterTemplateLocation() != null) {
                        TemplateProcessor newLetterDoc = new
                                TemplateProcessor(parser.getLetterTemplateLocation(),
                                parser.getOutputFileLocation(), headerList, lineAsList);
                        newLetterDoc.createFiles();
                    }
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            throw new InvalidArgumentException("The file was not found.");
        } catch (IOException e) {
            throw new InvalidArgumentException("IO exception. ");
        }
    }
}
