package problem1.Specialty;

import problem1.Interfaces.Fees;
import problem1.PropertySize;
/**
 * Plumbing is an object that contains the fees and price of the service. */
public class Plumbing extends Specialist implements Fees {
  /**
   *Constructor that creates a new plumbing service with the information about the property,
   * rates, and complexity for the plumbing services.
   * @param monthly If the service happens monthly.
   * @param address The address of the property.
   * @param previousServices How many times has the property been serviced before.
   * @param size The size of the property.
   * @param complex If the service is complex. */
  public Plumbing(boolean monthly, String address, int previousServices, PropertySize size,
      boolean complex, int employees) {
    super(monthly, address, previousServices, size, complex, employees);
  }
  /**
   * Returns the permit fee for service.
   * @return Returns the permit fee for service. */
  @Override
  public double fee() {
    int permitFee = 20;
    return permitFee;
  }
  /**
   * Returns the price of service based on the rate, number of employees and fee.
   * @return Returns the price of service based on the rate, number of employees and fee. */
  public double calculatePrice() {
    return ((rate() * super.getEmployees()) + fee());
  }
}
