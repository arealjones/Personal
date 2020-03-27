package lockers;
/**
 * Recipient is my super object of a person that contains their first name, last name, and email
 * address. The mail object extends from this one. */
public class Recipient {
  private String firstName;
  private String lastName;
  private String email;
  /**
   * Constructor that creates a new recipient with the persons first name, last name and email.
   * @param firstName The first name of the recipient.
   * @param lastName The last name of the recipient.
   * @param email The email of the recipient. */
  public Recipient(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
  /**
   * Sets the first name of the recipient.
   * @param firstName Sets the first name of the recipient. */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  /**
   * Returns the first name of the recipient.
   * @return Returns the first name of the recipient. */
  public String getFirstName() {
    return firstName;
  }
  /**
   * Sets the last name of the recipient.
   * @param lastName Sets the last name of the recipient. */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  /**
   * Returns the last name of the recipient.
   * @return Returns the last name of the recipient. */
  public String getLastName() {
    return lastName;
  }
  /**
   * Sets the email of the recipient.
   * @param email Sets the email of the recipient. */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * Returns the email of the recipient.
   * @return Returns the email of the recipient. */
  public String getEmail() {
    return email;
  }
}
