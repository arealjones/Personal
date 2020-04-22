package CommandLine.EmailLetterTemplate;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class CSVTest {
  String csvHeaderSample = "first_name\",\"last_name\",\"company_name\",\"email";
  String first = "first_name";
  String last = "last_name";
  String company = "company_name";
  String email = "email";
  String commaInName = "Josephine\",\"R, Darakjy\",\"Canay\",\"josie55@hotmail.com";
  String jo = "Josephine";
  String dara = "R, Darakjy";
  String canay = "Canay";
  String josie = "josie55@hotmail.com";
  String perfectLine = "Art\",\"Venere\",\"Chemel, James L Cpa\",\"8 W Cerritos Ave #54\","
      + "\"Bridgeport\",\"Gloucester\",\"NJ\",\"08014\",\"856-636-8749\",\"856-264-4130\","
      + "\"art@venere.org\",\"http://www.chemeljamescpa.com";
  String art = "Art";
  String venere = "Venere";
  String chemelCompany = "Chemel, James L Cpa";
  String address = "8 W Cerritos Ave #54";
  String city = "Bridgeport";
  String country = "Gloucester";
  String state = "NJ";
  String zip = "08014";
  String phone1 = "856-636-8749";
  String phone2 = "856-264-4130";
  String artEmail = "art@venere.org";
  String web = "http://www.chemeljamescpa.com";
  CSV headerTest;
  CSV lineTest;
  CSV perfectTest;
  CSV sameHeaderTest;

  @Before
  public void setUp() throws Exception {
    headerTest = new CSV(csvHeaderSample);
    lineTest = new CSV(commaInName);
    perfectTest = new CSV(perfectLine);
    sameHeaderTest = new CSV(csvHeaderSample);
  }

  @Test
  public void getLineAsList() {
    ArrayList<String> newHeader = headerTest.getLineAsList();
    assertTrue(newHeader.contains(first));
    assertTrue(newHeader.contains(last));
    assertTrue(newHeader.contains(company));
    assertTrue(newHeader.contains(email));
    ArrayList<String> commaLine = lineTest.getLineAsList();
    assertTrue(commaLine.contains(jo));
    assertTrue(commaLine.contains(dara));
    assertTrue(commaLine.contains(canay));
    assertTrue(commaLine.contains(josie));
    assertFalse(commaLine.contains(first));
    assertFalse(commaLine.contains(email));
    ArrayList<String> longLine = perfectTest.getLineAsList();
    assertTrue(longLine.contains(art));
    assertTrue(longLine.contains(venere));
    assertTrue(longLine.contains(chemelCompany));
    assertTrue(longLine.contains(address));
    assertTrue(longLine.contains(city));
    assertTrue(longLine.contains(country));
    assertTrue(longLine.contains(state));
    assertTrue(longLine.contains(zip));
    assertTrue(longLine.contains(phone1));
    assertTrue(longLine.contains(phone2));
    assertTrue(longLine.contains(artEmail));
    assertTrue(longLine.contains(web));
    assertFalse(longLine.contains(first));
    assertFalse(longLine.contains(jo));
    assertFalse(longLine.contains(josie));
  }

  @Test
  public void testEquals() {
    assertTrue(headerTest.equals(headerTest));
    assertNotEquals(null, headerTest);
    assertFalse(headerTest.equals(lineTest));
    assertTrue(headerTest.equals(sameHeaderTest));
    assertFalse(headerTest.equals(phone1));
  }

  @Test
  public void testHashCode() {
    assertTrue(headerTest.hashCode() == sameHeaderTest.hashCode());
    assertFalse(headerTest.hashCode() == lineTest.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("[first_name, last_name, company_name, email]",
        headerTest.getLineAsList().toString());
  }
}