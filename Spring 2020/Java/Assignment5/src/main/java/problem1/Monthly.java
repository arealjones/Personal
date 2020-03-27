package problem1;

import java.time.LocalDate;

/**
 * Monthly is an object that contains the amount of the donation and the donation date for each
 * month. */
public class Monthly extends AbstractDonations {

  /**
   * Constructor that creates a donation with the amount and a donation date.
   * @param amount The amount to be donated.
   * @param donationDate The provided donation date. */
  public Monthly(double amount, LocalDate donationDate) {
    super(amount, donationDate);
    this.donationDate = setDonationDate(donationDate);
  }

  /**
   * Constructor that creates a donation with the amount, creation date, and donation date.
   * @param amount The amount to be donated.
   * @param creationDate The provided creation date.
   * @param donationDate The provided donation date. */
  public Monthly(double amount, LocalDate creationDate, LocalDate donationDate) {
    super(amount, creationDate, donationDate);
    this.donationDate = setDonationDate(donationDate);
  }


  /**
   * Overridden set donation date to check if the donation is psat the creation date or todays
   * date.
   * @param donationDate The donation date.
   * @return The field with the updated donation date.
   * @throws IllegalArgumentException Throws if the date is in the past. */
  private LocalDate setDonationDate(LocalDate donationDate) throws IllegalArgumentException {
    if (!checkInPast(donationDate)) {
      return this.donationDate = donationDate;
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public String toString() {
    if (getCancellationDate() == null) {
      return super.toString() + " Creation Date: " + getCreationDate() +
          ", Donation Date: " + getDonationDate() +
          ", and Cancellation Date: NA" + ".";
    }
    return super.toString() + " Creation Date: " + getCreationDate() +
        ", Donation Date: " + getDonationDate() +
        ", and Cancellation Date: " + getCancellationDate() + ".";
  }
}

