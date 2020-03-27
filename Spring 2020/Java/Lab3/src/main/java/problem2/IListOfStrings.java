package problem2;

public interface IListOfStrings {
  /**
   * Checks whether or not the list is empty.
   * @return True or false.
   */
  boolean isEmpty();
  /**
   * Gets the total number of elements in the list.
   * @return The total number of elements in the list.
   */
  int size();
  /**
   * Consumes a String, and checks if the String is in the list or not.
   * @param item A string.
   * @return True or false.
   */
  boolean contains(String item);
  /**
   * Consumes another list of Strings, and checks that all elements
   * of this list are in the list passed as argument.
   * @param newList Another list of Strings.
   * @return True or false.
   */
  boolean containsAll(String newList[]);
  /**
   * Takes the maximum String length, and returns a list with all elements whose length
   * is greater than the maximum length removed.
   * @return A list with all elements whose length is greater than the maximum length.
   */
  String[] filterLargerThan();
  /**
   * Check if the list has at least one duplicate element.
   * @return True or false.
   */
  boolean hasDuplicates();
  /**
   * Returns the list with all duplicates removed.
   * @return The list without any duplicates.
   */
  String [] removeDuplicates();


}
