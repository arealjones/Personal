package problem2;

import java.util.Objects;
/**
 * A Set will allow you to create an empty set, check if it is empty, add, remove, as well as check
 * the size and if it contains anything. */
public class Set implements ISet {
  private Integer[] elements;
  private int size;
  /**
   * A constructor to build an empty set of integers. */
  public Set() {
    this.elements = null;
    this.size = 0;
  }
  /**
   * A constructor to build a set with known elements and a size.
   * @param elements The elements to be added to the set.
   * @param size The size of the set. */
  public Set(Integer[] elements, int size) {
    this.elements = elements;
    this.size = size;
  }
  /**
   * Creates and returns an empty Set.
   * @return An empty Set. */
  @Override
  public Set emptySet() {
    return new Set();
  }
  /**
   * Checks if the Set is empty.
   * @return True if the Set contains no items, false otherwise. */
  @Override
  public boolean isEmpty() {
    if (elements == null) {
      return true;
    }
    return false;
  }
  /**
   * Adds the given Integer to the Set if and only if that Integer is not already in the Set.
   * @param n A new integer that isn't currently in the set.
   * @return A new set with the new integer. */
  @Override
  public Set add(Integer n) {
    if (!isEmpty()) {
      if (!contains(n)) {
        Integer[] temp = this.elements;
        this.elements = new Integer[this.size + 1];
        for (int i=0; i<this.elements.length; i++) {
          if ((this.elements.length - 1) == i) {
            elements[i] = n;
          } else {
            elements[i] = temp[i];
          }
        }
        this.size += 1;
        return new Set(this.elements, this.size);
      }
      return new Set(this.elements, this.size);
    } else {
      this.elements = new Integer[this.size + 1];
      this.size += 1;
      for (int i=0; i<this.elements.length; i++) {
        elements[i] = n;
      }
      return new Set(this.elements, this.size);
    }
  }
  /**
   * Checks in the set contains a specific integer.
   * @return True if the given Integer is in the Set, false otherwise. */
  @Override
  public boolean contains(Integer n) {
    if (!isEmpty()) {
      for (int i=0; i<elements.length; i++) {
        if ((elements[i].compareTo(n)) == 0) {
          return true;
        }
      }
    }
    return false;
  }
  /**
   * Returns a copy of the Set with the given Integer removed. If the given Integer is not in the
   * Set, returns the Set as is.
   * @param n An integer to be removed from the set.
   * @return A copy of the Set without the given Integer. */
  @Override
  public Set remove(Integer n) {
    if (!isEmpty()) {
      if (contains(n)) {
        Integer[] removeTemp = this.elements;
        this.elements = new Integer[this.size - 1];
        int elementIndex = 0;
        for (int i=0; i<removeTemp.length; i++) {
          if ((removeTemp[i].compareTo(n) == -1) || (removeTemp[i].compareTo(n) == 1)) {
            elements[elementIndex] = removeTemp[i];
            elementIndex += 1;
          }
        }
        this.size -= 1;
        return new Set(this.elements, this.size);
      } else {
        return this;
      }
    } else {
      return new Set();
    }
  }
  /**
   * Gets the number of items in the Set.
   * @return The size of the Set. */
  @Override
  public Integer size() {
    Integer count = 0;
    if (elements != null) {
      for (int i=0; i<elements.length; i++) {
        if ((elements[i] >= 0) || (elements[i] < 0)) {
          count += 1;
        } else {
          continue;
        }
      }
    }
    this.size = count;
    return count;
  }
  /**
   * Returns true or false based on if the current set is the same size and has the same elements
   * as the one being compared.
   * @param o The set being compared.
   * @return Returns true or false. */
  @Override
  public boolean equals(Object o) {
    Set oSet = (Set) o;
    int count = 0;
    if (this.isEmpty() && oSet.isEmpty()) {
      return true;
    } else {
      if (this.size() == oSet.size()) {
        for (Integer element : this.elements) {
          if (oSet.contains(element)) {
            count += 1;
          }
        }
      } else {
        return false;
      }
    }
    return count == this.size();
  }
  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false. */
  @Override
  public int hashCode() {
    int primeNum = 31;
    int result = Objects.hash(size);
    if (isEmpty()) {
      return result;
    } else {
    result = primeNum * result + elements.hashCode();
    return result;
    }
  }
  /**
   * Returns the elements of a set as a string. This is a helper method for the toString method.
   * @return A string of the elements. */
  private String convertSetToString() {
    String string = "";
    if (isEmpty()) {
      return "None";
    } else {
      for (int i=0; i<elements.length; i++) {
        string += elements[i].toString();
        string += " ";
      }
      return string;
    }
  }
  /**
   * Returns a string of the size and elements that are in a set.
   * @return A string of the set. */
  @Override
  public String toString() {
    return "The set is " + size() + " elements long and has the following elements in it: (" +
        convertSetToString() + ").";
  }
}
