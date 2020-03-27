package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
  AbstractCreator michelle;
  AbstractItems becoming;
  AbstractCreator stephen;
  AbstractItems institute;
  AbstractCreator negativeCreator;
  AbstractItems negativeYear;
  AbstractItems sameBecoming;
  String name;

  @Before
  public void setUp() throws Exception {
    michelle = new Author("Michelle", "Obama");
    stephen = new Author("Stephen", "King");
    negativeCreator = new Author("Negative", "Creator");
    becoming = new Book(michelle, "Becoming", 2018);
    institute = new Book(stephen, "Institute", 2019);
    sameBecoming = new Book(michelle, "Becoming", 2018);
    name = "Wrong";
  }

  @Test (expected = IllegalArgumentException.class)
  public void setWrongYear() {
    negativeYear = new Book(negativeCreator, "Negative Year", -110);
  }

  @Test
  public void getCreator() {
    assertEquals("Michelle", becoming.getCreator().getFirstName());
    assertEquals("Obama", becoming.getCreator().getLastName());
    assertEquals("Stephen", institute.getCreator().getFirstName());
    assertEquals("King", institute.getCreator().getLastName());
  }

  @Test
  public void getTitle() {
    assertEquals("Institute", institute.getTitle());
    assertEquals("Becoming", becoming.getTitle());
  }

  @Test
  public void getReleaseOrPublishedYear() {
    assertEquals(2018, becoming.getReleaseOrPublishedYear());
    assertEquals(2019, institute.getReleaseOrPublishedYear());
  }

  @Test
  public void testEquals() {
    assertTrue(becoming.equals(becoming));
    assertNotEquals(null, becoming);
    assertFalse(institute.equals(name));
    assertTrue(becoming.equals(sameBecoming));
    assertFalse(institute.equals(becoming));
  }

  @Test
  public void testHashCode() {
    assertTrue(becoming.hashCode() == sameBecoming.hashCode());
    assertFalse(becoming.hashCode() == institute.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Items: Creator: Michelle Obama. Title: Becoming, "
        + "and Release or Published Year: 2018.", becoming.toString());
    assertEquals("Items: Creator: Stephen King. Title: Institute, "
        + "and Release or Published Year: 2019.", institute.toString());
  }
}