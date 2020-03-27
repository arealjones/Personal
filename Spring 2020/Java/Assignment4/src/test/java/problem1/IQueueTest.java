package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IQueueTest {
  IQueue queue;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void enqueue() throws EmptyQueueException {
    queue.enqueue(12);
    queue.enqueue(71);
    queue.enqueue(0);
    assertEquals(12, queue.front(), 0.001);
    assertNotEquals(0, queue.front(), 0.001);
  }

  @Test
  public void dequeue() throws EmptyQueueException {
    queue.enqueue(12);
    queue.enqueue(71);
    queue.enqueue(0);
    queue.dequeue();
    assertEquals(71, queue.front(), 0.001);
    assertNotEquals(0, queue.front(), 0.001);
  }

  @Test (expected = EmptyQueueException.class)
  public void emptyDequeue() throws EmptyQueueException {
    queue.dequeue();
  }

  @Test
  public void front() throws EmptyQueueException {
    queue.enqueue(12);
    queue.enqueue(71);
    queue.enqueue(0);
    assertEquals(12, queue.front(), 0.001);
    queue.front();
    assertNotEquals(71, queue.front(), 0.001);
  }

  @Test (expected = EmptyQueueException.class)
  public void emptyFront() throws EmptyQueueException {
    queue.front();
  }

  @Test
  public void size() {
    queue.enqueue(12);
    queue.enqueue(71);
    queue.enqueue(0);
    assertEquals(3, queue.size(), 0.001);
    assertNotEquals(2, queue.size(), 0.001);
  }
}