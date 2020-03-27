package problem2;

/**
 * IBagOfWords is an interface that holds all of the methods for the BagOfWords. */
public interface IBagOfWords {

  /**
   * Returns the first word.
   * @return Returns the first word. */
  public String getWord();

  /**
   * Returns the rest of the bag of words.
   * @return Returns the rest of the bag of words. */
  public IBagOfWords getRest();

  /**
   * Returns an empty Bag of Words.
   * @return Returns an empty Bag of Words. */
  IBagOfWords emptyBagOfWords();

  /**
   * Return true if the bag of words is empty, false otherwise.
   * @return Return true if the bag of words is empty, false otherwise. */
  Boolean isEmpty();

  /**
   * Returns the size of the bag of words.
   * @return Returns the size of the bag of words. */
  Integer size();

  /**
   * Adds a new string to the bag of words regardless if it is a duplicate.
   * @param s A new string.
   * @return The bag of words with the additional string. */
  IBagOfWords add(String s);

  /**
   * Returns true if the bag of words contains that specific string, false otherwise.
   * @param s The string being searched for.
   * @return Returns true if the bag of words contains that specific string, false otherwise. */
  Boolean contains(String s);
}
