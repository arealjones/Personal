package problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MusicTest {
  AbstractCreator blink182;
  List<AbstractCreator> blink182Members;
  AbstractCreator markHoppus;
  AbstractCreator travisBarker;
  AbstractCreator mattSkiba;
  AbstractCreator beyonce;
  AbstractItems carousel;
  AbstractItems runTheWorld;
  AbstractItems sameRunTheWorld;
  String name;

  @Before
  public void setUp() throws Exception {
    markHoppus = new RecordingArtist("Mark", "Hoppus");
    travisBarker = new RecordingArtist("Travis", "Barker");
    mattSkiba = new RecordingArtist("Matt", "Skiba");
    blink182Members = new ArrayList<>();
    blink182Members.add(markHoppus);
    blink182Members.add(travisBarker);
    blink182Members.add(mattSkiba);
    blink182 = new Band("Blink 182", blink182Members);
    beyonce = new RecordingArtist("Beyonce", "Knowles");
    carousel = new Music(blink182, "Carousel", 1994);
    runTheWorld = new Music(beyonce, "Run the World", 2011);
    sameRunTheWorld = new Music(beyonce, "Run the World", 2011);
    name = "Wrong";
  }

  @Test
  public void getCreator() {
    assertEquals("Beyonce", runTheWorld.getCreator().getFirstName());
    assertEquals("Knowles", runTheWorld.getCreator().getLastName());
    assertEquals("Blink 182", carousel.getCreator().getBandName());
  }

  @Test
  public void getTitle() {
    assertEquals("Run the World", runTheWorld.getTitle());
    assertEquals("Carousel", carousel.getTitle());
  }

  @Test
  public void getReleaseOrPublishedYear() {
    assertEquals(2011, runTheWorld.getReleaseOrPublishedYear());
    assertEquals(1994, carousel.getReleaseOrPublishedYear());
  }

  @Test
  public void testEquals() {
    assertTrue(travisBarker.equals(travisBarker));
    assertNotEquals(null, travisBarker);
    assertFalse(carousel.equals(name));
    assertTrue(runTheWorld.equals(sameRunTheWorld));
    assertFalse(mattSkiba.equals(markHoppus));
    assertFalse(carousel.equals(runTheWorld));
  }

  @Test
  public void testHashCode() {
    assertTrue(runTheWorld.hashCode() == sameRunTheWorld.hashCode());
    assertFalse(runTheWorld.hashCode() == carousel.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Items: Band: Blink 182. Title: Carousel, "
        + "and Release or Published Year: 1994.", carousel.toString());
    assertEquals("Items: Creator: Beyonce Knowles. Title: Run the World, "
        + "and Release or Published Year: 2011.", runTheWorld.toString());
  }
}