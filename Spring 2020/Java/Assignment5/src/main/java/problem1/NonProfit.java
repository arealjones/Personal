package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * NonProfit is an object that contains the organization and a list of the donations made
 * to them in a given year. */
public class NonProfit {
  private String orgName;
  private List<AbstractDonations> donations;

  /**
   * Constructor that creates a nonprofit org with an empty list if they do not have any
   * donations yet.
   * @param orgName The organizations name. */
  public NonProfit(String orgName) {
    this.orgName = orgName;
    this.donations = new ArrayList<>();
  }

  /**
   * Constructor that creates a nonprofit org with a filled list of donations already made.
   * @param orgName The organizations name.
   * @param donations The list of donations already made to them. */
  public NonProfit(String orgName, List<AbstractDonations> donations) {
    this.orgName = orgName;
    this.donations = donations;
  }

  /**
   * Returns the list of donations made.
   * @return Returns the list of donations made. */
  public List<AbstractDonations> getDonations() {
    return this.donations;
  }

  /**
   * Returns the organizations name.
   * @return Returns the organizations name. */
  public String getOrgName() {
    return this.orgName;
  }

  /**
   * Adds a donation to the list of donations.
   * @param donation Adds a donation to the list of donations. */
  public void addDonation(AbstractDonations donation) {
    donations.add(donation);
  }

  /**
   * Goes through the list and calculates the total of one time payments made to the org in a
   * specific year.
   * @param year The year in question.
   * @return A sum of the one time payments made. */
  private int calculateOneTime(int year) {
    int sum = 0;
    for (int i=0; i<donations.size(); i++) {
      if (donations.get(i) instanceof OneTime &&
          donations.get(i).getCreationDate().getYear() == year) {
          sum += donations.get(i).getAmount();
      }
    }
    return sum;
  }

  /**
   * Goes through the list and calculates the total of monthly payments made to the org in a
   * specific year.
   * @param year The year in question.
   * @return A sum of the one time payments made. */
  private int calculateMonthly(int year) {
    int sum = 0;
    for (int i=0; i<donations.size(); i++) {
      if (donations.get(i) instanceof Monthly &&
          donations.get(i).getDonationDate().getYear() == year) {
        if ((donations.get(i).getCancellationDate() == null) ||
            (donations.get(i).getCancellationDate().getYear() > year)) {
          int months = 12 - (donations.get(i).getDonationDate().getMonth().getValue() - 1);
          sum += months * donations.get(i).getAmount();
        } else {
          int months = donations.get(i).getCancellationDate().getMonth().getValue() -
              donations.get(i).getDonationDate().getMonth().getValue();
          sum += months * donations.get(i).getAmount();
        }
      }
    }
    return sum;
  }

  /**
   * Goes through the list and calculates the total of pledge payments made to the org in a
   * specific year.
   * @param year The year in question.
   * @return A sum of the one time payments made. */
  private int calculatePledges(int year) {
    int sum = 0;
    for (int i=0; i<donations.size(); i++) {
      if (donations.get(i) instanceof Pledges) {
        if (donations.get(i).getDonationDate() == null) {
          return sum;
        } else if (donations.get(i).getDonationDate().getYear() == year) {
          sum += donations.get(i).getAmount();
        }
      }
    }
    return sum;
  }

  /**
   * Returns the total amount of donations made to the org in a specific year.
   * @param year The year in question.
   * @return A sum of the one time payments made. */
  public int getTotalDonationsForYear(int year) {
    int sum = 0;
    if (!donations.isEmpty()) {
      sum += calculateOneTime(year);
      sum += calculateMonthly(year);
      sum += calculatePledges(year);
    }
    return sum;
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
    NonProfit nonProfit = (NonProfit) o;
    return Objects.equals(orgName, nonProfit.orgName) &&
        Objects.equals(donations, nonProfit.donations);
  }

  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false. */
  @Override
  public int hashCode() {
    return Objects.hash(orgName, donations);
  }

  /**
   * Returns a string of the organization and the total amount of donations made in a year.
   * @param year The year in question.
   * @return Returns a string of the organization and the total amount of
   * donations made in a year. */
  public String toString(int year) {
    return "NonProfit Organization: " + orgName +
        ". Total donations made in a given year: $" + getTotalDonationsForYear(year) + '.';
  }
}
