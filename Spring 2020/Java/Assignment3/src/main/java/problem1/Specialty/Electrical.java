package problem1.Specialty;

import problem1.Interfaces.Fees;
import problem1.PropertySize;
/**
 * Electrical is an object that contains the fees, maximum number of employees, and price of
 * the service. */
public class Electrical extends Specialist implements Fees {
  /**
   * Constructor that creates a new electrical service with the information about the property,
   * rates, complexity, and number of employees for the electrical services.
   * @param monthly If the service happens monthly.
   * @param address The address of the property.
   * @param previousServices How many times has the property been serviced before.
   * @param size The size of the property.
   * @param complex If the service is complex. */
  public Electrical(boolean monthly, String address, int previousServices, PropertySize size,
      boolean complex, int employees) throws IllegalArgumentException {
    super(monthly, address, previousServices, size, complex, employees);
    if (setMinimumEmployees(size, employees) > 4) {
      System.out.println("Got here, why isn't it working?");
      throw new IllegalArgumentException();
    }
  }
  /**
   * Returns the permit fee for electrical services.
   * @return Returns the permit fee for electrical services. */
  @Override
  public double fee() {
    int permitFee = 50;
    return permitFee;
  }
  /**
   * Returns the price of service based on the rate, number of employees and fee.
   * @return Returns the price of service based on the rate, number of employees and fee. */
  public double calculatePrice() {
    return ((rate() * super.getEmployees()) + fee());
  }
}
