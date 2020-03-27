package catering;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LunchTest {
  Lunch graduation;
  Lunch notEnoughPeople;
  Lunch tooManyPeople;
  Lunch negative;

  @Before
  public void setUp() throws Exception {
    graduation = new Lunch("Graduation", 15, 16);
    notEnoughPeople = new Lunch("Less People", 5, 0);
    tooManyPeople = new Lunch("Too Many", 95, 0);
    negative = new Lunch("Negative Number", -4, 0);
  }

  @Test
  public void correct() throws InvalidAmountOfPeopleException {
    graduation.setNumberOfSandwiches();
    assertEquals(16, graduation.getNumberOfSandwiches());
  }

  @Test (expected = InvalidAmountOfPeopleException.class)
  public void notEnough() throws InvalidAmountOfPeopleException {
    notEnoughPeople.setNumberOfSandwiches();
  }

  @Test (expected = InvalidAmountOfPeopleException.class)
  public void tooMany() throws InvalidAmountOfPeopleException {
    tooManyPeople.setNumberOfSandwiches();
  }

  @Test (expected = InvalidAmountOfPeopleException.class)
  public void negative() throws InvalidAmountOfPeopleException {
    negative.setNumberOfSandwiches();
  }

  @Test
  public void getNumberOfSandwiches() { assertEquals(16,
      graduation.getNumberOfSandwiches());
  }
}