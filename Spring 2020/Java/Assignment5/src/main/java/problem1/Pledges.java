package problem1;

import java.time.LocalDate;

/**
 * Pledges is an object that contains the amount of the donation for a future date. */
public class Pledges extends AbstractDonations {

  /**
   * Constructor that creates a donation with the amount and a donation date.
   * @param amount The amount to be donated.
   * @param donationDate The provided donation date. */
  public Pledges(double amount, LocalDate donationDate) {
    super(amount, donationDate);
    this.creationDate = LocalDate.now();
    this.donationDate = setDonationDate(donationDate);
  }

  /**
   * Constructor that creates a donation with the amount, creation date, and donation date.
   * @param amount The amount to be donated.
   * @param creationDate The provided creation date.
   * @param donationDate The provided donation date. */
  public Pledges(double amount, LocalDate creationDate, LocalDate donationDate) {
    super(amount, creationDate, donationDate);
    this.donationDate = setDonationDate(donationDate);
  }

  /**
   * Constructor that creates a donation with just the amount. They can set the donation date
   * later.
   * @param amount The amount to be donated. */
  public Pledges(double amount) {
    super(amount);
    this.donationDate = null;
  }

  /**
   * An overridden check in past method to catch if the date is the creation date.
   * @param date The date being checked.
   * @return True or false. */
  private boolean checkDate(LocalDate date) {
    if (date.isBefore(getCreationDate()) || date.isBefore(LocalDate.now()) ||
        date.equals(getCreationDate())) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Overrides the setDonationDate method to check if it was in the past with the overridden
   * CheckinPast method.
   * @param donationDate The donation date.
   * @return The field updated with the new date.
   * @throws IllegalArgumentException Throws if it is in the past. */
  private LocalDate setDonationDate(LocalDate donationDate) throws IllegalArgumentException {
    if (checkInPast(donationDate)) {
      throw new IllegalArgumentException();
    } else {
      return this.donationDate = donationDate;
    }
  }

  /**
   * Overrides the changeDonationDate method to check if it null as well as check if it is in
   * the past with the overridden CheckinPast method.
   * @param newDate The new date.
   * @return The field updated with the new date.
   * @throws IllegalArgumentException Throws if it is in the past. */
  @Override
  public LocalDate changeDonationDate(LocalDate newDate) throws IllegalArgumentException {
    if (donationDate == null) {
      return this.donationDate = newDate;
    }
    else if (!checkInPast(newDate) && (!LocalDate.now().equals(donationDate))) {
      return this.donationDate = newDate;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Returns a string of the donation amount.
   * @return Returns a string of the donation amount. */
  @Override
  public String toString() {
    if (getDonationDate() == null) {
      return super.toString() + " Creation Date: " + getCreationDate() +
          ", and Donation Date: NA.";
    }
    return super.toString() + " Creation Date: " + getCreationDate() +
        ", and Donation Date: " + getDonationDate() + ".";
  }
}
