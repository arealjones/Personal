package assignment8;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CommandLineParserTest {
    CommandLineParser validEmailRequest;
    CommandLineParser sameValidEmailRequest;
    CommandLineParser validLetterRequest;
    CommandLineParser validBothRequest;
    String[] emailCommand;
    String[] letterCommand;
    String[] bothCommand;
    String[] missingLetterCommand;
    String[] missingFileLocation;
    String[] onlyOneCommand;
    String[] missingCSVFileCommand;
    String[] missingEmailLocation;
    String[] missingOutputFileDirectory;
    String[] missingInputFileLocation;
    String emailLocation;
    String letterLocation;
    String outputLocation;
    String inputLocation;

    @Before
    public void setUp() throws Exception {
        emailLocation = "email_template.txt";
        letterLocation = "letter-template.txt";
        outputLocation = "emails/";
        inputLocation = "customer.csv";
        emailCommand = new String[]{"--email",  "--email-template", "email_template.txt",
                "--output-dir", "emails/", "--csv-file", "customer.csv"};
        letterCommand = new String[]{"--letter", "--letter-template", "letter-template.txt",
                "--output-dir", "letters/", "--csv-file", "customer.csv"};
        bothCommand = new String[]{"--email", "--email-template", "email-template.txt", "--letter",
                "--letter-template", "letter-template.txt", "--output-dir", "emails/",
                "--csv-file", "customer.csv"};
        missingLetterCommand = new String[]{"--email-template", "email-template.txt",
                "--output-dir", "emails/", "--csv-file", "customer.csv"};
        missingFileLocation = new String[]{"--letter", "--output-dir", "letters/", "--csv-file",
                "customer.csv"};
        missingCSVFileCommand = new String[]{"--email",  "--email-template", "email_template.txt",
                "--output-dir", "emails/", "customer.csv"};
        missingEmailLocation = new String[]{"--email",  "--email-template", "--output-dir",
                "emails/", "--csv-file", "customer.csv"};
        missingOutputFileDirectory = new String[]{"--letter", "--letter-template",
                "letter-template.txt", "--output-dir", "--csv-file", "customer.csv"};
        missingInputFileLocation = new String[]{"--email", "--email-template", "email-template.txt",
                "--letter", "--letter-template", "letter-template.txt", "--output-dir", "emails/",
                "--csv-file"};
        onlyOneCommand = new String[]{"--test"};
        validEmailRequest = new CommandLineParser(emailCommand);
        validLetterRequest = new CommandLineParser(letterCommand);
        validBothRequest = new CommandLineParser(bothCommand);
        sameValidEmailRequest = new CommandLineParser(emailCommand);
    }


    @Test (expected = InvalidArgumentException.class)
    public void testInvalidNumberArguments() throws InvalidArgumentException {
        CommandLineParser invalidOne = new CommandLineParser(onlyOneCommand);
    }

    @Test (expected = InvalidArgumentException.class)
    public void testMissingFileLocation() throws InvalidArgumentException {
        CommandLineParser invalidTwo = new CommandLineParser(missingFileLocation);
    }

    @Test (expected = InvalidArgumentException.class)
    public void testMissingLetterArgument() throws InvalidArgumentException {
        CommandLineParser invalidThree = new CommandLineParser(missingLetterCommand);
    }

    @Test (expected = InvalidArgumentException.class)
    public void testMissingCSVArgument() throws InvalidArgumentException {
        CommandLineParser invalidFour = new CommandLineParser(missingCSVFileCommand);
    }

    @Test (expected = InvalidArgumentException.class)
    public void testMissingEmailLocation() throws InvalidArgumentException {
        CommandLineParser invalidFive = new CommandLineParser(missingEmailLocation);
    }

    @Test (expected = InvalidArgumentException.class)
    public void testMissingOutputDirectory() throws InvalidArgumentException {
        CommandLineParser invalidSix = new CommandLineParser(missingOutputFileDirectory);
    }

    @Test (expected = InvalidArgumentException.class)
    public void testMissingInputLocation() throws InvalidArgumentException {
        CommandLineParser invalidSeven = new CommandLineParser(missingInputFileLocation);
    }

    @Test
    public void getOutputFileLocation() {
        assertEquals(outputLocation, validEmailRequest.getOutputFileLocation());
    }

    @Test
    public void getInputFile() {
        assertEquals(inputLocation, validEmailRequest.getInputFile());
    }

    @Test
    public void getEmailTemplateLocation() {
        assertEquals(emailLocation, validEmailRequest.getEmailTemplateLocation());
    }

    @Test
    public void getLetterTemplateLocation() {
        assertEquals(letterLocation, validBothRequest.getLetterTemplateLocation());
    }

    @Test
    public void testEquals() {
        assertTrue(validEmailRequest.equals(validEmailRequest));
        assertNotEquals(null, validEmailRequest);
        assertFalse(validEmailRequest.equals(validBothRequest));
        assertTrue(validEmailRequest.equals(sameValidEmailRequest));
        assertFalse(validEmailRequest.equals(emailLocation));
    }

    @Test
    public void testHashCode() {
        assertTrue(validEmailRequest.hashCode() == sameValidEmailRequest.hashCode());
        assertFalse(validEmailRequest.hashCode() == validBothRequest.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("CommandLineParser:\n"
            + "outputLoc = emails/\n"
            + "inputFile = customer.csv\n"
            + "emailTemplate = email_template.txt\n"
            + "letterTemplate = null", validEmailRequest.toString());
    }
}