package catering;
/**
 * Schedule is an object that contains the date, any lunch events that are booked, and any dinner
 * events that are booked. */
public class Schedule {
  private String date;
  private Lunch lunch;
  private Dinner dinner;
  /**
   * Constructor that creates a new schedule of one lunch and one dinner event for a specific date.
   * @param date The date of the event.
   * @param lunch A lunch object if there is one booked for this date. Null otherwise.
   * @param dinner A dinner object if there is one booked for this date. Null otherwise. */
  public Schedule(String date, Lunch lunch, Dinner dinner) {
    this.date = date;
    this.lunch = lunch;
    this.dinner = dinner;
  }
  /**
   * Sets the date for the schedule.
   * @param date Sets the date for the schedule.
   */
  public void setDate(String date) {
    this.date = date;
  }
  /**
   * Returns the date of the schedule.
   * @return Returns the date of the schedule.
   */
  public String getDate() {
    return date;
  }
  /**
   * If the lunch slot is empty, it will return true. False otherwise.
   * @return If the lunch slot is empty, it will return true. False otherwise. */
  private boolean lunchNotBooked() {
    if (this.lunch == null) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
   * If the dinner slot is empty, it will return true. False otherwise.
   * @return If the dinner slot is empty, it will return true. False otherwise. */
  private boolean dinnerNotBooked() {
    if (this.dinner == null) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
   * Adds a lunch object if there is not one already booked for that date. Throws an exception if
   * an event is booked.
   * @param newLunch Is a lunch object trying to be added to the schedule for that day.
   * @throws EventAlreadyPlannedException Throws this exception if an event is already booked. */
  public void addLunch(Lunch newLunch) throws EventAlreadyPlannedException {
    if (lunchNotBooked()) {
      this.lunch = newLunch;
    }
    else {
      throw new EventAlreadyPlannedException();
    }
  }
  /**
   * Adds a dinner object if there is not one already booked for that date. Throws an exception if
   * an event is booked.
   * @param newDinner Is a dinner object trying to be added to the schedule for that day.
   * @throws EventAlreadyPlannedException Throws this exception if an event is already booked. */
  public void addDinner(Dinner newDinner) throws EventAlreadyPlannedException {
    if (dinnerNotBooked()) {
      this.dinner = newDinner;
    }
    else {
      throw new EventAlreadyPlannedException();
    }
  }
  /**
   * Returns the lunch event scheduled for that date.
   * @return Returns the lunch event scheduled for that date. */
  public Lunch getLunch() {
    return lunch;
  }
  /**
   * Returns the dinner event scheduled for that date.
   * @return Returns the dinner event scheduled for that date. */
  public Dinner getDinner() {
    return dinner;
  }
}
