package lockers;
/**
 * Locker is an object that contains the dimensions of what it can fit and any mail that may be in
 * it. */
public class Locker {
  private int width;
  private int height;
  private int depth;
  private Mail mail;
  /**
   * Constructor that creates a new locker with specific dimensions and a place for mail to go.
   * @param width The width of the locker.
   * @param height The height of the locker.
   * @param depth The depth of the locker.
   * @param mail Space for the mail to go.
   * @throws InvalidSizeException A string stating the size is invalid. */
  public Locker(int width, int height, int depth, Mail mail) throws InvalidSizeException {
    invalidSize(width);
    invalidSize(height);
    invalidSize(depth);
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.mail = mail;
  }
  /**
   * Checks the size of any side of the piece of mail.
   * @param size Is the width, height, or depth that will be inputted.
   * @return True if it is greater than or equal to one, false otherwise. */
  private boolean checkSize(int size) {
    int minSize = 1;
    return minSize <= size;
  }
  /**
   * Checks the size and if it is an invalid number, it will throw an exception.
   * @param size Is the width, height, or depth that will be inputted.
   * @throws InvalidSizeException A string stating the size is invalid. */
  public void invalidSize(int size) throws InvalidSizeException {
    if (!checkSize(size)) {
      throw new InvalidSizeException();
    }
  }
  /**
   * Sets the width of the locker if it is valid. Throws an exception otherwise.
   * @param width The width of the locker.
   * @throws InvalidSizeException A string stating the size is invalid. */
  public void setWidth(int width) throws InvalidSizeException {
    if (checkSize(width)) {
      this.width = width;
    }
    else {
      throw new InvalidSizeException();
    }
  }
  /**
   * Returns the width of the locker.
   * @return Returns the width of the locker. */
  public int getWidth() {
    return width;
  }
  /**
   * Sets the height of the locker if it is valid. Throws an exception otherwise.
   * @param height The height of the locker.
   * @throws InvalidSizeException A string stating the size is invalid. */
  public void setHeight(int height) throws InvalidSizeException {
    if (checkSize(height)) {
      this.height = height;
    }
    else {
      throw new InvalidSizeException();
    }
  }
  /**
   * Returns the height of the locker.
   * @return Returns the height of the locker. */
  public int getHeight() {
    return height;
  }
  /**
   * Sets the depth of the locker if it is valid. Throws an exception otherwise.
   * @param depth The depth of the locker.
   * @throws InvalidSizeException A string stating the size is invalid. */
  public void setDepth(int depth) throws InvalidSizeException {
    if (checkSize(depth)) {
      this.depth = depth;
    }
    else {
      throw new InvalidSizeException();
    }
  }
  /**
   * Returns the depth of the locker.
   * @return Returns the depth of the locker. */
  public int getDepth() {
    return depth;
  }
  /**
   * Checks to make sure the mail will fit before it is added to the locker.
   * @param mail A mail object that will possibly go into the locker.
   * @return True if it will fit, false otherwise. */
  private boolean mailFits(Mail mail) {
    return (mail.getWidth() <= width &&
        mail.getHeight() <= height &&
        mail.getDepth() <= depth);
  }
  /**
   * Returns the piece of mail if there is any in the locker.
   * @return A mail object. */
  public Mail getMail() {
    return mail;
  }
  /**
   * Checks to see if the locker is empty before any mail is added.
   * @return True if it is empty, false otherwise. */
  private boolean lockerEmpty() {
    return this.mail == null;
  }
  /**
   * Adds mail to a locker if it is empty and if the mail will fit. Throws an exception otherwise.
   * @param newMail A mail object that we are trying to put in the locker.
   * @throws LockerException A string stating the locker is full or the mail will not fit. */
  public void addMail(Mail newMail) throws LockerException {
    if (lockerEmpty() &&
        mailFits(newMail)) {
      this.mail = newMail;
    }
    else {
      throw new LockerException();
    }
  }
  /**
   * Checks to see if the mail in the locker matches the recipient trying to take it out.
   * @param person A recipient object who is trying to take the mail out of the locker.
   * @return True if the person matches the mail in the locker. False otherwise. */
  private boolean mailMatchesPerson(Recipient person) {
    return (this.mail.getFirstName() == person.getFirstName() &&
        this.mail.getLastName() == person.getLastName() &&
        this.mail.getEmail() == person.getEmail());
  }
  /**
   * Returns the mail for the recipient if their information matches what is on the mail and if
   * the locker actually contains something.
   * @param person A recipient object who is trying to take the mail out of the locker.
   * @return Returns the mail if it belongs to the recipient.
   * @throws IncorrectRecipientException A string stating the person trying to take the mail out is
   * incorrect. */
  public Mail pickupMail(Recipient person) throws IncorrectRecipientException {
    if (!lockerEmpty() &&
        mailMatchesPerson(person)) {
      Mail tempMail = mail;
      this.mail = null;
      return tempMail;
    }
    else {
      throw new IncorrectRecipientException();
    }
  }
}