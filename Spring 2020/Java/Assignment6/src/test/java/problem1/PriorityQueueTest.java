package problem1;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
  PriorityQueue filled;
  PriorityQueue duplicate1;
  PriorityQueue duplicate2;
  EmptyQueue empty;
  EmptyQueue emptyTwo;
  PriorityQueue sameFilled;
  String number;


  @Before
  public void setUp() throws Exception {
    filled = new PriorityQueue(4, "Four");
    filled = filled.add(2, "Two");
    filled = filled.add(7, "Seven");
    filled = filled.add(6, "Six");
    duplicate1 = new PriorityQueue(4, "Four");
    duplicate2 = new PriorityQueue(4, "Four");
    empty = new EmptyQueue();
    emptyTwo = new EmptyQueue();
    sameFilled = new PriorityQueue(4, "Four");
    number = "Four";
  }

  @Test
  public void createEmpty() {
    assertNull(filled.createEmpty().getPriority());
    assertNull(filled.createEmpty().getValue());
    assertNull(filled.createEmpty().getRest());
    assertNull(empty.createEmpty().getPriority());
    assertNull(empty.createEmpty().getValue());
    assertNull(empty.createEmpty().getRest());
  }

  @Test
  public void isEmpty() {
    assertFalse(filled.isEmpty());
    assertTrue(empty.isEmpty());
  }

  @Test
  public void add() {
    sameFilled = sameFilled.add(2, "Two");
    assertEquals("PriorityQueue: Priority is 4, Value is: Four, and Rest is: "
            + "PriorityQueue: Priority is 2, Value is: Two, and Rest is: Empty Queue: null...",
        sameFilled.toString());
    sameFilled = sameFilled.add(7, "Seven");
    assertEquals("PriorityQueue: Priority is 7, Value is: Seven, and Rest is: "
            + "PriorityQueue: Priority is 4, Value is: Four, and Rest is: "
            + "PriorityQueue: Priority is 2, Value is: Two, and Rest is: Empty Queue: null....",
        sameFilled.toString());
    sameFilled = sameFilled.add(6, "Six");
    assertEquals("PriorityQueue: Priority is 7, Value is: Seven, and Rest is: "
            + "PriorityQueue: Priority is 6, Value is: Six, and Rest is: PriorityQueue: "
            + "Priority is 4, Value is: Four, and Rest is: PriorityQueue: Priority is 2, "
            + "Value is: Two, and Rest is: Empty Queue: null.....",
        sameFilled.toString());
  }

  @Test
  public void peek() {
    filled = filled.add(2, "Two");
    filled = filled.add(7, "Seven");
    filled = filled.add(6, "Six");
    assertEquals("Seven", filled.peek());
    sameFilled = sameFilled.add(2, "Two");
    sameFilled = sameFilled.add(7, "Seven");
    assertEquals("Seven", sameFilled.peek());
  }

  @Test (expected = NoSuchElementException.class)
  public void emptyPeek() throws NoSuchElementException {
    empty.peek();
  }

  @Test
  public void pop() {
    filled = filled.add(2, "Two");
    filled = filled.add(7, "Seven");
    filled = filled.add(6, "Six");
    assertEquals("Seven", filled.peek());
    filled = filled.pop();
    assertEquals("Six", filled.peek());
  }

  @Test (expected = NoSuchElementException.class)
  public void emptyPop() throws NoSuchElementException {
    empty.pop();
  }

  @Test
  public void getPriority() {
    assertEquals(7.0, filled.getPriority(), 0.001);
    assertEquals(null, empty.getPriority());
  }

  @Test
  public void getValue() {
    assertEquals("Seven", filled.getValue());
    assertEquals(null, empty.getValue());
  }

  @Test
  public void getRest() {
    assertEquals("PriorityQueue: Priority is 6, Value is: Six, and Rest is: "
        + "PriorityQueue: Priority is 4, Value is: Four, and Rest is: "
        + "PriorityQueue: Priority is 2, Value is: Two, and Rest is: Empty Queue: null....",
        filled.getRest().toString());
    assertEquals(null, empty.getRest());
  }

  @Test
  public void testEquals() {
    assertTrue(filled.equals(filled));
    assertNotEquals(null, filled);
    assertFalse(filled.equals(empty));
    assertTrue(duplicate1.equals(duplicate2));
    assertTrue(empty.equals(emptyTwo));
    assertTrue(empty.equals(empty));
  }

  @Test
  public void testHashCode() {
    assertTrue(duplicate1.hashCode() == duplicate2.hashCode());
    assertFalse(filled.hashCode() == empty.hashCode());
    assertEquals(12, empty.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("PriorityQueue: Priority is 7, Value is: Seven, and Rest is: "
        + "PriorityQueue: Priority is 6, Value is: Six, and Rest is: "
        + "PriorityQueue: Priority is 4, Value is: Four, and Rest is: "
        + "PriorityQueue: Priority is 2, Value is: Two, and Rest is: Empty Queue: null.....",
        filled.toString());
    assertEquals("Empty Queue: null.", empty.toString());
  }
}