package lockers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LockerTest {
  Mail box;
  Mail envelope;
  Mail allTooBig;
  Mail heightBig;
  Mail depthBig;
  Mail book;
  Locker one;
  Locker negative;
  Locker zero;
  Locker two;
  Locker three;
  Recipient rock;
  Recipient jane;
  Recipient incorrectLastName;
  Recipient incorrectEmail;

  @Before
  public void setUp() throws Exception {
    box = new Mail("Rock", "Johnson", "buff@yahoo.com",
        2, 4, 2);
    envelope = new Mail("Elle", "Woods", "elle@yahoo.com",
        2, 2, 2);
    allTooBig = new Mail("Bob", "Burgers", "bob@aol.com",
        16, 24, 18);
    heightBig = new Mail("height", "big", "height@aol.com",
        4, 12, 8);
    depthBig = new Mail("depth", "big", "depth@yahoo.com",
        6, 7, 14);
    one = new Locker(8, 8, 4, box);
    two = new Locker(8, 10, 8, null);
    three = new Locker(5, 6, 10, null);
    rock = new Recipient("Rock", "Johnson", "buff@yahoo.com");
    incorrectLastName = new Recipient("Rock", "Jonson", "buff@yahoo.com");
    incorrectEmail = new Recipient("Rock", "Johnson", "buff@aol.com");
    jane = new Recipient("Jane", "Doe", "doe@apple.com");
  }

  @Test (expected = InvalidSizeException.class)
  public void invalidInput() throws InvalidSizeException {
    book = new Mail("Book", "Reader", "book@yahoo.com",
        -1, -1, -1);
    negative = new Locker(-1, -1, -1, null);
    zero = new Locker(0, 0, 0, envelope);
  }

  @Test (expected = InvalidSizeException.class)
  public void invalidSize() throws InvalidSizeException {
    one.invalidSize(-1);
    two.invalidSize(0);
  }

  @Test
  public void correctWidth() throws InvalidSizeException {
    one.setWidth(8);
    assertEquals(8, one.getWidth());
  }

  @Test
  public void getWidth() { assertEquals(8, one.getWidth());
  }

  @Test
  public void correctHeight() throws InvalidSizeException {
    one.setHeight(8);
    assertEquals(8, one.getHeight());
  }

  @Test
  public void getHeight() { assertEquals(8, one.getHeight());
  }

  @Test
  public void correctDepth() throws InvalidSizeException {
    one.setDepth(4);
    assertEquals(4, one.getDepth());
  }

  @Test
  public void getDepth() { assertEquals(4, one.getDepth());
  }

  @Test (expected = InvalidSizeException.class)
  public void incorrectHeight() throws InvalidSizeException {
    one.setHeight(-1);
    two.setHeight(0);
  }

  @Test (expected = InvalidSizeException.class)
  public void incorrectWidth() throws InvalidSizeException {
    one.setWidth(-1);
    two.setWidth(0);
  }

  @Test (expected = InvalidSizeException.class)
  public void incorrectDepth() throws InvalidSizeException {
    one.setDepth(0);
    two.setDepth(-1);
  }

  @Test
  public void getMail() { assertEquals(box, one.getMail());
  }

  @Test
  public void correctAddingMail() throws LockerException {
    two.addMail(envelope);
    assertEquals(envelope, two.getMail());
  }

  @Test (expected = LockerException.class)
  public void lockerFull() throws LockerException {
    one.addMail(envelope);
    assertEquals(box, one.getMail());
  }

  @Test (expected = LockerException.class)
  public void widthBiggerThanLocker() throws LockerException {
    two.addMail(allTooBig);
    assertEquals(null, two.getMail());
  }

  @Test (expected = LockerException.class)
  public void heightBiggerThanLocker() throws LockerException {
    three.addMail(heightBig);
    assertEquals(null, three.getMail());
  }

  @Test (expected = LockerException.class)
  public void depthBiggerThanLocker() throws LockerException {
    three.addMail(depthBig);
    assertEquals(null, three.getMail());
  }

  @Test
  public void correctPickup() throws IncorrectRecipientException {
    assertEquals(box, one.pickupMail(rock));
    assertEquals(null, one.getMail());
  }

  @Test (expected = IncorrectRecipientException.class)
  public void incorrectPerson() throws IncorrectRecipientException {
    one.pickupMail(jane);
  }

  @Test (expected = IncorrectRecipientException.class)
  public void emptyLocker() throws IncorrectRecipientException {
    two.pickupMail(jane);
  }

  @Test (expected = IncorrectRecipientException.class)
  public void incorrectLastName() throws IncorrectRecipientException {
    one.pickupMail(incorrectLastName);
  }

  @Test (expected = IncorrectRecipientException.class)
  public void incorrectEmail() throws IncorrectRecipientException {
    one.pickupMail(incorrectEmail);
  }
}