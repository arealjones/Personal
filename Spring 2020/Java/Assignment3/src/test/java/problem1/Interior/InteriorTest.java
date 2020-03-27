package problem1.Interior;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.PropertySize;

public class InteriorTest {
  Interior cleaningAssignment;
  Interior closet;
  Interior negativePets;
  Interior testingEqualsOne;
  Interior testingEqualsTwo;
  Interior testingEqualsThree;
  Interior negativePreviousServices;
  String address;

  @Before
  public void setUp() throws Exception {
    cleaningAssignment = new Interior(true, "123 Valley Way", 3,
        2, PropertySize.MEDIUM);
    closet = new Interior(false, "456 Crazy Ave", 0, 0,
        PropertySize.LARGE);
    testingEqualsOne = new Interior(true, "385 Interior Way", 4,
        2, PropertySize.SMALL);
    testingEqualsTwo = new Interior(true, "385 Interior Way", 4,
        2, PropertySize.SMALL);
    testingEqualsThree = new Interior(false, "385 Interior Ave", 8,
      5, PropertySize.MEDIUM);
    address = "709 Testing Street";
  }

  @Test (expected = IllegalArgumentException.class)
  public void wrongInputOfPets() throws IllegalArgumentException {
    negativePets = new Interior(true, "81 Negative Way", 4, -2,
        PropertySize.MEDIUM);
  }

  @Test (expected = IllegalArgumentException.class)
  public void setNegativePreviousServices() throws IllegalArgumentException {
    negativePreviousServices = new Interior(false, "7 Negative", -2,
        0, PropertySize.MEDIUM);
  }

  @Test
  public void getPets() {
    assertEquals(2, cleaningAssignment.getPets());
    assertEquals(0, closet.getPets());
  }

  @Test (expected = IllegalArgumentException.class)
  public void setIncorrectPets() throws IllegalArgumentException {
    cleaningAssignment.setPets(-1);
    closet.setPets(-10);
  }

  @Test
  public void setCorrectPets() throws IllegalArgumentException {
    cleaningAssignment.setPets(2);
    assertEquals(2, cleaningAssignment.getPets());
    closet.setPets(0);
    assertEquals(0, closet.getPets());
  }

  @Test
  public void rate() {
    assertEquals(80, cleaningAssignment.rate());
    assertNotEquals(40, cleaningAssignment.rate());
  }

  @Test
  public void fee() {
    assertEquals(4, cleaningAssignment.fee(), 0.0001);
    assertEquals(0, closet.fee(), 0.001);
  }

  @Test
  public void discount() {
    assertEquals(8.4, cleaningAssignment.discount(), 0.001);
    assertEquals(0, closet.discount(), 0.001);
  }

  @Test
  public void setMonthly() {
    cleaningAssignment.setMonthly(true);
    assertTrue(cleaningAssignment.isMonthly());
    closet.setMonthly(false);
    assertFalse(closet.isMonthly());
  }

  @Test
  public void getMonthly() {
    assertTrue(cleaningAssignment.isMonthly());
    assertFalse(closet.isMonthly());
  }

  @Test
  public void setAddress() {
    cleaningAssignment.setAddress("123 Valley Way");
    assertEquals("123 Valley Way", cleaningAssignment.getAddress());
    closet.setAddress("456 Crazy Ave");
    assertEquals("456 Crazy Ave", closet.getAddress());
  }

  @Test
  public void getAddress() {
    assertEquals("123 Valley Way", cleaningAssignment.getAddress());
    assertEquals("456 Crazy Ave", closet.getAddress());
  }

  @Test
  public void getPreviousServices() {
    assertEquals(3, cleaningAssignment.getPreviousServices());
    assertEquals(0, closet.getPreviousServices());
  }

  @Test
  public void testEquals() {
    assertTrue(testingEqualsOne.equals(testingEqualsOne));
    assertNotEquals(null, testingEqualsOne);
    assertFalse(testingEqualsOne.equals(address));
    assertTrue(testingEqualsOne.equals(testingEqualsTwo));
    assertFalse(testingEqualsOne.equals(testingEqualsThree));
    assertFalse(cleaningAssignment.equals(closet));
    assertFalse(closet.equals(testingEqualsOne));
  }

  @Test
  public void testHashCode() {
    assertTrue(testingEqualsOne.hashCode() == testingEqualsTwo.hashCode());
    assertFalse(testingEqualsOne.hashCode() == testingEqualsThree.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("The property at 123 Valley Way has had 3 services in the past. "
            + "Monthly Maintenance: true. It will require 2 hours to complete the project. "
            + "ADD ON: The property also has 2 pets to include for "
        + "the cost of services.", cleaningAssignment.toString());
    assertEquals("The property at 385 Interior Way has had 4 services in the past. "
        + "Monthly Maintenance: true. It will require 1 hours to complete the project. "
        + "ADD ON: The property also has 2 pets to include for the "
        + "cost of services.", testingEqualsOne.toString());
  }
}