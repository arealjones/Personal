package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class PledgesTest {
  AbstractDonations thirtyDollars;
  AbstractDonations fiveDollars;
  AbstractDonations oneDollar;
  AbstractDonations oldCreation;
  AbstractDonations samethirty;
  int num;

  @Before
  public void setUp() throws Exception {
    thirtyDollars = new Pledges(30);
    fiveDollars = new Pledges(5, LocalDate.of(2020, 2, 20));
    oneDollar = new Pledges(1, LocalDate.of(2020, 3, 1),
        LocalDate.of(2020, 5, 3));
    oldCreation = new Pledges(3, LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 9, 12));
    samethirty = new Pledges(30);
    num = -1;
  }

  @Test
  public void getCreationDate() {
    assertEquals(LocalDate.of(2020, 2, 10),
        thirtyDollars.getCreationDate());
    assertEquals(LocalDate.of(2020, 2, 10), fiveDollars.getCreationDate());
    assertEquals(LocalDate.of(2020, 3, 1), oneDollar.getCreationDate());
  }

//  @Test
//  public void checkInPast() {
//    assertTrue(fiveDollars.checkInPast(LocalDate.of(2020, 2, 8)));
//    assertTrue(oneDollar.checkInPast(LocalDate.of(2020, 2, 9)));
//    assertTrue(oldCreation.checkInPast(LocalDate.of(2020, 1, 17)));
//  }

  @Test
  public void changeDonationDate() {
    thirtyDollars.changeDonationDate(LocalDate.of(2020, 4, 11));
    assertEquals(LocalDate.of(2020, 4, 11),
        thirtyDollars.getDonationDate());
    fiveDollars.changeDonationDate(LocalDate.of(2020, 2, 11));
    assertEquals(LocalDate.of(2020, 2, 11), fiveDollars.getDonationDate());
  }

  @Test (expected = IllegalArgumentException.class)
  public void oldDonationDate() {
    oneDollar.changeDonationDate(LocalDate.of(2020, 1, 11));
  }

  @Test
  public void testEquals() {
    assertTrue(thirtyDollars.equals(thirtyDollars));
    assertNotEquals(null, thirtyDollars);
    assertFalse(thirtyDollars.equals(num));
    assertTrue(thirtyDollars.equals(samethirty));
    assertFalse(thirtyDollars.equals(oneDollar));
    assertFalse(thirtyDollars.equals(fiveDollars));
  }

  @Test
  public void testHashCode() {
    assertTrue(thirtyDollars.hashCode() == samethirty.hashCode());
    assertFalse(thirtyDollars.hashCode() == oneDollar.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Donation Amount: $30.0. Creation Date: 2020-02-10, "
        + "and Donation Date: NA.", thirtyDollars.toString());
    assertEquals("Donation Amount: $5.0. Creation Date: 2020-02-10, "
            + "and Donation Date: 2020-02-20.", fiveDollars.toString());
  }
}