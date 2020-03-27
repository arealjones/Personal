package problem2;

public class LinkedListOfStrings implements IListOfStrings {
  private Node head;
  private int numNodes;

  public LinkedListOfStrings() {
    this.head = null;
    this.numNodes = 0;
  }

  public static LinkedListOfStrings createEmpty() {
    return new LinkedListOfStrings();
  }

  /**
   * Checks whether or not the list is empty.
   */
  @Override
  public boolean isEmpty() {
    return (numNodes > 0);
  }

  /**
   * Gets the total number of elements in the list.
   *
   * @return The total number of elements in the list.
   */
  @Override
  public int size() {
    return numNodes;
  }

  /**
   * Consumes a String, and checks if the String is in the list or not.
   *
   * @param item A string.
   * @return True or false.
   */
  @Override
  public boolean contains(String item) {
    Node currNode = this.head;
    while (currNode != null) {
      if (currNode.getItem().contains(item))
        return true;
    }
    return false;
  }

  /**
   * Consumes another list of Strings, and checks that all elements of this list are in the list
   * passed as argument.
   *
   * @param newList Another list of Strings.
   * @return True or false.
   */
  @Override
  public boolean containsAll(String[] newList) {
    Node currNode = this.head;
    int count = 0;
    for (int i=0; i<newList.length; i++) {
      if (currNode.getItem().contains(newList[i])) {
        count += 1;
      }
    }
    if (count == newList.length) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Takes the maximum String length, and returns a list with all elements whose length is greater
   * than the maximum length removed.
   * @return A list with all elements whose length is greater than the maximum length.
   */
  @Override
  public String[] filterLargerThan() {
    int maximumLength = 0;
    Node currNode = this.head;
    LinkedListOfStrings newList;
    newList.createEmpty();
    for (int i=0; i<size(); i++) {
      if (currNode.getItem().length() > maximumLength) {
        maximumLength = currNode.getItem().length();
        currNode = currNode.getNextNode();
      }
    }
    for (int i=0; i<size(); i++) {
      if (currNode.getItem().length() > maximumLength) {
        newList += currNode.getItem();
      }currNode.
    }
    return new String[0];
  }

  /**
   * Check if the list has at least one duplicate element.
   *
   * @return True or false.
   */
  @Override
  public boolean hasDuplicates() {
    return false;
  }

  /**
   * Returns the list with all duplicates removed.
   *
   * @return The list without any duplicates.
   */
  @Override
  public String[] removeDuplicates() {
    return new String[0];
  }
}
