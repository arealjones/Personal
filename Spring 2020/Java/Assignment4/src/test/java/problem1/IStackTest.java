package problem1;

import static org.junit.Assert.*;

import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

public class IStackTest {
  IStackTest stack;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void push() {
    stack.push(12);
    assertEquals(12, stack.top(), 0.001);
    stack.push(45);
    assertNotEquals(12, stack.top(), 0.001);
  }

  @Test
  public void pop() {
    stack.push(23);
    stack.push(79);
    stack.push(-1);
    assertEquals(-1, stack.top(), 0.001);
    assertEquals(-1, stack.pop(), 0.001);
    assertEquals(79, stack.top(), 0.001);
    assertNotEquals(23, stack.top(), 0.001);
  }

  @Test (expected = EmptyStackException.class)
  public void emptyPop() throws EmptyStackException {
    stack.pop();
  }

  @Test
  public void top() {
    stack.push(54);
    stack.push(121);
    stack.push(34);
    assertEquals(34, stack.top(), 0.001);
    assertNotEquals(54, stack.top(), 0.001);
  }

  @Test (expected = EmptyStackException.class)
  public void emptyTop() throws EmptyStackException {
    stack.top();
  }

  @Test
  public void isEmpty() {
    assertEquals(true, stack.isEmpty());
  }

  @Test
  public void notEmpty() {
    stack.push(11);
    assertEquals(false, stack.isEmpty());
  }
}