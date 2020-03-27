package LabQuestion1;

import static org.junit.Assert.*;

import LabQuestion1.Name;
import LabQuestion1.Runner;
import org.junit.Before;
import org.junit.Test;

public class RunnerTest {
  Runner jane;

  @Before
  public void setUp() throws Exception {
    jane = new Runner(new Name("Jane", "Jackie", "Doe"),
        4.65, 130.5, "Fun", 10.30,
        30.15, "Swimming");
  }

  @Test
  public void getBest5K() { assertEquals(10.30, jane.getBest5K(), 0.001);
  }

  @Test
  public void getBestHalf() { assertEquals(30.15, jane.getBestHalf(), 0.001);
  }

  @Test
  public void getFavoriteEvent() { assertEquals("Swimming", jane.getFavoriteEvent());
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