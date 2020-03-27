package problem1.Exterior;

import java.util.Objects;
import problem1.Interfaces.Discounts;
import problem1.PropertySize;
import problem1.Interfaces.Rate;
import problem1.AbstractServices;
/**
 * Exterior is an object that contains the hours, rates, and discounts that cover both gardening
 * and window cleaning services. */
public class Exterior extends AbstractServices implements Rate, Discounts {
  private int hours;
  /**
   * Constructor that creates a new exterior service with the information about the property,
   * hours, rates, and discounts for the gardening and window cleaning.
   * @param monthly If the service happens monthly.
   * @param address The address of the property.
   * @param previousServices How many times has the property been serviced before.
   * @param size The size of the property. */
  public Exterior(boolean monthly, String address, int previousServices, PropertySize size)
      throws IllegalArgumentException {
    super(monthly, address, previousServices);
    this.hours = setHours(size);
  }
  /**
   * Sets the amount of hours needed to complete the service based on the size of the property.
   * @param size The size of the property.
   * @return The parameter with the correct amount of hours needed. */
  public int setHours(PropertySize size) {
    int oneHour = 1;
    int twoHours = 2;
    int fourHours = 4;
    switch (size) {
      case SMALL:
        return this.hours = oneHour;
      case MEDIUM:
        return this.hours = twoHours;
      case LARGE:
        return this.hours = fourHours;
      default:
        return this.hours = 0;
    }
  }

  /**
   * Returns the number of hours needed to finish the project.
   * @return Returns the number of hours needed to finish the project. */
  public int getHours() {
    return this.hours;
  }
  /**
   * Returns the base hourly rate for exterior services.
   * @return Returns the base hourly rate for exterior services. */
  @Override
  public int rate() {
    int baseRate = 80;
    return baseRate;
  }
  /**
   * Return the discount rate for the exterior service based on if they had the correct amount of
   * previous services or if it is a monthly service.
   * @return Return the discount rate for the exterior service. */
  @Override
  public double discount() {
    int ten = 10;
    int remainder = 9;
    double fiftyPercent = .50;
    double tenPercent = .10;
    if (getPreviousServices() % ten == remainder) {
      return (float)(fiftyPercent);
    }
    else if (isMonthly()) {
      return (float)(tenPercent);
    }
    else {
      return 0;
    }
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
    Exterior exterior = (Exterior) o;
    return hours == exterior.hours;
  }
  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false.  */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), hours);
  }
  /**
   * Returns a string of the exterior service including how many hours it will take to complete.
   * @return Returns a string of the exterior service. */
  @Override
  public String toString() {
    return super.toString() + ". It will require " + hours +
        " hours to complete the project.";
  }
}
