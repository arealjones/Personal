package assignment8;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Parses and validates the command line arguments passed in from Main
 */
public class CommandLineParser {

  private static final String[] REQUIRED_ARGS = {"--output-dir", "--csv-file"};
  private static final String[] EMAIL_ARGS = {"--email", "--email-template"};
  private static final String[] LETTER_ARGS = {"--letter", "--letter-template"};
  private static final String REGEX_TEMPLATE = "[\\w\\d-_]+\\.txt";
  private static final String REGEX_INPUT = "[\\w\\d-_]+\\.csv";
  private static final String REGEX_OUTPUT = "[\\w\\d-_/\\\\]+[/\\\\]";
  private String outputLoc;
  private String inputFile;
  private String emailTemplate;
  private String letterTemplate;


  /**
   * Constructor for the CommandLineParser class
   * @param args The command line arguments provided by the user.
   * @throws InvalidArgumentException If the arguments are invalid.
   */
  public CommandLineParser(String[] args) throws InvalidArgumentException {
    List<String> argsList = convertToArrayList(args);
    validateArgs(argsList);
    this.outputLoc = pullOutputLoc(argsList);
    this.inputFile = pullInputFile (argsList);
    this.emailTemplate = pullEmailTemplate (argsList);
    this.letterTemplate = pullLetterTemplate(argsList);
  }

  /**
   * Gets the output file location (file path)
   * @return the output file location (file path) as String
   */
  public String getOutputFileLocation() {
    return this.outputLoc;
  }

  /**
   * Gets the input file location (file path)
   * @return the output file location (file path) as String
   */
  public String getInputFile() {
    return this.inputFile;
  }

  /**
   * Gets the email template location (file path)
   * @return the email template location (file path) as String
   */
  public String getEmailTemplateLocation() {
    return this.emailTemplate;
  }

  /**
   * Gets the letter template location (file path)
   * @return the letter template location (file path) as String
   */
  public String getLetterTemplateLocation() {
    return this.letterTemplate;
  }

  /**
   * Converts String[] to a ArrayList<String>
   * @param args string[]
   * @return List<String>
   */
  private static List<String> convertToArrayList(String[] args) {
    return Arrays.asList(args);
  }

  /**
   * Validates the list of arguments
   * @param args List<String> of arguments
   * @return true if the arguments are valid, false otherwise.
   * @throws InvalidArgumentException If the arguments are invalid.
   */
  private static boolean validateArgs(List<String> args) throws InvalidArgumentException {
    containsRequiredArgs(args);
    if (args.contains(EMAIL_ARGS[0])) {
      validateEmailArgs(args);
    }
    if (args.contains(LETTER_ARGS[0])) {
      validateLetterArgs(args);
    }
    validateOutputDir(args);
    validateInputFile(args);
    return true;
  }

  /**
   * Checks the input List<String> contains the minimum of the required arguments.
   * @param args List<String> of arguments
   * @throws InvalidArgumentException If the arguments are invalid.
   */
  private static void containsRequiredArgs(List<String> args) throws InvalidArgumentException {
    if (!args.contains(REQUIRED_ARGS[0]))
      throw new InvalidArgumentException(String.format("Input must include the %s argument.",
          REQUIRED_ARGS[0]));
    if (!args.contains(REQUIRED_ARGS[1]))
      throw new InvalidArgumentException(String.format("Input must include the %s argument.",
          REQUIRED_ARGS[1]));
    if(! (args.contains(EMAIL_ARGS[0]) || args.contains(LETTER_ARGS[0])))
      throw new InvalidArgumentException(String.format("Input must include %s or %s arguments.",
          EMAIL_ARGS[0], LETTER_ARGS[0]));
  }

  /**
   * Validates that the email arguments --email is directly followed  by the --email-template
   * <path/to/file> argument
   * @param args List<String> of arguments
   * @throws InvalidArgumentException If the arguments are invalid.
   */
  private static void validateEmailArgs(List<String> args) throws InvalidArgumentException {
    int index = args.indexOf(EMAIL_ARGS[0]);
    if ((index + 1) >= args.size() || (!args.get(index + 1).equals(EMAIL_ARGS[1])) ||
        (index + 2) >= args.size() || (!args.get(index + 2).matches(REGEX_TEMPLATE)))
      throw new InvalidArgumentException("--email must be directly followed by --email-template "
          + "<path/to/file>.txt");
  }

  /**
   * Validates that the letter arguments --letter is directly followed  by the --letter-template
   * <path/to/file> argument
   * @param args List<String> of arguments
   * @throws InvalidArgumentException If the arguments are invalid.
   */
  private static void validateLetterArgs(List<String> args) throws InvalidArgumentException {
    int index = args.indexOf(LETTER_ARGS[0]);
    if ((index + 1) >= args.size() || (!args.get(index + 1).equals(LETTER_ARGS[1])) ||
        (index + 2) >= args.size() || (!args.get(index + 2).matches(REGEX_TEMPLATE)))
      throw new InvalidArgumentException("--letter must be directly followed by --letter-template "
          + "<path/to/file>.txt");
  }

  /**
   * Validates that the --output-dir <path/to/folder> argument is properly formatted
   * @param args List<String> of arguments
   * @throws InvalidArgumentException If the arguments are invalid.
   */
  private static void validateOutputDir(List<String> args) throws InvalidArgumentException {
    int index = args.indexOf(REQUIRED_ARGS[0]);
    if ((index + 1) >= args.size() || (!args.get(index + 1).matches(REGEX_OUTPUT)))
      throw new InvalidArgumentException("--output-dir must be directly followed by"
          + "<path/to/folder/>");
  }

  /**
   * Validates that the --csv-file <path/to/file> argument is properly formatted
   * @param args List<String> of arguments
   * @throws InvalidArgumentException If the arguments are invalid.
   */
  private static void validateInputFile(List<String> args) throws InvalidArgumentException {
    int index = args.indexOf(REQUIRED_ARGS[1]);
    if ((index + 1) >= args.size() || (!args.get(index + 1).matches(REGEX_INPUT)))
      throw new InvalidArgumentException("--csv-file must be directly followed by"
          + "<path/to/file>.csv");
  }

  /**
   * Returns the output location (file path) string from the list of args
   * @param args List<String> of arguments
   * @return output location (file path) string
   */
  private String pullOutputLoc(List<String> args) {
    return args.get(args.indexOf(REQUIRED_ARGS[0]) + 1);
  }

  /**
   * Returns the input file (file path) string from the list of args
   * @param args List<String> of arguments
   * @return input file (file path) string
   */
  private String pullInputFile(List<String> args) {
    return args.get(args.indexOf(REQUIRED_ARGS[1]) + 1);
  }

  /**
   * Returns the email template (file path) string from the list of args
   * @param args List<String> of arguments
   * @return email template (file path) string if the arg exists, null otherwise
   */
  private String pullEmailTemplate(List<String> args) {
    int index = args.indexOf(EMAIL_ARGS[1]);
    if (index >= 0) {
      return args.get(index + 1);
    }
    return null;
  }

  /**
   * Returns the letter template (file path) string from the list of args
   * @param args List<String> of arguments
   * @return letter template (file path) string if the arg exists, null otherwise
   */
  private String pullLetterTemplate(List<String> args) {
    int index = args.indexOf(LETTER_ARGS[1]);
    if (index >= 0) {
      return args.get(index + 1);
    }
    return null;
  }

  /**
   * Checks if the current CommandLineParser object and the one being compared are the same.
   * @param o The object being compared.
   * @return true if the objects are the same, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommandLineParser that = (CommandLineParser) o;
    return Objects.equals(outputLoc, that.outputLoc) &&
        Objects.equals(inputFile, that.inputFile) &&
        Objects.equals(emailTemplate, that.emailTemplate) &&
        Objects.equals(letterTemplate, that.letterTemplate);
  }

  /**
   * Generates a hashcode for the CommandLineParser object.
   * @return the hashcode of the CommandLineParser object.
   */
  @Override
  public int hashCode() {
    int result = Objects.hashCode(outputLoc);
    result = 17 * result + Objects.hashCode(inputFile);
    result = 17 * result + Objects.hashCode(emailTemplate) + Objects.hashCode(letterTemplate);
    return result;
  }

  /**
   * Generates a string describing the CommandLineParser object.
   * @return a string describing the CommandLineParser object.
   */
  @Override
  public String toString() {
    return "CommandLineParser:" +
        "\noutputLoc = " + this.outputLoc +
        "\ninputFile = " + this.inputFile +
        "\nemailTemplate = " + this.emailTemplate +
        "\nletterTemplate = " + this.letterTemplate;
  }
}
