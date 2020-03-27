package catering;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DinnerTest {
  Dinner birthday;
  Dinner notEnoughPeople;
  Dinner tooManyPeople;
  Dinner negative;

  @Before
  public void setUp() throws Exception {
    birthday = new Dinner("Birthday Party", 20, 16,
        4);
    notEnoughPeople = new Dinner("Less People", 5,
        0, 0);
    tooManyPeople = new Dinner("Too Many", 77,
        0, 0);
    negative = new Dinner("Negative Number", -4,
        0, 0);
  }

  @Test
  public void correct() throws InvalidAmountOfPeopleException {
    birthday.setNumberPlates();
    assertEquals(16, birthday.getNumberNonVegetarian());
    birthday.setNumberPlates();
    assertEquals(4, birthday.getNumberVegetarian());
  }

  @Test (expected = InvalidAmountOfPeopleException.class)
  public void notEnough() throws InvalidAmountOfPeopleException {
    notEnoughPeople.setNumberPlates();
  }

  @Test (expected = InvalidAmountOfPeopleException.class)
  public void tooMany() throws InvalidAmountOfPeopleException {
    tooManyPeople.setNumberPlates();
  }

  @Test (expected = InvalidAmountOfPeopleException.class)
  public void negative() throws InvalidAmountOfPeopleException {
    negative.setNumberPlates();
  }

  @Test
  public void getNumberNonVegetarian() { assertEquals(16,
      birthday.getNumberNonVegetarian());
  }

  @Test
  public void getNumberVegetarian() { assertEquals(4, birthday.getNumberVegetarian());
  }
}