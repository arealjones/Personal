package problem2;

public class Empty implements ISet {

  public Empty() {
  }

  /**
   * Returns a new empty set.
   * @return Returns a new empty set. */
  @Override
  public Set emptySet() {
    return new Set(null, null);
  }

  /**
   * Returns true if the set is empty, false otherwise.
   * @return Returns true if the set is empty, false otherwise. */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Adds an integer to the set and returns it.
   * @param n A new integer.
   * @return Returns a new set. */
  @Override
  public Set add(Integer n) {
    return new Set(n, null);
  }

  /**
   * Returns true if the set contains the integer, false otherwise.
   * @param n The integer.
   * @return Returns true if the set contains the integer, false otherwise. */
  @Override
  public Boolean contains(Integer n) {
    return false;
  }

  /**
   * Removes an integer to the set and returns it.
   * @param n An integer.
   * @return Returns a new set. */
  @Override
  public Set remove(Integer n) {
    return new Set(null, null);
  }

  /**
   * Returns the size of the set.
   * @return Returns the size of the set. */
  @Override
  public Integer size() {
    return 0;
  }
}
