package catering;
/**
 * This is my super events object that the lunch and dinner objects extend from. It contains
 * the name of the event and number of people attending. */
public class Events {
  private String name;
  private int numberOfPeople;
  /**
   * Constructor that creates the name and number of people attending the event.
   * @param name The name of the event.
   * @param numberOfPeople The number of people attending. */
  public Events(String name, int numberOfPeople) {
    this.name = name;
    this.numberOfPeople = numberOfPeople;
  }
  /**
   * Sets the name of the event with the string provided.
   * @param name Sets the name of the event with the string provided. */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * Returns the name of the event.
   * @return Returns the name of the event. */
  public String getName() {
    return name;
  }
  /**
   * Returns the number of people attending the event.
   * @return Returns the number of people attending the event. */
  public int getNumberOfPeople() {
    return numberOfPeople;
  }
}
