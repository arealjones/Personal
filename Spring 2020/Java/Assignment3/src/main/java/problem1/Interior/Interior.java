package problem1.Interior;

import java.util.Objects;
import problem1.Interfaces.Discounts;
import problem1.Interfaces.Fees;
import problem1.Interfaces.Rate;
import problem1.AbstractServices;
import problem1.PropertySize;
/**
 * Interior is an object that contains the number of pets, hours, rates, and discounts that cover
 * both cleaning and painting services. */
public class Interior extends AbstractServices implements Rate, Fees, Discounts {
  private int pets;
  protected int hours;
  /**
   * Constructor that creates a new interior service with the information about the property,
   *    * hours, rates, discounts, and number of pets for the cleaning and painting services.
   * @param monthly If the service happens monthly.
   * @param address The address of the property.
   * @param previousServices How many times has the property been serviced before.
   * @param pets The number of pets in the property.
   * @param size The size of the property.
   * @throws IllegalArgumentException Catches if someone tries to enter a negative number for
   * pets. */
  public Interior(boolean monthly, String address, int previousServices, int pets,
      PropertySize size) throws IllegalArgumentException {
    super(monthly, address, previousServices);
    setPets(pets);
    this.pets = pets;
    this.hours = setHours(size);
  }
  /**
   * Returns the number of pets on the property.
   * @return Returns the number of pets on the property. */
  public int getPets() {
    return this.pets;
  }
  /**
   * Sets the number of pets on the property and catches if someone tries to enter a negative
   * number.
   * @param pets The number of pets in the property.
   * @throws IllegalArgumentException Catches if someone tries to enter a negative number for
   * pets. */
  public void setPets(int pets) throws IllegalArgumentException {
    if (pets >= 0) {
      this.pets = pets;
    }
    else {
      throw new IllegalArgumentException();
    }
  }
  /**
   * Returns the number of hours needed to finished the project.
   * @return Returns the number of hours needed to finished the project. */
  public int getHours() {
    return this.hours;
  }
  /**
   * Sets the amount of hours needed to complete the service based on the size of the property.
   * @param size The size of the property.
   * @return The parameter with the correct amount of hours needed. */
  public int setHours(PropertySize size) {
    int one = 1;
    int two = 2;
    int four = 4;
    switch (size) {
      case SMALL:
        return this.hours = one;
      case MEDIUM:
        return this.hours = two;
      case LARGE:
        return this.hours = four;
      default:
        return this.hours = 0;
    }
  }
  /**
   * Returns the base hourly rate for interior services.
   * @return Returns the base hourly rate for interior services. */
  @Override
  public int rate() {
    int baseRate = 80;
    return baseRate;
  }
  /**
   * Returns the fee for having any pets on the property.
   * @return Returns the fee for having any pets on the property. */
  @Override
  public double fee() {
    int one = 1;
    int two = 2;
    int three = 3;
    double fivePercent = .05;
    double sevenPercent = .07;
    if ((pets == one) ||
        (pets == two)) {
      return (float)(rate() * fivePercent);
    }
    else if (pets >= three) {
      return (float)(rate() * sevenPercent);
    }
    return 0;
  }
  /**
   * Returns the discount rate for the interior service based on if they had the correct amount of
   * previous services or if it is a monthly service.
   * @return Return the discount rate for the interior service. */
  @Override
  public double discount() {
    int ten = 10;
    int remainder = 9;
    double fiftyPercent = .50;
    double tenPercent = .10;
    if (getPreviousServices() % ten == remainder) {
      return (float)((rate() + fee()) * fiftyPercent);
    }
    else if (isMonthly()) {
      return (float)((rate() + fee()) * tenPercent);
    }
    else {
      return 0;
    }
  }
  /**
   * Return the price of the cleaning and painting service.
   * @return Return the price of the cleaning and painting service. */
  public double calculatePrice() {
    return (((rate() + fee()) * getHours()) - (discount() * getHours()));
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
    Interior interior = (Interior) o;
    return pets == interior.pets;
  }
  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false. */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), pets);
  }
  /**
   * Returns a string of the exterior service including how many hours it will take to complete.
   * @return Returns a string of the exterior service. */
  @Override
  public String toString() {
    return super.toString() + ". It will require " + hours + " hours to complete the project. "
        + "ADD ON: The property also has " + pets + " pets to include for the cost of services.";
  }
}
