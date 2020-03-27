package problem1;

/**
 * IPriorityQueue is the interface that holds all of the priority queue methods. */
public interface IPriorityQueue {

  /**
   * Returns the priority for the value.
   * @return Returns the priority for the value. */
  public Integer getPriority();

  /**
   * Returns the value.
   * @return Returns the value. */
  public String getValue();

  /**
   * Returns the rest of the priority list.
   * @return Returns the rest of the priority list. */
  public IPriorityQueue getRest();

  /**
   * Returns an empty priority queue.
   * @return Returns an empty priority queue. */
  IPriorityQueue createEmpty();

  /**
   * Returns true if the PQ is empty, false otherwise.
   * @return Returns true if the PQ is empty, false otherwise. */
  Boolean isEmpty();

  /**
   * Returns the PQ with the value and priority added.
   * @param priority The priority of the value.
   * @param value The value to be added.
   * @return Returns the PQ with the value and priority added.
   * @throws IllegalArgumentException Throws if the PQ is empty. */
  IPriorityQueue add(Integer priority, String value) throws IllegalArgumentException;

  /**
   * Returns value with the highest priority.
   * @return Returns value with the highest priority. */
  String peek();

  /**
   * Returns a copy of the PQ without the element that has the highest priority.
   * @return Returns a copy of the PQ without the element that has the highest priority.
   * @throws IllegalArgumentException Throws if the PQ is empty. */
  IPriorityQueue pop() throws IllegalArgumentException;
}
