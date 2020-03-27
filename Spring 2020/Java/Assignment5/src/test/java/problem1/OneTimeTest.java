package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class OneTimeTest {
  AbstractDonations tenDollars;
  AbstractDonations twentyDollars;
  AbstractDonations negative;
  AbstractDonations sameTen;
  int num;

  @Before
  public void setUp() throws Exception {
    tenDollars = new OneTime(10);
    twentyDollars = new OneTime(20);
    sameTen = new OneTime(10);
    num = 0;
  }

  @Test (expected = IllegalArgumentException.class)
  public void setUp2() throws IllegalArgumentException {
    negative = new OneTime(-1);
  }

  @Test
  public void getAmount() {
    assertEquals(10, tenDollars.getAmount(), 0.001);
    assertEquals(20, twentyDollars.getAmount(), 0.001);
  }

  @Test
  public void getCreationDate() {
    assertEquals(LocalDate.of(2020, 2, 10), tenDollars.getCreationDate());
    assertEquals(LocalDate.of(2020, 2, 10), twentyDollars.getCreationDate());
  }

  @Test
  public void testEquals() {
    assertTrue(twentyDollars.equals(twentyDollars));
    assertNotEquals(null, twentyDollars);
    assertFalse(tenDollars.equals(num));
    assertTrue(tenDollars.equals(sameTen));
    assertFalse(tenDollars.equals(twentyDollars));
  }

  @Test
  public void testHashCode() {
    assertTrue(tenDollars.hashCode() == sameTen.hashCode());
    assertFalse(tenDollars.hashCode() == twentyDollars.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Donation Amount: $20.0. Creation Date: 2020-02-10.",
        twentyDollars.toString());
    assertEquals("Donation Amount: $10.0. Creation Date: 2020-02-10.",
        tenDollars.toString());
  }

}