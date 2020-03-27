package problem2;

import java.util.Objects;

/**
 * AbstractItems is an object that contains the information about the item in the collection. */
public abstract class AbstractItems {
  private AbstractCreator creator;
  private String title;
  private int releaseOrPublishedYear;

  /**
   * Constructor that creates an item with the information about the creator, title, and release
   * or published year.
   * @param creator The creator of the item.
   * @param title The title of the item.
   * @param releaseOrPublishedYear the year it was released or published. */
  public AbstractItems(AbstractCreator creator, String title, int releaseOrPublishedYear) {
    this.creator = creator;
    this.title = title;
    this.releaseOrPublishedYear = setReleaseOrPublishedYear(releaseOrPublishedYear);
  }
  /**
   * Returns the creator of the item.
   * @return Returns the creator of the item. */
  public AbstractCreator getCreator() {
    return this.creator;
  }

  /**
   * Returns the title of the item.
   * @return Returns the title of the item. */
  public String getTitle() {
    return this.title;
  }

  /**
   * Returns the year the item was released or published.
   * @return Returns the year the item was released or published. */
  public int getReleaseOrPublishedYear() {
    return this.releaseOrPublishedYear;
  }

  /**
   * Sets the release or publication date of the item.
   * @param releaseOrPublishedYear A year.
   * @return The year in the constructor.
   * @throws IllegalArgumentException if the year is a negative number. */
  private int setReleaseOrPublishedYear(int releaseOrPublishedYear) throws IllegalArgumentException {
    if (releaseOrPublishedYear < 0) {
      throw new IllegalArgumentException();
    } else {
      return this.releaseOrPublishedYear = releaseOrPublishedYear;
    }
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
    AbstractItems that = (AbstractItems) o;
    return releaseOrPublishedYear == that.releaseOrPublishedYear &&
        Objects.equals(creator, that.creator) &&
        Objects.equals(title, that.title);
  }

  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false. */
  @Override
  public int hashCode() {
    return Objects.hash(creator, title, releaseOrPublishedYear);
  }

  /**
   * Returns a string of the items creator, title and release year.
   * @return Returns a string of the creators name. */
  @Override
  public String toString() {
    return "Items: " + creator + " Title: " + title + ", and Release or Published Year: " +
        releaseOrPublishedYear + '.';
  }
}
