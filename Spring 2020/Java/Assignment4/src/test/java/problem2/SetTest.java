package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetTest {
  Set newSet;
  Set nextSet;
  Integer[] numArray = {3, 4, 5, 6};
  int randomSize;
  Set withOutsideThings;

  @Before
  public void setUp() throws Exception {
    newSet = new Set();
    nextSet = new Set();
    randomSize = 4;
    withOutsideThings = new Set(numArray, randomSize);
  }

  @Test
  public void emptySet() {
    assertEquals(new Set(), newSet.emptySet());
    assertEquals(0, newSet.emptySet().size(), 0.001);
  }

  @Test
  public void isEmpty() {
    assertTrue(newSet.isEmpty());
    assertFalse(newSet.add(12).isEmpty());
  }

  @Test
  public void add() {
    newSet.add(4);
    assertEquals(false, newSet.isEmpty());
    assertEquals(true, newSet.contains(4));
    assertEquals(1, newSet.size(), 0.001);
    newSet.add(12);
    assertEquals(false, newSet.isEmpty());
    assertEquals(true, newSet.contains(12));
    assertEquals(2, newSet.size(), 0.001);
    newSet.add(4);
    assertEquals(false, newSet.isEmpty());
    assertEquals(true, newSet.contains(12));
    assertEquals(2, newSet.size(), 0.001);
    newSet.add(-1);
    assertEquals(false, newSet.isEmpty());
    assertEquals(true, newSet.contains(4));
    assertEquals(true, newSet.contains(12));
    assertEquals(true, newSet.contains(-1));
    assertEquals(3, newSet.size(), 0.001);
    newSet.add(0);
    assertEquals(false, newSet.isEmpty());
    assertEquals(true, newSet.contains(4));
    assertEquals(true, newSet.contains(12));
    assertEquals(true, newSet.contains(-1));
    assertEquals(true, newSet.contains(0));
    assertEquals(4, newSet.size(), 0.001);
  }

  @Test
  public void contains() {
    assertFalse(newSet.contains(10));
    newSet.add(4);
    newSet.add(11);
    newSet.add(99);
    assertTrue(newSet.contains(99));
    assertTrue(newSet.contains(11));
    assertFalse(newSet.contains(12));
    newSet.remove(99);
    assertFalse(newSet.contains(99));
  }

  @Test
  public void remove() {
    assertEquals(new Set(), newSet.remove(12));
    newSet.add(4);
    newSet.add(11);
    newSet.add(99);
    assertEquals(3, newSet.size(), 0.001);
    newSet.remove(11);
    assertEquals(2, newSet.size(), 0.001);
    assertTrue(newSet.contains(4));
    assertTrue(newSet.contains(99));
    assertFalse(newSet.contains(11));
    newSet.remove(34);
    assertEquals(2, newSet.size(), 0.001);
    assertTrue(newSet.contains(4));
    assertTrue(newSet.contains(99));
    assertFalse(newSet.contains(11));
    newSet.remove(4);
    assertEquals(1, newSet.size(), 0.001);
    assertTrue(newSet.contains(99));
    assertFalse(newSet.contains(11));
    assertFalse(newSet.contains(4));
  }

  @Test
  public void size() {
    assertEquals(0, newSet.size(), 0.001);
    newSet.add(4);
    newSet.add(26);
    newSet.add(1200);
    assertEquals(3, newSet.size(), 0.001);
    assertEquals(2, newSet.remove(1200).size(), 0.001);
    assertEquals(1, newSet.remove(26).size(), 0.001);
  }

  @Test
  public void testEquals() {
    assertTrue(newSet.equals(nextSet));
    assertFalse(newSet.equals(withOutsideThings));
    nextSet.add(4);
    nextSet.add(26);
    nextSet.add(1200);
    nextSet.add(6);
    assertFalse(nextSet.equals(withOutsideThings));
  }

  @Test
  public void testHashCode() {
    assertTrue(newSet.hashCode() == nextSet.hashCode());
    assertFalse(newSet.hashCode() == withOutsideThings.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("The set is 0 elements long and has the following "
        + "elements in it: (None).", newSet.toString());
    newSet.add(4);
    newSet.add(26);
    newSet.add(1200);
    assertEquals("The set is 3 elements long and has the following "
        + "elements in it: (4 26 1200 ).", newSet.toString());
  }
}