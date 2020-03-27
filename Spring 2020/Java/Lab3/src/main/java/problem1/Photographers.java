package problem1;

public class Photographers extends AbstractFineArts implements Award {

  public Photographers(String name, int age, String[] genres, String[] awards,
      String[] exhibits) throws IllegalArgumentException {
    super(name, age, genres, awards, exhibits);
  }

  @Override
  public AbstractArtist receiveAward(String award) {
    String newArray [] = increaseAwardSize(award);
    return new Photographers(name, age, genres, newArray, exhibits);
  }
}
