package problem1;

public class Painters extends AbstractFineArts implements Award {

  public Painters(String name, int age, String[] genres, String[] awards,
      String[] exhibits) throws IllegalArgumentException {
    super(name, age, genres, awards, exhibits);
  }

  @Override
  public AbstractArtist receiveAward(String award) {
    String newArray [] = increaseAwardSize(award);
    return new Painters(name, age, genres, newArray, exhibits);
  }
}
