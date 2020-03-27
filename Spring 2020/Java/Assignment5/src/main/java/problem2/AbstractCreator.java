package problem2;

import java.util.List;
import java.util.Objects;

/**
 * AbstractCreator is an object that contains the information about the creator of the item. */
public abstract class AbstractCreator {
  private String firstName;
  private String lastName;
  private String bandName;
  private List<AbstractCreator> artists;

  /**
   * Constructor that creates a creator with the information about the author of a book or a
   * recording artist.
   * @param firstName The first name of the author.
   * @param lastName The last name of the author. */
  public AbstractCreator(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Constructor that creates a creator with the information about the band.
   * @param bandName The band name.
   * @param artists The artists within the band. */
  public AbstractCreator(String bandName, List<AbstractCreator> artists) {
    this.bandName = bandName;
    this.artists = artists;
  }

  /**
   * Returns the first name of the creator.
   * @return Returns the first name of the creator. */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Returns the last name of the creator.
   * @return Returns the last name of the creator. */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Returns the name of the band.
   * @return Returns the name of the band. */
  public String getBandName() {
    return this.bandName;
  }

  /**
   * Checks if the recording artist is in the band.
   * @param recordingArtist An artist.
   * @return True if the artist is in the band, false otherwise. */
  public boolean bandContainsArtist(AbstractCreator recordingArtist) {
    for (int i=0; i<artists.size(); i++) {
      if (artists.get(i).equals(recordingArtist)) {
        return true;
      }
    }
    return false;
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
    AbstractCreator that = (AbstractCreator) o;
    return Objects.equals(firstName, that.firstName) &&
        Objects.equals(lastName, that.lastName) &&
        Objects.equals(bandName, that.bandName) &&
        Objects.equals(artists, that.artists);
  }

  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false. */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, bandName, artists);
  }

  /**
   * Returns a string of the creators name.
   * @return Returns a string of the creators name. */
  @Override
  public String toString() {
    return "Creator: " + firstName + ' ' + lastName + '.';
  }
}
