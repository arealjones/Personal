package problem2;

public interface ISet {

  /**
   * Returns a new empty set.
   * @return Returns a new empty set. */
  Set emptySet();

  /**
   * Returns true if the set is empty, false otherwise.
   * @return Returns true if the set is empty, false otherwise. */
  Boolean isEmpty();

  /**
   * Adds an integer to the set and returns it.
   * @param n A new integer.
   * @return Returns a new set. */
  Set add(Integer n);

  /**
   * Returns true if the set contains the integer, false otherwise.
   * @param n The integer.
   * @return Returns true if the set contains the integer, false otherwise. */
  Boolean contains(Integer n);

  /**
   * Removes an integer to the set and returns it.
   * @param n An integer.
   * @return Returns a new set. */
  Set remove(Integer n);

  /**
   * Returns the size of the set.
   * @return Returns the size of the set. */
  Integer size();
}
