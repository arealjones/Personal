package problem1.Specialty;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.PropertySize;

public class ElectricalTest {
  Electrical bathroom;
  Electrical bedroom;
  Electrical kitchen;
  Electrical livingRoom;
  Electrical testingError;
  Electrical testingError2;

  @Before
  public void setUp() throws Exception {
    bathroom = new Electrical(true, "454 Shampoo Heaven", 5,
        PropertySize.LARGE, false, 4);
    bedroom = new Electrical(false, "779 zzz awaits", 19,
        PropertySize.SMALL, true, 3);
    kitchen = new Electrical(true, "123 knife city", 29,
        PropertySize.MEDIUM, true, 2);
    livingRoom = new Electrical(false, "303 Relaxation Room", 11,
        PropertySize.LARGE, false, 0);
  }

  @Test
  public void fee() {
    assertEquals(50, bathroom.fee(), 0.001);
    assertNotEquals(20, bedroom.fee(), 0.001);
  }

  @Test
  public void setCorrectEmployees() {
    bathroom.setMinimumEmployees(PropertySize.LARGE, 4);
    assertEquals(4, bathroom.getEmployees());
    bedroom.setMinimumEmployees(PropertySize.SMALL, 3);
    assertEquals(3, bedroom.getEmployees());
    kitchen.setMinimumEmployees(PropertySize.MEDIUM, 2);
    assertEquals(2, kitchen.getEmployees());
    livingRoom.setMinimumEmployees(PropertySize.LARGE, 0);
    assertEquals(1, livingRoom.getEmployees());
  }

  @Test (expected = IllegalArgumentException.class)
  public void setIncorrectEmployees() throws IllegalArgumentException {
    testingError = new Electrical(true, "4 test", 3,
        PropertySize.MEDIUM, true, 8);
    testingError2 = new Electrical(false, "3 Hey", 2,
        PropertySize.LARGE, false, 23);
  }


  @Test
  public void calculatePrice() {
    bathroom.setMinimumEmployees(PropertySize.LARGE,4 );
    assertEquals(850, bathroom.calculatePrice(), 0.001);
    bedroom.setMinimumEmployees(PropertySize.SMALL, 3);
    assertEquals(650, bedroom.calculatePrice(), 0.001);
    kitchen.setMinimumEmployees(PropertySize.MEDIUM, 2);
    assertEquals(450, kitchen.calculatePrice(), 0.001);
  }
}