package problem1;

import problem1.AbstractArtist;

public abstract class AbstractPerformance extends AbstractArtist {
  protected String[] movies;
  protected String[] series;
  protected String[] otherMultimedia;

  public AbstractPerformance(String name, int age, String[] genres, String[] awards, String[] movies, String[] series, String[] otherMultimedia)
      throws IllegalArgumentException {
    super(name, age, genres, awards);
    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }

  public String[] getMovies() {
    return movies;
  }

  public void setMovies(String[] movies) {
    this.movies = movies;
  }

  public String[] getSeries() {
    return series;
  }

  public void setSeries(String[] series) {
    this.series = series;
  }

  public String[] getOtherMultimedia() {
    return otherMultimedia;
  }

  public void setOtherMultimedia(String[] otherMultimedia) {
    this.otherMultimedia = otherMultimedia;
  }
}
