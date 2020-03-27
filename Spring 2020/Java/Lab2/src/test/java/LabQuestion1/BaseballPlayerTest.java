package LabQuestion1;

import static org.junit.Assert.*;

import LabQuestion1.BaseballPlayer;
import LabQuestion1.Name;
import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerTest {
  BaseballPlayer jon;

  @Before
  public void setUp() throws Exception {
    jon = new BaseballPlayer(new Name("Jon", "White", "Snow"),
        6.01, 180.00, "Crazy", "Boyz", 8.53, 4);
  }

  @Test
  public void getTeam() { assertEquals("Boyz", jon.getTeam());
  }

  @Test
  public void getAverageBat() { assertEquals(8.53, jon.getAverageBat(), 0.001);
  }

  @Test
  public void getHomeRuns() { assertEquals(4, jon.getHomeRuns(), 0.001);
  }

  @Test
  public void testEquals() {
  }

  @Test
  public void testHashCode() {
  }

  @Test
  public void testToString() {
  }
}