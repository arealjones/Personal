package problem1.Exterior;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Interior.Interior;
import problem1.PropertySize;

public class ExteriorTest {
  Exterior gardeningAssignment;
  Exterior frontWindows;
  Exterior windowTime;
  Exterior testingEqualsOne;
  Exterior testingEqualsTwo;
  Exterior testingEqualsThree;
  String address;
  Exterior negativePreviousServices;

  @Before
  public void setUp() throws Exception {
    gardeningAssignment = new Exterior(true, "454 Flower World", 4,
        PropertySize.SMALL);
    frontWindows = new Exterior(false, "989 Wrong Ave", 9,
        PropertySize.MEDIUM);
    windowTime = new Exterior(false, "43 Clean Blvd", 0,
        PropertySize.LARGE);
    testingEqualsOne = new Exterior(true, "385 Interior Way", 4,
        PropertySize.MEDIUM);
    testingEqualsTwo = new Exterior(true, "385 Interior Way", 4,
        PropertySize.MEDIUM);
    testingEqualsThree = new Exterior(false, "385 Interior Ave", 8,
        PropertySize.LARGE);
    address = "113 Testing Street";
  }

  @Test (expected = IllegalArgumentException.class)
  public void setIncorrectPreviousServices() throws IllegalArgumentException {
   negativePreviousServices = new Exterior(false, "34 Incorrect Ave",
       -2, PropertySize.LARGE);
  }

  @Test
  public void setHours() {
    assertEquals(1, gardeningAssignment.setHours(PropertySize.SMALL));
    assertEquals(2, frontWindows.setHours(PropertySize.MEDIUM));
    assertEquals(4, windowTime.setHours(PropertySize.LARGE));
  }

  @Test
  public void rate() {
    assertEquals(80, gardeningAssignment.rate());
    assertNotEquals(56, frontWindows.rate());
  }

  @Test
  public void discount() {
    assertEquals(.50, frontWindows.discount(), 0.001);
    assertEquals(.10, gardeningAssignment.discount(), 0.001);
    assertEquals(0, windowTime.discount(), 0.001);
  }

  @Test
  public void setMonthly() {
    gardeningAssignment.setMonthly(true);
    assertEquals(true, gardeningAssignment.isMonthly());
    frontWindows.setMonthly(false);
    assertEquals(false, frontWindows.isMonthly());
  }

  @Test
  public void setAddress() {
    gardeningAssignment.setAddress("454 Flower World");
    assertEquals("454 Flower World", gardeningAssignment.getAddress());
    frontWindows.setAddress("989 Wrong Ave");
    assertEquals("989 Wrong Ave", frontWindows.getAddress());
  }

  @Test
  public void getAddress() {
    assertEquals("989 Wrong Ave", frontWindows.getAddress());
    assertEquals("454 Flower World", gardeningAssignment.getAddress());
  }

  @Test
  public void getPreviousServices() {
    assertEquals(4, gardeningAssignment.getPreviousServices());
    assertEquals(9, frontWindows.getPreviousServices());
  }

  @Test
  public void testEquals() {
    assertTrue(testingEqualsOne.equals(testingEqualsOne));
    assertNotEquals(null, testingEqualsOne);
    assertFalse(testingEqualsOne.equals(address));
    assertTrue(testingEqualsOne.equals(testingEqualsTwo));
    assertFalse(testingEqualsOne.equals(testingEqualsThree));
  }

  @Test
  public void testHashCode() {
    assertTrue(testingEqualsOne.hashCode() == testingEqualsTwo.hashCode());
    assertFalse(testingEqualsOne.hashCode() == testingEqualsThree.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("The property at 454 Flower World has had 4 services in the past."
        + " Monthly Maintenance: true. It will require 1 hours to complete "
        + "the project.", gardeningAssignment.toString());
    assertEquals("The property at 43 Clean Blvd has had 0 services in the past."
        + " Monthly Maintenance: false. It will require 4 hours to complete "
        + "the project.", windowTime.toString());
  }
}