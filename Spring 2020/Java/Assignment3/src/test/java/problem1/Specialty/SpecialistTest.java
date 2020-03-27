package problem1.Specialty;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Exterior.Exterior;
import problem1.PropertySize;

public class SpecialistTest {
  Specialist electrical;
  Specialist plumbing;
  Specialist testingEqualsOne;
  Specialist testingEqualsTwo;
  Specialist testingEqualsThree;
  Specialist negativePrevious;
  String address;

  @Before
  public void setUp() throws Exception {
    electrical = new Specialist(true, "555 River Road", 9,
        PropertySize.LARGE, true, 3);
    plumbing = new Specialist(false, "343 Foo Fun", 14,
        PropertySize.MEDIUM, false, 0);
    testingEqualsOne = new Specialist(true, "385 Interior Way", 4,
        PropertySize.SMALL, true, 1);
    testingEqualsTwo = new Specialist(true, "385 Interior Way", 4,
        PropertySize.SMALL, true, 2);
    testingEqualsThree = new Specialist(false, "385 Interior Ave", 8,
        PropertySize.MEDIUM, false, 5);
    address = "113 Testing Street";
  }

  @Test (expected = IllegalArgumentException.class)
  public void setNegativePrevious() throws IllegalArgumentException {
    negativePrevious = new Specialist(true, "34 Negative", -2,
        PropertySize.SMALL, true, 3);
  }

  @Test
  public void setMinimumEmployees() {
    electrical.setMinimumEmployees(PropertySize.LARGE, 3);
    assertEquals(3, electrical.getEmployees());
    plumbing.setMinimumEmployees(PropertySize.MEDIUM, 0);
    assertEquals(1, plumbing.getEmployees());
    testingEqualsOne.setMinimumEmployees(PropertySize.SMALL, 1);
    assertEquals(2, testingEqualsOne.getEmployees());
    testingEqualsTwo.setMinimumEmployees(PropertySize.SMALL, 2);
    assertEquals(2, testingEqualsTwo.getEmployees());
    testingEqualsThree.setMinimumEmployees(PropertySize.MEDIUM, 5);
    assertEquals(5, testingEqualsThree.getEmployees());
  }

  @Test
  public void rate() {
    assertEquals(200, electrical.rate());
    assertNotEquals(150, plumbing.rate());
  }

  @Test
  public void setAddress() {
    electrical.setAddress("555 River Road");
    assertEquals("555 River Road", electrical.getAddress());
    plumbing.setAddress("343 Foo Fun");
    assertEquals("343 Foo Fun", plumbing.getAddress());
  }

  @Test
  public void getAddress() {
    assertEquals("555 River Road", electrical.getAddress());
    assertEquals("343 Foo Fun", plumbing.getAddress());
  }

  @Test
  public void setMonthly() {
    electrical.setMonthly(true);
    assertTrue(electrical.isMonthly());
    plumbing.setMonthly(false);
    assertFalse(plumbing.isMonthly());
  }

  @Test
  public void getMonthly() {
    assertTrue(electrical.isMonthly());
    assertFalse(plumbing.isMonthly());
  }

  @Test
  public void setComplex() {
    electrical.setComplex(true);
    plumbing.setComplex(false);
  }

  @Test
  public void isComplex() {
    assertTrue(electrical.isComplex());
    assertFalse(plumbing.isComplex());
  }

  @Test
  public void getPreviousServices() {
    assertEquals(9, electrical.getPreviousServices());
    assertEquals(14, plumbing.getPreviousServices());
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
    assertEquals("The property at 555 River Road has had 9 services in the past. "
        + "Monthly Maintenance: true. Complex Project: true. "
        + "Number of employees required: 3.", electrical.toString());
    assertEquals("The property at 343 Foo Fun has had 14 services in the past. "
        + "Monthly Maintenance: false. Complex Project: false. "
        + "Number of employees required: 1.", plumbing.toString());
  }
}