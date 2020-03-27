package problem1.Interior;

import problem1.PropertySize;
/**
 * Gardening is an object of an interior service. */
public class Cleaning extends Interior {

  /**
   * Constructor that creates a new cleaning service with information about the property.
   * @param monthly If the service happens monthly.
   * @param address The address of the property.
   * @param previousServices How many times has the property been serviced before.
   * @param pets The amount of pets on the property.
   * @param size The size of the property.
   * @throws IllegalArgumentException Catches if someone tries to enter a negative number for
   * pets. */
  public Cleaning(boolean monthly, String address, int previousServices, int pets,
      PropertySize size) throws IllegalArgumentException {
    super(monthly, address, previousServices, pets, size);
  }
}
