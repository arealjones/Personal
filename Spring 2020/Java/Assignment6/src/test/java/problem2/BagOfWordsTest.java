package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.PriorityQueue;

public class BagOfWordsTest {
  BagOfWords filled;
  BagOfWords sameWords;
  BagOfWords sameSize;
  BagOfWords duplicate1;
  BagOfWords duplicate2;
  IBagOfWords empty;
  BagOfWords sameFilled;
  String randomWord;

  @Before
  public void setUp() throws Exception {
    filled = new BagOfWords("Word");
    filled = filled.add("Sassy");
    filled = filled.add("Happy");
    filled = filled.add("Sassy");
    sameWords = new BagOfWords("Word");
    sameWords = sameWords.add("Sassy");
    sameWords = sameWords.add("Sassy");
    sameWords = sameWords.add("Happy");
    sameSize = new BagOfWords("Word");
    sameSize = sameSize.add("Sassy");
    sameSize = sameSize.add("Happy");
    sameSize = sameSize.add("Sad");
    duplicate1 = new BagOfWords("Wonderful");
    duplicate2 = new BagOfWords("Wonderful");
    empty = new EmptyBagOfWords();
    sameFilled = new BagOfWords("Word");
    randomWord = "Hello";
  }

  @Test
  public void emptyBagOfWords() {
    assertNull(filled.emptyBagOfWords().getWord());
    assertNull(filled.emptyBagOfWords().getRest());
    assertNull(empty.emptyBagOfWords().getWord());
    assertNull(empty.emptyBagOfWords().getRest());
  }

  @Test
  public void isEmpty() {
    assertFalse(filled.isEmpty());
    assertTrue(empty.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(4, filled.size(), 0.001);
    assertEquals(0, empty.size(), 0.001);
  }

  @Test
  public void add() {
    sameFilled = sameFilled.add("Dope");
    assertEquals("Bag of Words: Word is Dope, and Rest is: "
        + "Bag of Words: Word is Word, and Rest is: Empty Bag Of Words: null...",
        sameFilled.toString());
    sameFilled = sameFilled.add("Wonderful");
    assertEquals("Bag of Words: Word is Wonderful, and Rest is: "
            + "Bag of Words: Word is Dope, and Rest is: Bag of Words: Word is Word, and Rest is: "
            + "Empty Bag Of Words: null....", sameFilled.toString());
    empty = empty.add("Test");
    assertEquals("Bag of Words: Word is Test, and Rest is: Empty Bag Of Words: null..",
        empty.toString());

  }

  @Test
  public void contains() {
    assertTrue(filled.contains("Sassy"));
    assertFalse(filled.contains("Winner"));
    assertFalse(empty.contains("Winner"));
    assertTrue(filled.contains("Happy"));
  }

  @Test
  public void containsAll() {
    //assertTrue(filled.containsAll(sameWords));
    assertFalse(filled.containsAll(sameSize));
  }

  @Test
  public void testEquals() {
    assertTrue(filled.equals(filled));
    assertNotEquals(null, filled);
    assertFalse(filled.equals(empty));
    assertTrue(duplicate1.equals(duplicate2));
    assertTrue(empty.equals(empty));
    assertTrue(filled.equals(sameWords));
  }

  @Test
  public void testHashCode() {
    assertTrue(duplicate1.hashCode() == duplicate2.hashCode());
    assertFalse(filled.hashCode() == empty.hashCode());
    assertEquals(34, empty.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Bag of Words: Word is Sassy, and Rest is: "
        + "Bag of Words: Word is Happy, and Rest is: Bag of Words: Word is Sassy, and Rest is: "
        + "Bag of Words: Word is Word, and Rest is: Empty Bag Of Words: null.....",
        filled.toString());
    assertEquals("Empty Bag Of Words: null.", empty.toString());
  }

  @Test
  public void getWord() {
    assertEquals("Sassy", filled.getWord());
    assertEquals(null, empty.getWord());
  }

  @Test
  public void getRest() {
    assertEquals(new BagOfWords("Happy", new BagOfWords("Sassy",
        new BagOfWords("Word", new EmptyBagOfWords()))),
        filled.getRest());
    assertEquals(null, empty.getRest());
  }
}