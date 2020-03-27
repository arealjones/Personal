package problem1;

public class Poet extends AbstractArtist implements Award {
  private String publishingCompany;
  private String collection;

  public Poet(String name, int age, String[] genres, String[] awards, String publishingCompany, String collection)
      throws IllegalArgumentException {
    super(name, age, genres, awards);
    this.publishingCompany = publishingCompany;
    this.collection = collection;
  }

  public String getPublishingCompany() {
    return publishingCompany;
  }

  public void setPublishingCompany(String publishingCompany) {
    this.publishingCompany = publishingCompany;
  }

  public String getCollection() {
    return collection;
  }

  public void setCollection(String collection) {
    this.collection = collection;
  }

  @Override
  public AbstractArtist receiveAward(String award) {
    String newArray [] = increaseAwardSize(award);
    return new Poet(name, age, genres, newArray, publishingCompany, collection);
  }
}
