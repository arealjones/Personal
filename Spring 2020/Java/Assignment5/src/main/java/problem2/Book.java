package problem2;

/**
 * Book is an object that contains the creator, the title, and the release or date of
 * publication. */
public class Book extends AbstractItems {

  /**
   * Constructor that creates an item of music with the information about the creator,
   * title, and release or published year.
   * @param creator The creator of the book.
   * @param title The title of the book.
   * @param releaseOrPublishedYear The release or publication date. */
  public Book(AbstractCreator creator, String title, int releaseOrPublishedYear) {
    super(creator, title, releaseOrPublishedYear);
  }
}
