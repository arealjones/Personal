package problem2;

/**
 * Recording artist is an object that contains first and last name of the artist. */
public class RecordingArtist extends AbstractCreator {

  /**
   * Constructor that creates a recording artist with a first and last name.
   * @param firstName The first name.
   * @param lastName The last name. */
  public RecordingArtist(String firstName, String lastName) {
    super(firstName, lastName);
  }
}
