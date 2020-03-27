package LabQuestion1;
// I was getting major errors for some reason. I had Brian looked at it for me.
import static org.junit.Assert.*;

import LabQuestion1.Athlete;
import LabQuestion1.Name;
import org.junit.Before;
import org.junit.Test;

public class AthleteTest {
  Name name;
  Athlete bob;

  @Before
  public void setUp() throws Exception {
    name = new Name("Bob", "Mc", "Double");
    bob = new Athlete(name, 6.01, 180.00, "Burgers");
  }

  @Test
  public void getAthletesName() { assertTrue(name.equals(bob.getAthletesName()));
  }

  @Test
  public void getHeight() { assertEquals(6.01, bob.getHeight(), 0.001);
  }

  @Test
  public void getWeight() { assertEquals(180.00, bob.getWeight(), 0.001);
  }

  @Test
  public void getLeague() { assertEquals("Burgers", bob.getLeague());
  }

  @Test
  public void testEquals() {
  }

  @Test
  public void testHashCode() {
    //assertEquals(bob.hashCode(), bob.hashCode());
    //System.out.println(bob.hashCode());
  }

  @Test
  public void testToString() {
  }
}