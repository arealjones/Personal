package lockers;
/**
 * IncorrectRecipient is an exception created to make sure the correct person is taking the mail
 * out of the locker. */
public class IncorrectRecipientException extends Exception {
  /**
   * Constructor that contains a string message stating that the person trying to take the mail
   * out of the locker is incorrect and to make sure they are at the correct locker. */
  public IncorrectRecipientException() {
    super("Incorrect recipient, please check that you are at the correct locker.");
  }
}
