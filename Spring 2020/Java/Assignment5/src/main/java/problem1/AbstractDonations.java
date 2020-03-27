package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * AbstractDonations is an object that contains the information about the donation. */
public abstract class AbstractDonations {
  private double amount;
  protected LocalDate creationDate;
  protected LocalDate donationDate;
  protected LocalDate cancellationDate;

  /**
   * Constructor that creates a donation with the amount and todays date. This is for onetime
   * payments or if they do not provide a donation date.
   * @param amount The amount donated. */
  public AbstractDonations(double amount) {
    this.amount = setAmount(amount);
    this.creationDate = creationDate.now();
  }

  /**
   * Constructor that creates a donation with the amount and creation date that they provided.
   * @param amount The amount donated.
   * @param creationDate The creation date that they provided. */
  public AbstractDonations(double amount, LocalDate creationDate) {
    this.amount = setAmount(amount);
    this.creationDate = setCreationDate(creationDate);
    this.cancellationDate = null;
  }

  /**
   * Constructor that creates a donation with the amount, creation date, and donation date that
   * they provided.
   * @param amount The amount donated.
   * @param creationDate The creation date that they provided.
   * @param donationDate The donation date that they provided. */
  public AbstractDonations(double amount, LocalDate creationDate, LocalDate donationDate) {
    this.amount = setAmount(amount);
    this.creationDate = setCreationDate(creationDate);
    this.donationDate = setDonationDate(donationDate);
    this.cancellationDate = null;
  }

  /**
   * Returns the donation date.
   * @return Returns the donation date. */
  public LocalDate getDonationDate() {
    return this.donationDate;
  }

  /**
   * Sets the initial donation date.
   * @param donationDate The donation date.
   * @return The field with the date as a Local Date. */
  private LocalDate setDonationDate(LocalDate donationDate) {
    return this.donationDate = donationDate;
  }

  /**
   * Returns the cancellation date.
   * @return Returns the cancellation date. */
  public LocalDate getCancellationDate() {
    return this.cancellationDate;
  }

  /**
   * Allows the user to set the cancellation date.
   * @param cancellationDate The cancellation date.
   * @throws IllegalArgumentException Throws if the cancellation date is in the past. */
  public void setCancellationDate(LocalDate cancellationDate) throws IllegalArgumentException {
    if (!checkInPast(cancellationDate)) {
      this.cancellationDate = cancellationDate;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Returns the amount donated.
   * @return Returns the amount donated. */
  public double getAmount() {
    return this.amount;
  }

  /**
   * Checks if the amount is a negative number and then sets it.
   * @param amount The amount donated.
   * @return The field with the amount.
   * @throws IllegalArgumentException Throws if the amount is negative. */
  private double setAmount(double amount) throws IllegalArgumentException {
    if (amount < 0) {
      throw new IllegalArgumentException();
    }
    return this.amount = amount;
  }

  /**
   * Returns the creation date.
   * @return Returns the creation date. */
  public LocalDate getCreationDate() {
    return this.creationDate;
  }

  /**
   * Allows the user to set a future creation date when they first set the donation.
   * @param creationDate The creation date.
   * @return The field with the date as a Local Date. */
  private LocalDate setCreationDate(LocalDate creationDate) {
    if (creationDate.isBefore(LocalDate.now())) {
      return this.creationDate = creationDate.now();
    } else {
      return this.creationDate = creationDate;
    }
  }

  /**
   * Checks if the date provided is before the creation date or before today.
   * @param date The date being checked.
   * @return True or false. */
  public boolean checkInPast(LocalDate date) {
    if (date.isBefore(getCreationDate()) || date.isBefore(LocalDate.now())) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Allows the user to change the donation date.
   * @param newDate The new date.
   * @return The field with the date as a Local Date. */
  public LocalDate changeDonationDate(LocalDate newDate) {
    return this.donationDate = newDate;
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
    AbstractDonations that = (AbstractDonations) o;
    return Double.compare(that.amount, amount) == 0 &&
        Objects.equals(creationDate, that.creationDate) &&
        Objects.equals(donationDate, that.donationDate) &&
        Objects.equals(cancellationDate, that.cancellationDate);
  }

  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false. */
  @Override
  public int hashCode() {
    return Objects.hash(amount, creationDate, donationDate, cancellationDate);
  }

  /**
   * Returns a string of the donation amount.
   * @return Returns a string of the donation amount. */
  @Override
  public String toString() {
    return "Donation Amount: $" +  amount + '.';
  }
}
