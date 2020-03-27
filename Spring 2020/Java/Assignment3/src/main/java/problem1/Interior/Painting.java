package problem1.Interior;

import problem1.PropertySize;
/**
 * Painting is an object of an interior service. It contains the hours needed to finish the
 * project. */
public class Painting extends Interior {
  /**
   * Constructor that creates a new painting service with information about the property.
   * @param monthly If the service happens monthly.
   * @param address The address of the property.
   * @param previousServices How many times has the property been serviced before.
   * @param pets The amount of pets on the property.
   * @param size The size of the property.
   * @throws IllegalArgumentException Catches if someone tries to enter a negative number for
   * pets. */
  public Painting(boolean monthly, String address, int previousServices, int pets,
      PropertySize size) throws IllegalArgumentException {
    super(monthly, address, previousServices, pets, size);
  }
  /**
   * Sets the number of hours needed to finish the project.
   * @param size The size of the property.
   * @return The parameter with the correct amount of hours needed. */
  @Override
  public int setHours(PropertySize size) {
    int smallAndMedium = 16;
    int large = 24;
    switch (size) {
      case SMALL:
      case MEDIUM:
        return this.hours = smallAndMedium;
      case LARGE:
        return this.hours = large;
      default:
        return this.hours = 0;
    }
  }
}
