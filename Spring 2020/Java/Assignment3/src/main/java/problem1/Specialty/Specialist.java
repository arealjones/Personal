package problem1.Specialty;

import java.util.Objects;
import problem1.PropertySize;
import problem1.Interfaces.Rate;
import problem1.AbstractServices;
/**
 * Specialist is an object that contains the complexity, hours, rates, and minimum employees needed
 * for the electrical and plumbing services. */
public class Specialist extends AbstractServices implements Rate {
  private boolean complex;
  private int employees;
  /**
   * Constructor that creates a new specialist service with the information about the property,
   * rates, complexity, and number of employees for the electrical and plumbing services.
   * @param monthly If the service happens monthly.
   * @param address The address of the property.
   * @param previousServices How many times has the property been serviced before.
   * @param size The size of the property.
   * @param complex If the service is complex. */
  public Specialist(boolean monthly, String address, int previousServices, PropertySize size,
      boolean complex, int employees) {
    super(monthly, address, previousServices);
    this.complex = complex;
    this.employees = setMinimumEmployees(size, employees);
  }
  /**
   * Returns the rate of the service per employee.
   * @return Returns the rate of the service per employee. */
  @Override
  public int rate() {
    int ratePerEmployee = 200;
    return ratePerEmployee;
  }
  /**
   * Returns true or false for if the service is complex.
   * @return Returns true or false. */
  public boolean isComplex() {
    return this.complex;
  }
  /**
   * Sets the complexity of the service.
   * @param complex The complexity of the service. */
  public void setComplex(boolean complex) {
    this.complex = complex;
  }
  /**
   * A helper function to set the minimum number of employees if the work is complex.
   * @param size The size of the property.
   * @param employees The number of employees. */
  private void setComplexMinimum(PropertySize size, int employees) {
    int smallAndMedium = 2;
    int large = 3;
    switch (size) {
      case SMALL:
      case MEDIUM:
        if (employees < smallAndMedium) {
          this.employees = smallAndMedium;
        }
        else {
          this.employees = employees;
        }
        break;
      case LARGE:
        if (employees < large) {
          this.employees = large;
        }
        else {
          this.employees = employees;
        }
        break;
    }
  }
  /**
   * Sets the minimum amount of required employees based on the property size.
   * @param size The size of the property.
   * @return Returns the minimum amount of required employees. */
  public int setMinimumEmployees(PropertySize size, int employees) {
    int minimum = 1;
    if (complex) {
        setComplexMinimum(size, employees);
      }
    else {
      if (employees < 1) {
        return this.employees = minimum;
      }
      else {
        return this.employees = employees;
      }
    }
    return this.employees;
  }
  /**
   * Returns the amount of required employees.
   * @return Returns the amount of required employees. */
  public int getEmployees() {
    return this.employees;
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
    Specialist that = (Specialist) o;
    return complex == that.complex &&
        employees == that.employees;
  }
  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false. */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), complex, employees);
  }
  /**
   * Returns a string of the exterior service including how many hours it will take to complete.
   * @return Returns a string of the exterior service. */
  @Override
  public String toString() {
    return super.toString() + ". Complex Project: " + complex +
        ". Number of employees required: " + employees + ".";
  }
}
