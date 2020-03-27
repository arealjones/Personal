package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AuthorTest {
  AbstractCreator nancy;
  AbstractCreator jane;
  AbstractCreator bob;
  AbstractCreator sameJane;
  String name;

  @Before
  public void setUp() throws Exception {
    nancy = new Author("Nancy", "Feathers");
    jane = new Author("Jane", "Doe");
    bob = new Author("Bob", "Burgers");
    sameJane = new Author("Jane", "Doe");
    name = "Wrong name.";
  }

  @Test
  public void getFirstName() {
    assertEquals("Nancy", nancy.getFirstName());
    assertEquals("Jane", jane.getFirstName());
    assertEquals("Bob", bob.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Feathers", nancy.getLastName());
    assertEquals("Doe", jane.getLastName());
    assertEquals("Burgers", bob.getLastName());
  }

  @Test
  public void testEquals() {
    assertTrue(nancy.equals(nancy));
    assertNotEquals(null, jane);
    assertFalse(bob.equals(name));
    assertTrue(jane.equals(sameJane));
    assertFalse(bob.equals(nancy));
    assertFalse(jane.equals(bob));
  }

  @Test
  public void testHashCode() {
    assertTrue(jane.hashCode() == sameJane.hashCode());
    assertFalse(jane.hashCode() == bob.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Creator: Nancy Feathers.", nancy.toString());
    assertEquals("Creator: Bob Burgers.", bob.toString());
  }
}