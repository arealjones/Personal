package problem1.Exterior;

import java.util.Objects;
import problem1.FloorsException;
import problem1.Interfaces.Fees;
import problem1.PropertySize;

/**
 * Window Cleaning is an object of an exterior service. It contains the allowed amount of floors,
 * fees, and price. */
public class WindowCleaning extends Exterior implements Fees {
  private int floors;
  /**
   * Constructor that creates a new window cleaning service with information about the property.
   * @param monthly If the service happens monthly.
   * @param address The address of the property.
   * @param previousServices How many times has the property been serviced before.
   * @param size The size of the property.
   * @param floors The amount of floors the property has.
   * @throws FloorsException An exception to catch that the property does not have more than four
   * floors. */
  public WindowCleaning(boolean monthly, String address, int previousServices, PropertySize size,
      int floors)
      throws FloorsException {
    super(monthly, address, previousServices, size);
    setFloors(floors);
    this.floors = floors;
  }
  /**
   * Sets the amount of floors in the property and catches any properties that have more than four
   * floors.
   * @param floors The amount of floors the property has.
   * @throws FloorsException An exception to catch that the property does not have more than four
   * floors. */
  public void setFloors(int floors) throws FloorsException {
    int maximumFloors = 3;
    if ((floors <= maximumFloors) &&
        (floors > 0)) {
      this.floors = floors;
    }
    else {
      throw new FloorsException();
    }
  }
  /**
   * Returns the amount of floors in the property.
   * @return Returns the amount of floors in the property. */
  public int getFloors() {
    return this.floors;
  }
  /**
   * Returns the fee for the service based on the number of floors the property has.
   * @return Returns the fee for the service based on the number of floors the property has. */
  @Override
  public double fee() {
    double floorFee = .05;
    if (floors > 1) {
      return (rate() * floorFee);
    }
    return 0;
  }
  /**
   * Returns the price of the service based on the rate, fees, discounts, and number of hours it
   * took to finish.
   * @return Returns the price of the service. */
  public double calculatePrice() {
    return (((rate() + fee()) * getHours()) - (((rate() + fee()) * discount()) * getHours()));
  }
  /**
   * Returns true or false based on if the current object is the same as the one being compared.
   * @param o The object being compared.
   * @return Returns true or false. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    WindowCleaning that = (WindowCleaning) o;
    return floors == that.floors;
  }
  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false. */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), floors);
  }
  /**
   * Returns a string of the window cleaning service including the amount of floors in the
   * property.
   * @return Returns a string of the window cleaning service. */
  @Override
  public String toString() {
    return super.toString() + " ADD ON: This property also has " + floors +
        " floors to include for the cost of services. ";
  }
}
