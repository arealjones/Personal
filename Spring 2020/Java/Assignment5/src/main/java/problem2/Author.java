package problem2;

/**
 * Author is an object that contains the first and last name of the author. */
public class Author extends AbstractCreator {

  /**
   * Constructor that creates an author with a first and last name.
   * @param firstName The first name.
   * @param lastName The last name. */
  public Author(String firstName, String lastName) {
    super(firstName, lastName);
  }
}
