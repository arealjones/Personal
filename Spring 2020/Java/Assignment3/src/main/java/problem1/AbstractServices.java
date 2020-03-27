package problem1;

import java.util.Objects;
/**
 * AbstractServices is an object that contains the property information and if it is monthly
 * for the services. */
public abstract class AbstractServices {
  private boolean monthly;
  private String address;
  private int previousServices;
  /**
   * Constructor that creates a new service with the information about the property
   * and if it is monthly for the services.
   * @param monthly If the service happens monthly.
   * @param address The address of the property.
   * @param previousServices How many times has the property been serviced before. */
  public AbstractServices(boolean monthly, String address, int previousServices)
      throws IllegalArgumentException {
    setPreviousServices(previousServices);
    this.monthly = monthly;
    this.address = address;
    this.previousServices = previousServices;
  }
  /**
   * Returns true of false based on if the service is monthly.
   * @return Returns true or false. */
  public boolean isMonthly() {
    return this.monthly;
  }
  /**
   * Sets true of false based on if the service is monthly.
   * @param monthly Sets true or false based on if the service is monthly. */
  public void setMonthly(boolean monthly) {
    this.monthly = monthly;
  }
  /**
   * Returns the address of the property.
   * @return Returns the address of the property. */
  public String getAddress()  {
    return this.address;
  }
  /**
   * Sets the address of the property.
   * @param address Sets the address of the property. */
  public void setAddress(String address) {
    this.address = address;
  }
  /**
   * Sets the number of previous services. Throws an illegal argument exception if it is a negative
   * number.
   * @param previousServices The number of previous services.
   * @throws IllegalArgumentException If it is a negative number. */
  public void setPreviousServices(int previousServices) throws IllegalArgumentException {
    if (previousServices >= 0) {
      this.previousServices = previousServices;
    }
    else {
      throw new IllegalArgumentException();
    }
  }
  /**
   * Returns the amount of previous services the property has had.
   * @return Returns the amount of previous services the property has had. */
  public int getPreviousServices() {
    return this.previousServices;
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
    AbstractServices services = (AbstractServices) o;
    return monthly == services.monthly &&
        previousServices == services.previousServices &&
        address.equals(services.address);
  }
  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false. */
  @Override
  public int hashCode() {
    return Objects.hash(monthly, address, previousServices);
  }
  /**
   * Returns a string of the service including information about the property.
   * @return Returns a string of the service. */
  @Override
  public String toString() {
    return "The property at " + address +
        " has had " + previousServices + " services in the past. " +
        "Monthly Maintenance: " + monthly;
  }
}
