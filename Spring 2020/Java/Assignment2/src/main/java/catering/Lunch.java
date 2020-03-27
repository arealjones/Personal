package catering;
/**
 * Lunch is an object that contains the name of the event, number of people attending, and
 * number of sandwiches needed.
 */
public class Lunch extends Events {
  private int numberOfSandwiches;
  /**
   * Constructor that creates a new lunch object with the event name, number of people, and number
   * of sandwiches needed.
   * @param name The name of the event.
   * @param numberOfPeople The number of people attending.
   * @param numberOfSandwiches The number of sandwiches needed. */
  public Lunch(String name, int numberOfPeople, int numberOfSandwiches) {
    super(name, numberOfPeople);
    this.numberOfSandwiches = numberOfSandwiches;
  }
  /**
   * Returns true if the amount of people attending is within the constraints of this type of
   * event and false otherwise.
   * @return Returns true if between 15 and 90 people. */
  private boolean correctAmountOfPeople() {
    int minAmount = 15;
    int maxAmount = 90;
    if ((super.getNumberOfPeople() >= minAmount) && (super.getNumberOfPeople() <= maxAmount)) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
   * Assigns the number of sanwiches required if there is the correct amount of people attending.
   * It will throw an exception otherwise.
   * @throws InvalidAmountOfPeopleException Will throw a string stating that there is not enough
   * or too many people attending for this event. */
  public void setNumberOfSandwiches() throws InvalidAmountOfPeopleException {
    double percentSandwiches = .05;
    if (correctAmountOfPeople()) {
      int sandwiches = (int) Math.round((super.getNumberOfPeople() * (percentSandwiches)) +
          super.getNumberOfPeople());
      this.numberOfSandwiches = sandwiches;
    }
    else {
      throw new InvalidAmountOfPeopleException();
    }
  }
  /**
   * Returns the number of sandwiches required for the event.
   * @return Returns the number of sandwiches required for the event. */
  public int getNumberOfSandwiches() {
      return numberOfSandwiches;
  }
}
