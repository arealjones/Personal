package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class NonProfitTest {
  AbstractDonations one;
  AbstractDonations two;
  AbstractDonations three;
  AbstractDonations twoDollars;
  AbstractDonations tenDollars;
  AbstractDonations oneDollar;
  AbstractDonations fifty;
  AbstractDonations seventy;
  List<AbstractDonations> filledList;
  NonProfit redCross;
  NonProfit safety;
  NonProfit shelters;
  NonProfit sameSafety;
  int num;

  @Before
  public void setUp() throws Exception {
    one = new OneTime(1);
    two = new OneTime(2);
    three = new OneTime(3);
    twoDollars = new Monthly(2, LocalDate.of(2020, 3, 10));
    tenDollars = new Monthly(10, LocalDate.of(2020, 2, 9),
        LocalDate.of(2020, 4, 20));
    tenDollars.setCancellationDate(LocalDate.of(2020, 11, 19));
    oneDollar = new Pledges(1);
    fifty = new Pledges(50, LocalDate.of(2020, 12, 1));
    seventy = new Pledges(70, LocalDate.of(2020, 2, 9),
        LocalDate.of(2021, 6, 27));
    filledList = new ArrayList<>();
    filledList.add(one);
    filledList.add(seventy);
    filledList.add(tenDollars);
    filledList.add(three);
    filledList.add(twoDollars);
    filledList.add(fifty);
    filledList.add(oneDollar);
    filledList.add(two);
    redCross = new NonProfit("Red Cross");
    safety = new NonProfit("Safety", filledList);
    shelters = new NonProfit("Shelters");
    sameSafety = new NonProfit("Safety", filledList);
    num = -1;
  }

  @Test
  public void getOrgName() {
    assertEquals("Red Cross", redCross.getOrgName());
    assertEquals("Shelters", shelters.getOrgName());
  }

  @Test
  public void addDonation() {
    redCross.addDonation(one);
    safety.addDonation(two);
    assertTrue(safety.getDonations().contains(fifty));
    assertTrue(redCross.getDonations().contains(one));
  }

  @Test
  public void getTotalDonationsForYear() {
    assertEquals(0, redCross.getTotalDonationsForYear(2020));
    assertEquals(146, safety.getTotalDonationsForYear(2020));
  }

  @Test
  public void testEquals() {
    assertTrue(safety.equals(safety));
    assertNotEquals(null, safety);
    assertFalse(redCross.equals(num));
    assertTrue(safety.equals(sameSafety));
    assertFalse(safety.equals(redCross));
    assertFalse(redCross.equals(shelters));
  }

  @Test
  public void testHashCode() {
    assertTrue(safety.hashCode() == sameSafety.hashCode());
    assertFalse(safety.hashCode() == shelters.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("NonProfit Organization: Safety. "
        + "Total donations made in a given year: $146.", safety.toString(2020));
    assertEquals("NonProfit Organization: Shelters. "
        + "Total donations made in a given year: $0.", shelters.toString(2020));
  }
}