package problem2;

/**
 * EmptyBagOfWords is a class for when the bag of words is empty.
 */
public class EmptyBagOfWords implements IBagOfWords {

  /**
   * Creates an empty bag of words. */
  public EmptyBagOfWords() {
  }

  /**
   * Returns the first word.
   * @return Returns the first word. */
  @Override
  public String getWord() {
    return null;
  }

  /**
   * Returns the rest of the bag of words.
   * @return Returns the rest of the bag of words. */
  @Override
  public BagOfWords getRest() {
    return null;
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
    return true;
  }

  /**
   * Returns the size of the bag of words.
   * @return Returns the size of the bag of words. */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * Adds a new string to the bag of words regardless if it is a duplicate.
   * @param s A new string.
   * @return The bag of words with the additional string. */
  @Override
  public IBagOfWords add(String s) {
    return new BagOfWords(s, this);
  }

  /**
   * Returns true if the bag of words contains that specific string, false otherwise.
   * @param s The string being searched for.
   * @return Returns true if the bag of words contains that specific string, false otherwise. */
  @Override
  public Boolean contains(String s) {
    return false;
  }

  /**
   * Returns the hashcode for the empty bag of words. I picked a random number.
   * @return Returns the hashcode for the empty bag of words. */
  @Override
  public int hashCode() {
    return 34;
  }

  /**
   * Checks if two bag of words are equal to one another. Returns false if they are not.
   * @param obj The object being compared.
   * @return True or false. */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    else {
      return obj != null && getClass() == obj.getClass();
    }
  }

  /**
   * Returns a string indicating what is in the empty bag of words. It should always be null.
   * @return Returns a string indicating what is in the empty bag of words. */
  @Override
  public String toString() {
    return "Empty Bag Of Words: null.";
  }
}
