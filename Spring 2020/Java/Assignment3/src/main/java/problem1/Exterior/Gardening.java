package problem1.Exterior;

import problem1.Interfaces.Fees;
import problem1.PropertySize;
/**
 * Gardening is an object of an exterior service. It contains the fees, and price. */
public class Gardening extends Exterior implements Fees {

  /**
   * Constructor that creates a new gardening service with information about the property.
   * @param monthly If the service happens monthly.
   * @param address The address of the property.
   * @param previousServices How many times has the property been serviced before.
   * @param size The size of the property. */
  public Gardening(boolean monthly, String address, int previousServices, PropertySize size) {
    super(monthly, address, previousServices, size);
  }
  /**
   * Returns the fee for waste removal.
   * @return Returns the fee for waste removal. */
  @Override
  public double fee() {
    int wasteFee = 20;
    return wasteFee;
  }
  /**
   * Returns the price of the service based on the rate, fees, discounts, and number of hours it
   * took to finish.
   * @return Returns the price of the service. */
  public double calculatePrice() {
    return (((rate() * getHours()) + fee()) - (((rate() * getHours()) + fee()) * discount()));
  }
}
