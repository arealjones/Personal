package CommandLine.EmailLetterTemplate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Template Processor is created to read in a template and output new files for each individual
 * in the CSV file. */
public class TemplateProcessor {
  private int numFields;
  private List<String> fields = new ArrayList<>();
  private File template;
  private String outputLocation;
  private List<String> csvHeaders;
  private List<String> csvLine;

  /**
   * Constructor for the template class.
   * @param template The template text file that will be passed in.
   * @param outputLocation The location for the output files.
   * @param csvHeaders The headers of the CSV file.
   * @param csvLine A line in the CSV file that needs to be outputted to a text file. */
  public TemplateProcessor(String template, String outputLocation, List<String> csvHeaders,
      List<String> csvLine) {
    this.template = new File(template);
    this.outputLocation = outputLocation;
    this.csvHeaders = csvHeaders;
    this.csvLine = csvLine;
  }

  /**
   * Returns the path to the template.
   * @return Returns the path to the template. */
  public File getTemplate() {
    return this.template;
  }

  /**
   * Returns the path to the output Location.
   * @return Returns the path to the output Location. */
  public String getOutputLocation() {
    return this.outputLocation;
  }

  /**
   * Returns the headers in the CSV file.
   * @return Returns the headers in the CSV file. */
  public List<String> getCsvHeaders() {
    return this.csvHeaders;
  }

  /**
   * Returns contents of the line from the CSV file.
   * @return Returns contents of the line from the CSV file. */
  public List<String> getCsvLine() {
    return this.csvLine;
  }

  /**
   * Checks to see if the CSV file has all of the information that the template needs.
   * @param csvHeaders The list of the CSV Headers.
   * @return True if the CSV file has all of the fields that the template needs, false otherwise.*/
  private boolean isValid(List<String> csvHeaders) {
    int count = 0;
    for (int i = 0; i < csvHeaders.size(); i++) {
      if (this.fields.contains(csvHeaders.get(i))) {
        count += 1;
      }
    }
    return (this.numFields == count);
  }

  /**
   * Helper method to read the template file and adds any fields within brackets to a list.
   //* @param path The path to the template file. */
  private void readFile() throws InvalidArgumentException {
    try (BufferedReader reader = new BufferedReader(new FileReader(this.template))) {
      String line;
      while((line = reader.readLine()) != null) {
        Pattern brackets = Pattern.compile("\\[\\[(.*?)\\]\\]");
        Matcher matching = brackets.matcher(line);
        while (matching.find()) {
          if (this.fields.contains(matching.group(1))) {
            break;
          }
          this.fields.add(matching.group(1));
        }
      }
      this.numFields = this.fields.size();
    } catch (FileNotFoundException e) {
      throw new InvalidArgumentException("File was not found.");
    } catch (IOException e) {
      throw new InvalidArgumentException("IO exception.");
    }
  }

  /**
   * Creates new files based on the information in each line of the CSV file.
   * @throws InvalidArgumentException If the file was not found, IO exceptions, and if the CSV file
   * is missing information that the template needs. */
  public void createFiles() throws InvalidArgumentException {
    readFile();
    if (!isValid(this.csvHeaders)) {
      throw new InvalidArgumentException("The CSV File does not contain all required fields. ");
    } else {
      File person = new File(this.outputLocation + File.separator + this.csvLine.get(0) +
          ".txt");
      person.getParentFile().mkdirs();
      try (BufferedReader templateFile = new BufferedReader(new FileReader(this.template));
            BufferedWriter outputFile = new BufferedWriter(new FileWriter(person))) {
        String line;
        while ((line = templateFile.readLine()) != null) {
          Pattern brackets = Pattern.compile("\\[\\[(.*?)\\]\\]");
          Matcher matching = brackets.matcher(line);
          while (matching.find()) {
            for (int i = 0; i < this.csvLine.size(); i++) {
              if (this.csvHeaders.get(i).equals(matching.group(1))) {
                line = line.replace(matching.group(1), this.csvLine.get(i));
              }
            }
            line = line.replace("[[", "");
            line = line.replace("]]", "");
          }
          outputFile.write(line + System.lineSeparator());
        }
        } catch (FileNotFoundException e) {
          throw new InvalidArgumentException("File was not found. ");
        } catch (IOException e) {
          throw new InvalidArgumentException("IO exception. ");
        }
      }
    }

  /**
   * Returns true if the current object and the one being compared are the same.
   * @param o The object being compared.
   * @return Returns true if the objects are the same, false otherwise. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateProcessor that = (TemplateProcessor) o;
    return Objects.equals(template, that.template) &&
        Objects.equals(outputLocation, that.outputLocation) &&
        Objects.equals(csvHeaders, that.csvHeaders) &&
        Objects.equals(csvLine, that.csvLine);
  }

  /**
   * Returns the hashcode of the object.
   * @return Returns the hashcode of the object. */
  @Override
  public int hashCode() {
    return Objects.hash(template, outputLocation, csvHeaders, csvLine);
  }

  /**
   * Returns a string describing the current template and CSV file.
   * @return Returns a string describing the current template and CSV file. */
  @Override
  public String toString() {
    return "The Template Processor is using the " + template + "template. \nIt will be creating "
        + "the new files in this location: " + outputLocation + ".\nThe fields in the CSV file "
        + "are: " + csvHeaders + ".\nAnd the line being created into a file includes:" + csvLine +
        '.';
  }
}


