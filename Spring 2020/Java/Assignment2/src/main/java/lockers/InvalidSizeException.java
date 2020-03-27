package lockers;
/**
 * InvalidSize is an exception created to make sure the size of the mail and the locker is greater
 * than 0. */
public class InvalidSizeException extends Exception {
  /**
   * Constructor that contains a string message stating that the size chosen for one of the sides
   * of the locker or mail is incorrect and to choose a new size. */
  public InvalidSizeException() {
    super("Invalid size, please choose a new one.");
  }
}
