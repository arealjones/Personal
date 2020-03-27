package problem1;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * PriorityQueue is an object that contains values and their priorities. */
public class PriorityQueue implements IPriorityQueue {
  private Integer priority;
  private String value;
  private IPriorityQueue rest;

  /**
   * Constructor that creates a new priority queue if there is only one value.
   * @param priority The priority of the value.
   * @param value The first value in the queue. */
  public PriorityQueue(Integer priority, String value) {
    this.priority = priority;
    this.value = value;
    this.rest = new EmptyQueue();
  }
  /**
   * Constructor that creates a new priority queue with the priority of the first value, the value,
   * and the rest of the queue.
   * @param priority The priority of the first value.
   * @param value The first value in the queue.
   * @param rest The rest of the queue. */
  public PriorityQueue(Integer priority, String value, IPriorityQueue rest) {
    this.priority = priority;
    this.value = value;
    this.rest = rest;
  }

  /**
   * Returns the priority for the value.
   * @return Returns the priority for the value. */
  public Integer getPriority() {
    return this.priority;
  }

  /**
   * Returns the value.
   * @return Returns the value. */
  public String getValue() {
    return this.value;
  }

  /**
   * Returns the rest of the priority list.
   * @return Returns the rest of the priority list. */
  public IPriorityQueue getRest() {
    return this.rest;
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
    return false;
  }

  /**
   * Returns the PQ with the value and priority added.
   * @param priority The priority of the value.
   * @param value The value to be added.
   * @return Returns the PQ with the value and priority added. */
  @Override
  public PriorityQueue add(Integer priority, String value) {
    if (priority >= this.priority) {
      return new PriorityQueue(priority, value,
          new PriorityQueue(this.priority, this.value, this.rest));
    } else {
      return new PriorityQueue(this.priority, this.value, this.rest.add(priority, value));
    }
  }

  /**
   * Returns value with the highest priority. If there are multiple values with the same priority,
   * it will return the first one.
   * @return Returns value with the highest priority.
   * @throws IllegalArgumentException Throws if the PQ is empty. */
  @Override
  public String peek() throws NoSuchElementException {
    return this.value;
  }

  /**
   * Returns a copy of the PQ without the element that has the highest priority.
   * @return Returns a copy of the PQ without the element that has the highest priority.
   * @throws IllegalArgumentException Throws if the PQ is empty. */
  @Override
  public PriorityQueue pop() throws NoSuchElementException {
    this.rest = this.rest.getRest();
    return new PriorityQueue(this.rest.getPriority(), this.rest.getValue(), this.rest.getRest());
  }

  /**
   * Returns true if the current object is equal to the one being compared.
   * @param o The object being compared.
   * @return True or false. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriorityQueue that = (PriorityQueue) o;
    return Objects.equals(priority, that.priority) &&
        Objects.equals(value, that.value) &&
        Objects.equals(rest, that.rest);
  }

  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false. */
  @Override
  public int hashCode() {
    return Objects.hash(priority, value, rest);
  }

  /**
   * Returns a string explaining the value and their priority that are in the priority queue.
   * @return Returns a string explaining the value and their priority that are in the
   * priority queue. */
  @Override
  public String toString() {
    return "PriorityQueue: Priority is " + priority + ", Value is: " + value + ", and Rest is: " +
        rest + '.';
  }
}
