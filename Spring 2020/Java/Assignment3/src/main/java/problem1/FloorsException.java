package problem1;
/**
 * Floors exception is created to make sure the size of the house does not exceed three floors. */
public class FloorsException extends Exception {

  /**
   * Constructor that contains a string message stating that the amount of floors entered
   * exceed the amount allowed for service or were inputted incorrectly. */
  public FloorsException() {
    super("The amount of floors entered for this house either exceed the allowed amount "
        + "for service or were incorrectly inputted. Please try again.");
  }

}
