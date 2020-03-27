package problem1.Exterior;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.PropertySize;

public class GardeningTest {
  Gardening flowerBed;
  Gardening previousService;
  Gardening monthlyService;
  Gardening noDiscount1;
  Gardening noDiscount2;

  @Before
  public void setUp() throws Exception {
    flowerBed = new Gardening(false, "987 Pretty Road", 9,
        PropertySize.LARGE);
    previousService = new Gardening(true, "104 previous way", 49,
        PropertySize.MEDIUM);
    monthlyService = new Gardening(true, "628 monthly street", 15,
        PropertySize.SMALL);
    noDiscount1 = new Gardening(false, "404 discount ave", 21,
        PropertySize.SMALL);
    noDiscount2 = new Gardening(false, "375 Royal Blvd", 0,
        PropertySize.MEDIUM);
  }

  @Test
  public void fee() {
    assertEquals(20, flowerBed.fee(), 0.001);
    assertNotEquals(84, previousService.fee(), 0.001);
  }

  @Test
  public void calculatePrice() {
    flowerBed.setHours(PropertySize.LARGE);
    assertEquals(170, flowerBed.calculatePrice(), 0.001);
    previousService.setHours(PropertySize.MEDIUM);
    assertEquals(90, previousService.calculatePrice(), 0.001);
    monthlyService.setHours(PropertySize.SMALL);
    assertEquals(90, monthlyService.calculatePrice(), 0.001);
    noDiscount1.setHours(PropertySize.SMALL);
    assertEquals(100, noDiscount1.calculatePrice(), 0.001);
    noDiscount2.setHours(PropertySize.MEDIUM);
    assertEquals(180, noDiscount2.calculatePrice(), 0.001);
  }
}