package problem1;

/**
 * OneTime is an object that contains the amount of the donation. */
public class OneTime extends AbstractDonations {

  /**
   * Constructor that creates a donation with the amount and todays date.
   * @param amount The amount. */
  public OneTime(double amount) {
    super(amount);
  }

  /**
   * Returns a string of the donation amount.
   * @return Returns a string of the donation amount. */
  @Override
  public String toString() {
    return super.toString() + " Creation Date: " + getCreationDate() + ".";
  }
}
