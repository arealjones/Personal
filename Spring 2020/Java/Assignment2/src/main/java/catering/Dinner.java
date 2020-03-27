package catering;
/**
 * Dinner is an object that contains the name of the event, number of people attending,
 * number of non-vegetarian dishes needed, and number of vegetarian dishes needed. */
public class Dinner extends Events {
  private int numberNonVegetarian;
  private int numberVegetarian;
  /**
   * Constructor that creates a new dinner object with the event name, number of people, number
   * of non-vegetarian and vegetarian dishes needed.
   * @param name The name of the event.
   * @param numberOfPeople The number of people attending.
   * @param numberNonVegetarian The number of non-vegetarian dishes needed.
   * @param numberVegetarian The number of vegetarian dishes needed. */
  public Dinner(String name, int numberOfPeople, int numberNonVegetarian, int numberVegetarian) {
    super(name, numberOfPeople);
    this.numberNonVegetarian = numberNonVegetarian;
    this.numberVegetarian = numberVegetarian;
  }
  /**
   * Returns true if the amount of people attending is within the constraints of this type of
   * event and false otherwise.
   * @return Returns true if between 10 and 50 people. */
  private boolean correctAmountOfPeople() {
    int minAmount = 10;
    int maxAmount = 50;
    if ((super.getNumberOfPeople() >= minAmount) && (super.getNumberOfPeople() <= maxAmount)) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
   * Assigns the number of non-vegetarian and vegetarian required if there is the correct amount
   * of people attending. It will throw an exception otherwise.
   * @throws InvalidAmountOfPeopleException Will throw a string stating that there is not enough
   * or too many people attending for this event. */
  public void setNumberPlates() throws InvalidAmountOfPeopleException {
    double percentNonVegetarian = .80;
    double percentVegetarian = .20;
    if (correctAmountOfPeople()) {
      int nonVegetarian = (int) Math.round(super.getNumberOfPeople() * percentNonVegetarian);
      int vegetarian = (int) Math.round(super.getNumberOfPeople() * percentVegetarian);
      this.numberNonVegetarian = nonVegetarian;
      this.numberVegetarian = vegetarian;
    }
    else {
      throw new InvalidAmountOfPeopleException();
    }
  }
  /**
   * Returns the number of non-vegetarian dishes required for the event.
   * @return Returns the number of non-vegetarian dishes required for the event. */
  public int getNumberNonVegetarian() {
    return numberNonVegetarian;
  }
  /**
   * Returns the number of vegetarian dishes required for the event.
   * @return Returns the number of vegetarian dishes required for the event. */
  public int getNumberVegetarian() {
    return numberVegetarian;
  }
}
