import static org.junit.Assert.*;

import javafx.geometry.Pos;
import org.junit.Before;
import org.junit.Test;

public class PosnTest {
  Posn firstX;
  Posn firstY;
  Posn firstZ;
  Posn firstA;

  @Before
  public void setUp() throws Exception {
    firstX = new Posn(1, 1);
    firstY = new Posn(1, 1);
    firstZ = new Posn(1, 1);
    firstA = new Posn(3, 3);

  }

  @Test
  public void testEquals() {
    assertTrue(firstX.equals(firstX));
    assertTrue(firstX.equals(firstY) && firstY.equals((firstX)));
    assertTrue(firstX.equals(firstY) && firstY.equals(firstZ) && firstX.equals(firstZ));
    assertFalse(firstX.equals(null));
  }

  @Test
  public void testHashCode() {
    assertTrue(firstX.equals(firstY) && firstY.equals((firstX)));
    assertTrue(firstX.hashCode() == firstX.hashCode());
    assertTrue(firstX.equals(firstY) && (firstX.hashCode() == firstY.hashCode()));
    assertFalse(firstX.equals(firstA) && firstX.hashCode() == firstA.hashCode());
  }
}