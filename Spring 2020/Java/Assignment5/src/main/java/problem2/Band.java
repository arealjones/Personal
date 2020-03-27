package problem2;

import java.util.List;

/**
 * Band is an object that contains the name of the band and the artists in the band. */
public class Band extends AbstractCreator {

  /**
   * Constructor that creates a band with a name and the artists in it.
   * @param bandName The band name.
   * @param artists The artists in the band. */
  public Band(String bandName, List<AbstractCreator> artists) {
    super(bandName, artists);
  }

  /**
   * Returns a string of the creators name.
   *
   * @return Returns a string of the creators name.
   */
  @Override
  public String toString() {
    return "Band: " + getBandName() + '.';
  }
}
