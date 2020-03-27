package problem1;

public class FilmMakers extends AbstractPerformance implements Award {

  public FilmMakers(String name, int age, String[] genres, String[] awards,
      String[] movies, String[] series, String[] otherMultimedia) throws IllegalArgumentException {
    super(name, age, genres, awards, movies, series, otherMultimedia);
  }

  @Override
  public AbstractArtist receiveAward(String award) {
    String newArray [] = increaseAwardSize(award);
    return new FilmMakers(name, age, genres, newArray, movies, series, otherMultimedia);
  }
}
