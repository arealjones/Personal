package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecordingArtistTest {
  AbstractCreator beyonce;
  AbstractCreator madonna;
  AbstractCreator dolly;
  AbstractCreator sameDolly;
  String name;

  @Before
  public void setUp() throws Exception {
    beyonce = new RecordingArtist("Beyonce", "Knowles");
    madonna = new RecordingArtist("Madonna", "Ciccone");
    dolly = new RecordingArtist("Dolly", "Parton");
    sameDolly = new RecordingArtist("Dolly", "Parton");
    name = "Testing if the name is the same.";
  }

  @Test
  public void getFirstName() {
    assertEquals("Beyonce", beyonce.getFirstName());
    assertEquals("Madonna", madonna.getFirstName());
    assertEquals("Dolly", dolly.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Knowles", beyonce.getLastName());
    assertEquals("Ciccone", madonna.getLastName());
    assertEquals("Parton", dolly.getLastName());
  }

  @Test
  public void testEquals() {
    assertTrue(beyonce.equals(beyonce));
    assertNotEquals(null, beyonce);
    assertFalse(madonna.equals(name));
    assertTrue(dolly.equals(sameDolly));
    assertFalse(madonna.equals(dolly));
    assertFalse(madonna.equals(beyonce));
  }

  @Test
  public void testHashCode() {
    assertTrue(dolly.hashCode() == sameDolly.hashCode());
    assertFalse(dolly.hashCode() == madonna.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Creator: Beyonce Knowles.", beyonce.toString());
    assertEquals("Creator: Dolly Parton.", dolly.toString());
  }
}