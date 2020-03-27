package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import javax.swing.plaf.nimbus.AbstractRegionPainter;
import jdk.vm.ci.meta.Local;
import org.junit.Before;
import org.junit.Test;

public class MonthlyTest {
  AbstractDonations oneHundredDollars;
  AbstractDonations oneThousandDollars;
  AbstractDonations fiveHundred;
  AbstractDonations donationBeforeCreation;
  AbstractDonations futureCreation;
  AbstractDonations sameHundred;
  int wrong;

  @Before
  public void setUp() throws Exception {
    oneHundredDollars = new Monthly(100,
        LocalDate.of(2020, 2, 18));
    oneThousandDollars = new Monthly(1000,
        LocalDate.of(2020, 2, 8),
        LocalDate.of(2020, 3, 17));
    fiveHundred = new Monthly(500,
        LocalDate.of(2020, 8, 11));
    futureCreation = new Monthly(20, LocalDate.of(2020, 3, 1),
        LocalDate.of(2020, 7, 11));
    sameHundred = new Monthly(100,
        LocalDate.of(2020, 2, 18));
    wrong = -1;
  }

  @Test (expected = IllegalArgumentException.class)
  public void setup2() throws IllegalArgumentException {
    donationBeforeCreation = new Monthly(12,
        LocalDate.of(2020, 2, 8),
        LocalDate.of(2020, 1, 4));
  }

  @Test
  public void getDonationDate() {
    assertEquals(LocalDate.of(2020, 2, 18),
        oneHundredDollars.getDonationDate());
    assertEquals(LocalDate.of(2020, 3, 17),
        oneThousandDollars.getDonationDate());
  }

  @Test
  public void checkInPast() {
    assertTrue(oneThousandDollars.checkInPast(LocalDate.of(2020, 1, 2)));
    assertFalse(oneThousandDollars.checkInPast(LocalDate.of(2020, 2, 10)));
    assertTrue(futureCreation.checkInPast(LocalDate.of(2020, 2, 26)));
    assertTrue(futureCreation.checkInPast(LocalDate.of(2020, 2, 4)));
    assertFalse(futureCreation.checkInPast(LocalDate.of(2020, 8, 29)));
  }

  @Test
  public void getCancellation() {
    assertEquals(null, oneHundredDollars.getCancellationDate());
    assertEquals(null, fiveHundred.getCancellationDate());
  }

  @Test
  public void setCancellation() {
    fiveHundred.setCancellationDate(LocalDate.of(2020, 9, 29));
    assertEquals(LocalDate.of(2020, 9, 29),
        fiveHundred.getCancellationDate());
    oneThousandDollars.setCancellationDate(LocalDate.of(2020, 5, 15));
    assertEquals(LocalDate.of(2020, 5, 15),
        oneThousandDollars.getCancellationDate());
  }

  @Test (expected = IllegalArgumentException.class)
  public void setIncorrectCancellation() {
    oneThousandDollars.setCancellationDate(LocalDate.of(2020, 2, 3));
    oneThousandDollars.setCancellationDate(LocalDate.of(2020, 2, 8));
  }

  @Test
  public void testEquals() {
    assertTrue(oneHundredDollars.equals(oneHundredDollars));
    assertNotEquals(null, oneHundredDollars);
    assertFalse(oneHundredDollars.equals(wrong));
    assertTrue(oneHundredDollars.equals(sameHundred));
    assertFalse(oneHundredDollars.equals(oneThousandDollars));
    assertFalse(oneThousandDollars.equals(fiveHundred));
  }

  @Test
  public void testHashCode() {
    assertTrue(oneHundredDollars.hashCode() == sameHundred.hashCode());
    assertFalse(oneHundredDollars.hashCode() == oneThousandDollars.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Donation Amount: $100.0. Creation Date: 2020-02-18, "
        + "Donation Date: 2020-02-18, and Cancellation Date: NA.", oneHundredDollars.toString());
    oneThousandDollars.setCancellationDate(LocalDate.of(2021, 5, 11));
    assertEquals("Donation Amount: $1000.0. Creation Date: 2020-02-10, "
        + "Donation Date: 2020-03-17, and Cancellation Date: 2021-05-11.",
        oneThousandDollars.toString());
  }
}