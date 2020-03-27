package problem2;
/**
 * A Set is a collection of items without containing duplicate elements.
 */
public interface ISet {
  /**
   * Creates and returns an empty Set.
   * @return An empty Set. */
  Set emptySet();
  /**
   * Checks if the Set is empty.
   * @return True if the Set contains no items, false otherwise. */
  boolean isEmpty();
  /**
   * Adds the given Integer to the Set if and only if that Integer is not already in the Set.
   * @param n A new integer that isn't currently in the set.
   * @return A new set with the new integer. */
  Set add(Integer n);
  /**
   * Checks in the set contains a specific integer.
   * @param n An integer to be checked if it is in the set.
   * @return True if the given Integer is in the Set, false otherwise. */
  boolean contains(Integer n);
  /**
   * Returns a copy of the Set with the given Integer removed. If the given Integer is not
   * in the Set, returns the Set as is.
   * @param n An integer to be removed from the set.
   * @return A copy of the Set without the given Integer. */
  Set remove(Integer n);
  /**
   * Gets the number of items in the Set.
   * @return The size of the Set. */
  Integer size();
}
