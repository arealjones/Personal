package problem1;

public class Musician extends AbstractArtist implements Award {
  private String recordingCompany;
  private String album;

  public Musician(String name, int age, String[] genres, String[] awards, String recordingCompany, String album)
      throws IllegalArgumentException {
    super(name, age, genres, awards);
    this.recordingCompany = recordingCompany;
    this.album = album;
  }

  public String getRecordingCompany() {
    return recordingCompany;
  }

  public void setRecordingCompany(String recordingCompany) {
    this.recordingCompany = recordingCompany;
  }

  public String getAlbum() {
    return album;
  }

  public void setAlbum(String album) {
    this.album = album;
  }

  @Override
  public AbstractArtist receiveAward(String award) {
    String newArray [] = increaseAwardSize(award);
    return new Musician(name, age, genres, newArray, recordingCompany, album);
  }
}
