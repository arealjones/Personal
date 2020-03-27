package problem1.Interior;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.PropertySize;

public class PaintingTest {
  Painting cottage;
  Painting grocery;
  Painting shed;
  Painting monthlyAndPrevious;
  Painting paris;
  Painting noDiscount1;
  Painting noDiscount2;

  @Before
  public void setUp() throws Exception {
    cottage = new Painting(false, "555 Holy Street", 9, 4,
        PropertySize.MEDIUM);
    grocery = new Painting(false, "333 Grocery Way", 29, 0,
        PropertySize.LARGE);
    shed = new Painting(true, "123 Backyard Road", 8, 0,
        PropertySize.SMALL);
    monthlyAndPrevious = new Painting(true, "887 Monthly Block",
        39, 2, PropertySize.MEDIUM);
    paris = new Painting(true, "103 Love City", 11, 0,
        PropertySize.LARGE);
    noDiscount1 = new Painting(false, "903 Gray Ave", 17, 0,
        PropertySize.SMALL);
    noDiscount2 = new Painting(false, "756 Blue Street", 34,
        8, PropertySize.MEDIUM);
  }

  @Test
  public void setHours() {
    assertEquals(16, cottage.setHours(PropertySize.MEDIUM));
    assertEquals(24, grocery.setHours(PropertySize.LARGE));
    assertEquals(16, shed. setHours(PropertySize.SMALL));
  }

  @Test
  public void calculatePreviousServiceDiscount() {
    cottage.setHours(PropertySize.MEDIUM);
    assertEquals(684.8, cottage.calculatePrice(), 0.001);
    grocery.setHours(PropertySize.LARGE);
    assertEquals(960, grocery.calculatePrice(), 0.001);
    monthlyAndPrevious.setHours(PropertySize.MEDIUM);
    assertEquals(672, monthlyAndPrevious.calculatePrice(), 0.001);

  }

  @Test
  public void calculateMonthlyDiscount() {
    shed.setHours(PropertySize.SMALL);
    assertEquals(1152, shed.calculatePrice(), 0.001);
    paris.setHours(PropertySize.LARGE);
    assertEquals(1728, paris.calculatePrice(), 0.001);
  }

  @Test
  public void calculateNoDiscount() {
    noDiscount1.setHours(PropertySize.SMALL);
    assertEquals(1280, noDiscount1.calculatePrice(), 0.001);
    noDiscount2.setHours(PropertySize.MEDIUM);
    assertEquals(1369.6, noDiscount2.calculatePrice(), 0.001);
  }
}