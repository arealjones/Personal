package catering;
/**
 * EventAlreadyPlanned is an exception created to avoid someone booking more than one lunch or
 * dinner event for the same date. */
public class EventAlreadyPlannedException extends Exception {
  /**
   * Constructor that contains a string message stating that an event has already been booked for
   * the date they wanted and to please choose a new date. */
  public EventAlreadyPlannedException() {
    super("That type of event is already scheduled for that date, please choose a new date.");
  }
}
