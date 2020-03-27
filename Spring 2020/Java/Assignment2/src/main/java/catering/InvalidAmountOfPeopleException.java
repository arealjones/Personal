package catering;
/**
 * InvalidAmountOfPeople is an exception created to make sure the number of people for the event
 * stay within the constraints set by the type of event. */
public class InvalidAmountOfPeopleException extends Exception {
  /**
   * Constructor that contains a string message stating that the event they are trying to create
   * either has too many people or not enough to qualify for booking. */
  public InvalidAmountOfPeopleException() {
    super("Invalid amount of people. You may have too many people or "
        + "not enough to plan an event. ");
  }
}
