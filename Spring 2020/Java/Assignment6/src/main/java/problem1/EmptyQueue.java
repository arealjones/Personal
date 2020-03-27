package problem1;

import java.util.NoSuchElementException;

/**
 * EmptyQueue is a class for when the priority queue is empty. */
public class EmptyQueue implements IPriorityQueue {

  /**
   * Creates an empty priority queue. */
  public EmptyQueue() {
  }

  /**
   * Returns the priority for the value.
   * @return Returns the priority for the value. */
  @Override
  public Integer getPriority() {
    return null;
  }

  /**
   * Returns the value.
   * @return Returns the value. */
  @Override
  public String getValue() {
    return null;
  }

  /**
   * Returns the rest of the priority list.
   * @return Returns the rest of the priority list. */
  @Override
  public IPriorityQueue getRest() {
    return null;
  }

  /**
   * Returns an empty priority queue.
   * @return Returns an empty priority queue. */
  @Override
  public IPriorityQueue createEmpty() {
    return new EmptyQueue();
  }

  /**
   * Returns true if the PQ is empty, false otherwise.
   * @return Returns true if the PQ is empty, false otherwise. */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Returns the PQ with the value and priority added.
   * @param priority The priority of the value.
   * @param value The value to be added.
   * @return Returns the PQ with the value and priority added. */
  @Override
  public IPriorityQueue add(Integer priority, String value) {
    return new PriorityQueue(priority, value, this);
  }

  /**
   * Returns value with the highest priority.
   * @return Returns value with the highest priority.
   * @throws IllegalArgumentException Throws if the PQ is empty. */
  @Override
  public String peek() throws NoSuchElementException {
    throw new NoSuchElementException();
  }

  /**
   * Returns a copy of the PQ without the element that has the highest priority.
   * @return Returns a copy of the PQ without the element that has the highest priority.
   * @throws IllegalArgumentException Throws if the PQ is empty. */
  @Override
  public PriorityQueue pop() throws NoSuchElementException {
    throw new NoSuchElementException();
  }

  /**
   * Returns the hashcode for the empty queue. I picked a random number.
   * @return Returns the hashcode for the empty queue. */
  @Override
  public int hashCode() {
    return 12;
  }

  /**
   * Checks if two queues are equal to one another. Returns false if they are not.
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
   * Returns a string indicating what is in the empty queue. It should always be null.
   * @return Returns a string indicating what is in the empty queue. */
  @Override
  public String toString() {
    return "Empty Queue: null.";
  }
}
