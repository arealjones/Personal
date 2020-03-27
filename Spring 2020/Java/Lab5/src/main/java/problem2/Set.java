package problem2;

public class Set implements ISet {
  private Integer first;
  private Set rest;

  public Set(Integer first, Set rest) {
    this.first = first;
    this.rest = rest;
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
    if (first.equals(null)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Adds an integer to the set and returns it.
   * @param n A new integer.
   * @return Returns a new set. */
  @Override
  public Set add(Integer n) {
    if ((first == n) || (rest.contains(n))) {
      return this;
    } else {
    return new Set(n, this.rest);
    }
  }

  /**
   * Returns true if the set contains the integer, false otherwise.
   * @param n The integer.
   * @return Returns true if the set contains the integer, false otherwise. */
  @Override
  public Boolean contains(Integer n) {
    if (first.equals(n)) {
      return true;
    } else {
      return rest.contains(n);
    }
  }

  /**
   * Removes an integer to the set and returns it.
   * @param n An integer.
   * @return Returns a new set. */
  @Override
  public Set remove(Integer n) {
    if (first == n) {
      return new Set(rest.first, rest.rest);
    } else {
      return rest.remove(n);
    }
  }

  /**
   * Returns the size of the set.
   * @return Returns the size of the set. */
  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }
}
