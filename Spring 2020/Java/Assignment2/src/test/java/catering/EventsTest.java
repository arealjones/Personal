package catering;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EventsTest {
  Events birthday;

  @Before
  public void setUp() throws Exception {
    birthday = new Events("Birthday Party", 20);
  }

  @Test
  public void setName() {
    birthday.setName("Birthday Party");
    assertEquals("Birthday Party", birthday.getName());
  }

  @Test
  public void getName() { assertEquals("Birthday Party", birthday.getName());
  }

  @Test
  public void getNumberOfPeople() { assertEquals(20, birthday.getNumberOfPeople());
  }
}