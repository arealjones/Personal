package problem1.Exterior;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.FloorsException;
import problem1.PropertySize;

public class WindowCleaningTest {
  WindowCleaning front;
  WindowCleaning previousService;
  WindowCleaning monthlyService;
  WindowCleaning noDiscount1;
  WindowCleaning noDiscount2;
  WindowCleaning zeroFloors;
  WindowCleaning tooManyFloors;
  WindowCleaning negativeFloors;
  WindowCleaning testingEquals;
  WindowCleaning testCalculations;
  String address;

  @Before
  public void setUp() throws Exception {
    front = new WindowCleaning(true, "654 Valley Road", 9,
        PropertySize.LARGE, 2);
    previousService = new WindowCleaning(false, "755 Hello Ave",
        79, PropertySize.SMALL, 2);
    monthlyService = new WindowCleaning(true, "111 Gravy Flood", 0,
        PropertySize.MEDIUM, 1);
    noDiscount1 = new WindowCleaning(false, "234 Water Way", 44,
        PropertySize.SMALL, 3);
    noDiscount2 = new WindowCleaning(false, "898 Sunny Side", 0,
        PropertySize.LARGE, 2);
    testingEquals = new WindowCleaning(true, "654 Valley Road", 9,
        PropertySize.LARGE, 2);
    testCalculations = new WindowCleaning(true, "56 Test", 2,
        PropertySize.LARGE, 3);
    address = "11 Incorrect";
  }

  @Test (expected = FloorsException.class)
  public void wrongAmountOfFloors() throws FloorsException {
    zeroFloors = new WindowCleaning(false, "44 Zero Floors", 3,
        PropertySize.MEDIUM, 0);
    tooManyFloors = new WindowCleaning(true, "5 Too Many", 7,
        PropertySize.SMALL, 4);
    negativeFloors = new WindowCleaning(true, "67 Negative Way", 9,
        PropertySize.LARGE, -1);
  }

  @Test
  public void setFloors() throws FloorsException {
    front.setFloors(2);
    assertEquals(2, front.getFloors());
    noDiscount1.setFloors(3);
    assertEquals(3, noDiscount1.getFloors());
  }

  @Test (expected = FloorsException.class)
  public void setIncorrectFloors() throws FloorsException {
    front.setFloors(4);
    monthlyService.setFloors(-1);
    previousService.setFloors(0);
  }

  @Test
  public void getFloors() {
    assertEquals(2, front.getFloors());
    assertEquals(3, noDiscount1.getFloors());
  }

  @Test
  public void fee() {
    assertEquals(0, monthlyService.fee(), 0.001);
    assertEquals(4, previousService.fee(), 0.001);
  }

  @Test
  public void calculatePrice() {
    front.setHours(PropertySize.LARGE);
    assertEquals(168, front.calculatePrice(), 0.001);
    monthlyService.setHours(PropertySize.MEDIUM);
    assertEquals(144, monthlyService.calculatePrice(), 0.001);
    noDiscount1.setHours(PropertySize.SMALL);
    assertEquals(84, noDiscount1.calculatePrice(), 0.001);
    previousService.setHours(PropertySize.SMALL);
    assertEquals(42, previousService.calculatePrice(), 0.001);
    noDiscount2.setHours(PropertySize.LARGE);
    assertEquals(336, noDiscount2.calculatePrice(), 0.001);
    testCalculations.setHours(PropertySize.LARGE);
    assertEquals(302.4, testCalculations.calculatePrice(), 0.001);
  }

  @Test
  public void testEquals() {
    assertTrue(front.equals(front));
    assertNotEquals(null, front);
    assertFalse(front.equals(address));
    assertTrue(front.equals(testingEquals));
    assertFalse(front.equals(previousService));
  }

  @Test
  public void testHashCode() {
    assertTrue(front.hashCode() == testingEquals.hashCode());
    assertFalse(front.hashCode() == previousService.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("The property at 654 Valley Road has had 9 services in the past."
        + " Monthly Maintenance: true. It will require 4 hours to complete the project. "
        + "ADD ON: This property also has 2 floors to include "
        + "for the cost of services. ", front.toString());
    assertEquals("The property at 234 Water Way has had 44 services in the past."
        + " Monthly Maintenance: false. It will require 1 hours to complete the project. "
        + "ADD ON: This property also has 3 floors to include "
        + "for the cost of services. ", noDiscount1.toString());
  }
}