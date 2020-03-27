package problem1.Interior;

import static org.junit.Assert.*;

import java.util.Calendar;
import problem1.PropertySize;
import org.junit.Before;
import org.junit.Test;

public class CleaningTest {
  Cleaning mansion;
  Cleaning victorian;
  Cleaning beachHouse;
  Cleaning previousService;
  Cleaning noDiscount1;
  Cleaning noDiscount2;
  Cleaning testCalculations;
  Cleaning testCalculations2;
  Cleaning testCalculations3;

  @Before
  public void setUp() throws Exception {
    mansion = new Cleaning(true, "123 Valley Way", 3, 2,
        PropertySize.LARGE);
    victorian = new Cleaning(true, "945 Fancy Ave", 19, 6,
        PropertySize.MEDIUM);
    beachHouse = new Cleaning(true, "762 Ocean City", 14, 1,
        PropertySize.SMALL);
    previousService = new Cleaning(false, "456 Crazy Towm", 59,
        0, PropertySize.SMALL);
    noDiscount1 = new Cleaning(false, "23 No Discount", 15, 0,
        PropertySize.LARGE);
    noDiscount2 = new Cleaning(false, "79 Loss Discount", 0, 3,
        PropertySize.MEDIUM);
    testCalculations = new Cleaning(false, "34 test", 9, 2,
        PropertySize.LARGE);
    testCalculations2 = new Cleaning(true, "56 test", 4, 5,
        PropertySize.SMALL);
    testCalculations3 = new Cleaning(true, "11 testing", 11, 0,
        PropertySize.MEDIUM);
  }

  @Test
  public void setHours() {
    mansion.setHours(PropertySize.LARGE);
    assertEquals(4, mansion.getHours());
    victorian.setHours(PropertySize.MEDIUM);
    assertEquals(2, victorian.getHours());
    beachHouse.setHours(PropertySize.SMALL);
    assertEquals(1, beachHouse.getHours());
  }

  @Test
  public void calculateMonthlyPrice() {
    mansion.setHours(PropertySize.LARGE);
    assertEquals(302.4, mansion.calculatePrice(), 0.001);
    beachHouse.setHours(PropertySize.SMALL);
    assertEquals(75.6, beachHouse.calculatePrice(), 0.001);
    testCalculations2.setHours(PropertySize.SMALL);
    assertEquals(77.04, testCalculations2.calculatePrice(), 0.001);
    testCalculations3.setHours(PropertySize.MEDIUM);
    assertEquals(144, testCalculations3.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePricePreviousServicePrice() {
    victorian.setHours(PropertySize.MEDIUM);
    assertEquals(85.6, victorian.calculatePrice(), 0.001);
    previousService.setHours(PropertySize.SMALL);
    assertEquals(40, previousService.calculatePrice(), 0.001);
    testCalculations.setHours(PropertySize.LARGE);
    assertEquals(168, testCalculations.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePriceNoDiscount() {
    noDiscount1.setHours(PropertySize.LARGE);
    assertEquals(320, noDiscount1.calculatePrice(), 0.001);
    noDiscount2.setHours(PropertySize.MEDIUM);
    assertEquals(171.2, noDiscount2.calculatePrice(), 0.001);
  }
}