package lockers;
/**
 * LockerException is created to make sure the locker is empty or will fit the piece of mail
 * trying to be added. */
public class LockerException extends Exception {
  /**
   * Constructor that contains a string message stating the locker is full or that the size of
   * mail trying to be added will not fit and to choose a new locker. */
  public LockerException() {
    super("Locker is full or will not fit the size of mail you have, please choose a new one.");
  }
}
