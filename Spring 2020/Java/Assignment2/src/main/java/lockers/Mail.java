package lockers;
/**
 * Mail is an object that contains the dimensions of what it can fit inside as well as the
 * recipient it is for. */
public class Mail extends Recipient {
  private int width;
  private int height;
  private int depth;
  /**
   * Constructor that creates a new piece of mail with specific dimensions for a recipient.
   * @param firstName The first name of the recipient.
   * @param lastName The last name of the recipient.
   * @param email The email of the recipient.
   * @param width The width of the piece of mail.
   * @param height The height of the piece of mail.
   * @param depth The depth of the piece of mail.
   * @throws InvalidSizeException A string stating the size is invalid. */
  public Mail(String firstName, String lastName, String email, int width, int height, int depth)
      throws InvalidSizeException {
    super(firstName, lastName, email);
    invalidSize(width);
    invalidSize(height);
    invalidSize(depth);
    this.width = width;
    this.height = height;
    this.depth = depth;
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
   * Sets the width of the mail if it is valid. Throws an exception otherwise.
   * @param width The width of the mail.
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
   * Returns the width of the mail.
   * @return Returns the width of the mail. */
  public int getWidth() {
    return width;
  }
  /**
   * Sets the height of the mail if it is valid. Throws an exception otherwise.
   * @param height The height of the mail.
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
   * Returns the height of the mail.
   * @return Returns the height of the mail. */
  public int getHeight() {
    return height;
  }
  /**
   * Sets the depth of the mail if it is valid. Throws an exception otherwise.
   * @param depth The depth of the mail.
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
   * Returns the depth of the mail.
   * @return Returns the depth of the mail. */
  public int getDepth() {
    return depth;
  }
}
