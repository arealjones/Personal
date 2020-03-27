package problem2;

/**
 * Music is an object that contains the creator, the title, and the release or date of
 * publication. */
public class Music extends AbstractItems {

  /**
   * Constructor that creates an item of music with the information about the creator,
   * title, and release or published year.
   * @param creator The creators name.
   * @param title The title of the music.
   * @param releaseOrPublishedYear The release or publication date. */
  public Music(AbstractCreator creator, String title, int releaseOrPublishedYear) {
    super(creator, title, releaseOrPublishedYear);
  }
}
