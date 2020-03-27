package problem1.Specialty;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Interior.Painting;
import problem1.PropertySize;

public class PlumbingTest {
  Plumbing bathroom;
  Plumbing kitchen;
  Plumbing laundry;

  @Before
  public void setUp() throws Exception {
    bathroom = new Plumbing(true, "768 Drain Away", 3,
        PropertySize.SMALL, true, 2);
    kitchen = new Plumbing(false, "210 Scrub City", 8,
        PropertySize.MEDIUM, false, 6);
    laundry = new Plumbing(true, "539 Fresh Scent", 9,
        PropertySize.LARGE, true, 0);
  }

  @Test
  public void fee() {
    assertEquals(20, bathroom.fee(), 0.001);
    assertNotEquals(50, kitchen.fee(), 0.001);
  }

  @Test
  public void setEmployees() {
    bathroom.setMinimumEmployees(PropertySize.SMALL, 2);
    assertEquals(2, bathroom.getEmployees());
    kitchen.setMinimumEmployees(PropertySize.MEDIUM, 6);
    assertEquals(6, kitchen.getEmployees());
    laundry.setMinimumEmployees(PropertySize.LARGE, 0);
    assertEquals(3, laundry.getEmployees());
  }

  @Test
  public void calculatePrice() {
    laundry.setMinimumEmployees(PropertySize.LARGE, 0);
    assertEquals(620, laundry.calculatePrice(), 0.001);
    kitchen.setMinimumEmployees(PropertySize.MEDIUM, 6);
    assertEquals(1220, kitchen.calculatePrice(), 0.001);
  }
}