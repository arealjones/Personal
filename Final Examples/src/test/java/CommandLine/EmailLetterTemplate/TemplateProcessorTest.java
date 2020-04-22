package CommandLine.EmailLetterTemplate;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class TemplateProcessorTest {

  String validTemplate;
  String validTemplate2;
  String validOutputLocation;
  ArrayList<String> validCsvHeaders;
  ArrayList<String> validCsvLine;
  TemplateProcessor validTemplateProcessor;
  TemplateProcessor validTemplateProcessor2;
  String invalidTemplate;
  String invalidOutputLocation;
  ArrayList<String> invalidCsvHeaders;
  ArrayList<String> invalidCsvLine;
  TemplateProcessor invalidReadProcessor;
  TemplateProcessor invalidTemplateProcessor;

  @Before
  public void setUp() throws Exception {
    validTemplate = "email-template.txt";
    validTemplate2 = "email-template2.txt";
    validOutputLocation = "emails/";
    validCsvHeaders = new ArrayList<String>();
    validCsvHeaders.add("first_name");
    validCsvHeaders.add("last_name");
    validCsvHeaders.add("company_name");
    validCsvHeaders.add("address");
    validCsvHeaders.add("city");
    validCsvHeaders.add("county");
    validCsvHeaders.add("state");
    validCsvHeaders.add("zip");
    validCsvHeaders.add("phone1");
    validCsvHeaders.add("phone2");
    validCsvHeaders.add("email");
    validCsvHeaders.add("web");
    validCsvLine = new ArrayList<String>();
    validCsvLine.add("J, Chauncey");
    validCsvLine.add("P. Motley");
    validCsvLine.add("Warehouse Office & Paper Prod");
    validCsvLine.add("63 E Aurora Dr");
    validCsvLine.add("Orlando");
    validCsvLine.add("Orange");
    validCsvLine.add("FL");
    validCsvLine.add("32804");
    validCsvLine.add("407-413-4842");
    validCsvLine.add("407-557-8857");
    validCsvLine.add("chauncey_motley@aol.com");
    validCsvLine.add("http://www.warehouseofficepaperprod.com");
    validTemplateProcessor = new TemplateProcessor(validTemplate, validOutputLocation,
        validCsvHeaders, validCsvLine);
    validTemplateProcessor2 = new TemplateProcessor(validTemplate, validOutputLocation,
        validCsvHeaders, validCsvLine);

    invalidTemplate = "email-template";
    invalidOutputLocation = "emails";
    invalidCsvHeaders = new ArrayList<String>();
    invalidCsvHeaders.add("\"invalid\"");
    invalidCsvHeaders.add("\"invalid\"");
    invalidCsvLine = new ArrayList<String>();
    invalidCsvLine.add("");
    invalidCsvLine.add("echo");
    invalidReadProcessor = new TemplateProcessor(invalidTemplate, invalidOutputLocation,
        invalidCsvHeaders, invalidCsvLine);
    invalidTemplateProcessor = new TemplateProcessor(validTemplate2, validOutputLocation,
        invalidCsvHeaders, invalidCsvLine);
  }

  @Test (expected = InvalidArgumentException.class)
  public void invalidReadFile() throws InvalidArgumentException {
    invalidReadProcessor.createFiles();
  }

  @Test (expected = InvalidArgumentException.class)
  public void invalidCreateFiles() throws InvalidArgumentException {
    invalidTemplateProcessor.createFiles();
  }

  @Test
  public void createFiles() throws InvalidArgumentException {
    validTemplateProcessor.createFiles();
  }


  @Test
  public void getTemplate() {
    File validFileTemplate = new File(validTemplate);
    assertEquals(validFileTemplate, validTemplateProcessor.getTemplate());
  }

  @Test
  public void getOutputLocation() {
    assertEquals(validOutputLocation, validTemplateProcessor.getOutputLocation());
  }

  @Test
  public void getCsvHeaders() {
    assertEquals(validCsvHeaders, validTemplateProcessor.getCsvHeaders());
  }

  @Test
  public void getCsvLine() {
    assertEquals(validCsvLine, validTemplateProcessor.getCsvLine());
  }

  @Test
  public void testEquals() {
    assertEquals(validTemplateProcessor, validTemplateProcessor);
    assertNotEquals(validTemplateProcessor, validCsvHeaders);
    assertNotEquals(invalidTemplateProcessor, validTemplateProcessor);
    assertEquals(validTemplateProcessor, validTemplateProcessor2);

  }

  @Test
  public void testHashCode() {
    assertEquals(validTemplateProcessor.hashCode(), validTemplateProcessor2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(validTemplateProcessor.toString(), validTemplateProcessor2.toString());
  }
}