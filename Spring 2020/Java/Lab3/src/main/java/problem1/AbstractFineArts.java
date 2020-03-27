package problem1;

import problem1.AbstractArtist;

public abstract class AbstractFineArts extends AbstractArtist {
  protected String[] exhibits;

  public AbstractFineArts(String name, int age, String[] genres, String[] awards, String[] exhibits)
      throws IllegalArgumentException {
    super(name, age, genres, awards);
    this.exhibits = exhibits;
  }

  public String[] getExhibits() {
    return exhibits;
  }

  public void setExhibits(String[] exhibits) {
    this.exhibits = exhibits;
  }
}
