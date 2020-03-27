package problem2;

import java.util.Objects;

/**
 * BagOfWords is an object that contains words. */
public class BagOfWords implements IBagOfWords {
  private String word;
  private IBagOfWords rest;
  private Integer size = 0;
  private int count = 0;

  /**
   * Constructor that creates a new bag of words if there is only one word.
   * @param word The first word in the bag of words. */
  public BagOfWords(String word) {
    this.word = word;
    this.rest = new EmptyBagOfWords();
  }
  /**
   * Constructor that creates a new bag of words.
   * @param word The first word in the bag of words.
   * @param rest The rest of the words. */
  public BagOfWords(String word, IBagOfWords rest) {
    this.word = word;
    this.rest = rest;
  }

  /**
   * Returns the first word within the bag of words.
   * @return Returns the first word within the bag of words. */
  public String getWord() {
    return this.word;
  }

  /**
   * Returns the rest of the bag of words.
   * @return Returns the rest of the bag of words. */
  public IBagOfWords getRest() {
    return this.rest;
  }

  /**
   * Returns an empty Bag of Words.
   * @return Returns an empty Bag of Words. */
  @Override
  public IBagOfWords emptyBagOfWords() {
    return new EmptyBagOfWords();
  }

  /**
   * Return true if the bag of words is empty, false otherwise.
   * @return Return true if the bag of words is empty, false otherwise. */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Returns the size of the bag of words.
   * @return Returns the size of the bag of words. */
  @Override
  public Integer size() {
    return 1 + rest.size();
  }

  /**
   * Adds a new string to the bag of words regardless if it is a duplicate.
   * @param s A new string.
   * @return The bag of words with the additional string. */
  @Override
  public BagOfWords add(String s) {
    return new BagOfWords(s, this);
  }

  /**
   * Returns true if the bag of words contains that specific string, false otherwise.
   * @param s The string being searched for.
   * @return Returns true if the bag of words contains that specific string, false otherwise. */
  @Override
  public Boolean contains(String s) {
    if (word == s) {
      return true;
    } else {
      return rest.contains(s);
    }
  }

  /**
   * Checks to make sure the current object contains all of the same words as the other bag.
   * @param bagToCompare The object being compared.
   * @return True or false. */
  public Boolean containsAll(IBagOfWords bagToCompare) {
    int sizeThis = this.size();
    if (sizeThis == count) {
      return true;
    } else if (bagToCompare.getWord() == null) {
      return false;
    } else if (this.contains(bagToCompare.getWord())) {
      count += 1;
      return containsAll(bagToCompare.getRest());
    } else {
      return containsAll(bagToCompare.getRest());
    }
  }

  /**
   * Returns true if the current object is equal to the one being compared.
   * @param o The object being compared.
   * @return True or false. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BagOfWords that = (BagOfWords) o;
//    if (that.size() != ((BagOfWords) o).size()) {
//      return false;
//    }
    return (Objects.equals(word, that.word) &&
        Objects.equals(rest, that.rest) || (that.containsAll(((BagOfWords) o))));
  }

  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false. */
  @Override
  public int hashCode() {
    return Objects.hash(word, rest, size);
  }

  /**
   * Returns a string explaining the words that are in the bag of words.
   * @return Returns a string explaining the words that are in the bag of words. */
  @Override
  public String toString() {
    return "Bag of Words: Word is " + word + ", and Rest is: " + rest + '.';
  }
}
