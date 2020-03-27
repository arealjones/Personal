package problem1;

public abstract class AbstractArtist {
  protected String name;
  protected int age;
  protected String[] genres;
  protected String[] awards;

  public AbstractArtist(String name, int age, String[] genres, String[] awards) throws IllegalArgumentException {
    this.name = name;
    this.age = setAge(age);
    this.genres = genres;
    this.awards = awards;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public int setAge(int age) throws IllegalArgumentException {
    if ((age > 0) && (age < 128)) {
      return this.age = age;
    }
    else {
      throw new IllegalArgumentException();
    }
  }

  public String[] getGenres() {
    return genres;
  }

  public void setGenres(String[] genres) {
    this.genres = genres;
  }

  public String[] getAwards() {
    return awards;
  }

  public void setAwards(String[] awards) {
    this.awards = awards;
  }

  public int amountInArray() {
    int countOfAwards = 0;
    for (int i=0; i<awards.length; i++) {
      if (awards[0] != null) {
        countOfAwards += 1;
      }
      continue;
    }
    return countOfAwards;
  }

  public String [] increaseAwardSize(String award) {
    String [] newArr = new String[awards.length+1];
    for (int i=0; i<awards.length; i++) {
      newArr[i] = awards[i];
    }
    newArr[awards.length-1] = award;
    return newArr;
  }
}
