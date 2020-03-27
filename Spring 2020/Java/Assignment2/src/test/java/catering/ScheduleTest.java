package catering;

import static org.junit.Assert.*;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import sun.font.TrueTypeFont;

public class ScheduleTest {
  Schedule today;
  Lunch canBookLunch;
  Schedule completelyBooked;
  Lunch cannotBookLunch;
  Schedule tomorrow;
  Dinner canBookDinner;
  Dinner cannotBookDinner;
  Lunch coding;
  Dinner wedding;

  @Before
  public void setUp() throws Exception {
    today = new Schedule("1/16/20", null, new Dinner("Birthday Bash",
        11, 9, 2));
    canBookLunch = new Lunch("Meeting", 30, 32);
    coding = new Lunch("Coding", 45, 48);
    wedding = new Dinner("Wedding", 30, 24,
        6);
    completelyBooked = new Schedule("4/14/20", coding, wedding);
    cannotBookLunch = new Lunch("Coffee Lovers", 17, 18);
    tomorrow = new Schedule("2/14/20", null, null);
    canBookDinner = new Dinner("Pizza fo life", 10, 8,
        2);
    cannotBookDinner = new Dinner("Unicorns", 20, 16,
        4);
  }

  @Test
  public void setDate() { today.setDate("1/16/20");
  assertEquals("1/16/20", today.getDate());
  }

  @Test
  public void getDate() { assertEquals("1/16/20", today.getDate());
  }

  @Test
  public void getLunch() { assertEquals(null, today.getLunch());
  }

  @Test
  public void getDinner() {assertEquals(null, tomorrow.getDinner());
  }

  @Test
  public void canAddLunch() throws EventAlreadyPlannedException {
    today.addLunch(canBookLunch);
    assertEquals(canBookLunch, today.getLunch());
  }

  @Test (expected = EventAlreadyPlannedException.class)
  public void cannotAddLunch() throws EventAlreadyPlannedException {
    completelyBooked.addLunch(cannotBookLunch);
    assertEquals(coding, completelyBooked.getLunch());
  }

  @Test
  public void canAddDinner() throws EventAlreadyPlannedException {
    tomorrow.addDinner(canBookDinner);
    assertEquals(canBookDinner, tomorrow.getDinner());
  }

  @Test (expected = EventAlreadyPlannedException.class)
  public void cannotAddDinner() throws EventAlreadyPlannedException {
    completelyBooked.addDinner(cannotBookDinner);
    assertEquals(wedding, completelyBooked.getDinner());
  }
}