package lockers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MailTest {
  Mail envelope;
  Mail negative;
  Mail zero;

  @Before
  public void setUp() throws Exception {
    envelope = new Mail("John", "Snow", "john.snow@yahoo.com",
        4, 2, 1);
  }

  @Test (expected = InvalidSizeException.class)
  public void invalidInput() throws InvalidSizeException {
    negative = new Mail("negative", "number", "negnum@aol.com",
        -1, -1, -1);
    zero = new Mail("zero", "hero", "zero@aol.com",
        0, 0, 0);
  }

  @Test
  public void correctWidth() throws InvalidSizeException {
    envelope.setWidth(4);
    assertEquals(4, envelope.getWidth());
  }

  @Test (expected = InvalidSizeException.class)
  public void incorrectHeight() throws InvalidSizeException {
    envelope.setHeight(-1);
    envelope.setHeight(0);
  }

  @Test (expected = InvalidSizeException.class)
  public void incorrectWidth() throws InvalidSizeException {
    envelope.setWidth(-1);
    envelope.setWidth(0);
  }

  @Test (expected = InvalidSizeException.class)
  public void incorrectDepth() throws InvalidSizeException {
    envelope.setDepth(0);
    envelope.setDepth(-1);
  }

  @Test
  public void getWidth() { assertEquals(4, envelope.getWidth());
  }

  @Test
  public void correctHeight() throws InvalidSizeException {
    envelope.setHeight(2);
    assertEquals(2, envelope.getHeight());
  }

  @Test
  public void getHeight() { assertEquals(2, envelope.getHeight());
  }

  @Test
  public void correctDepth() throws InvalidSizeException {
    envelope.setDepth(1);
    assertEquals(1, envelope.getDepth());
  }

  @Test
  public void getDepth() { assertEquals(1, envelope.getDepth());
  }
}