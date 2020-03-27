package problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CatalogTest {
  int wrong;
  // Catalogs
  Catalog empty;
  Catalog filled;
  List<AbstractItems> filledItems;
  Catalog sameEmpty;
  // Bands
  AbstractCreator blink182;
  List<AbstractCreator> blink182Members;
  AbstractCreator markHoppus;
  AbstractCreator travisBarker;
  AbstractCreator mattSkiba;
  AbstractCreator badBadHats;
  List<AbstractCreator> badBadHatsMembers;
  AbstractCreator kerryAlexander;
  AbstractCreator chrisHoge;
  AbstractCreator connorDavison;
  // Artists
  AbstractCreator beyonce;
  AbstractItems carousel;
  AbstractItems superAmerica;
  AbstractItems runTheWorld;
  AbstractCreator madonna;
  AbstractCreator dolly;
  AbstractItems likeAVirgin;
  AbstractItems nineToFive;
  AbstractItems carryIt;
  // Authors
  AbstractCreator michelle;
  AbstractItems becoming;
  AbstractCreator stephen;
  AbstractItems institute;
  AbstractCreator nicholas;
  AbstractItems longestRide;
  AbstractCreator tara;
  AbstractItems educated;

  @Before
  public void setUp() throws Exception {
    // Bands
    markHoppus = new RecordingArtist("Mark", "Hoppus");
    travisBarker = new RecordingArtist("Travis", "Barker");
    mattSkiba = new RecordingArtist("Matt", "Skiba");
    blink182Members = new ArrayList<>();
    blink182Members.add(markHoppus);
    blink182Members.add(travisBarker);
    blink182Members.add(mattSkiba);
    blink182 = new Band("Blink 182", blink182Members);
    kerryAlexander = new RecordingArtist("Kerry", "Alexander");
    chrisHoge = new RecordingArtist("Chris", "Hoge");
    connorDavison = new RecordingArtist("Connor", "Davison");
    badBadHatsMembers = new ArrayList<>();
    badBadHatsMembers.add(kerryAlexander);
    badBadHatsMembers.add(chrisHoge);
    badBadHatsMembers.add(connorDavison);
    badBadHats = new Band("Bad Bad Hats", badBadHatsMembers);
    // Artists
    beyonce = new RecordingArtist("Beyonce", "Knowles");
    carousel = new Music(blink182, "Carousel", 1994);
    superAmerica = new Music(badBadHats, "Super America", 2013);
    runTheWorld = new Music(beyonce, "Run the World", 2011);
    madonna = new RecordingArtist("Madonna", "Ciccone");
    dolly = new RecordingArtist("Dolly", "Parton");
    likeAVirgin = new Music(madonna, "Like a Virgin", 1984);
    nineToFive = new Music(dolly, "Nine to Five", 1980);
    carryIt = new Music(travisBarker, "Carry It", 2010);
    // Authors
    michelle = new Author("Michelle", "Obama");
    stephen = new Author("Stephen", "King");
    nicholas = new Author("Nicholas", "Sparks");
    tara = new Author("Tara", "Westover");
    becoming = new Book(michelle, "Becoming", 2018);
    institute = new Book(stephen, "Institute", 2019);
    longestRide = new Book(nicholas, "Longest Ride", 2013);
    educated = new Book(tara, "Educated", 2018);
    // Catalogs
    filledItems = new ArrayList<>();
    filledItems.add(becoming);
    filledItems.add(institute);
    filledItems.add(carousel);
    filledItems.add(runTheWorld);
    filledItems.add(longestRide);
    filledItems.add(educated);
    filledItems.add(likeAVirgin);
    filledItems.add(nineToFive);
    filledItems.add(superAmerica);
    filledItems.add(carryIt);
    empty = new Catalog();
    filled = new Catalog(filledItems);
    sameEmpty = new Catalog();
    wrong = 0;

  }

  @Test
  public void search() {
    assertEquals(Arrays.asList(carousel, educated, likeAVirgin, superAmerica, carryIt),
        filled.search("a"));
    assertEquals(Arrays.asList(carousel, educated, likeAVirgin, superAmerica, carryIt),
        filled.search("A"));
    assertEquals(Arrays.asList(likeAVirgin), filled.search("like"));
    assertEquals(Arrays.asList(becoming, institute, likeAVirgin, nineToFive),
        filled.search("in"));
  }

  @Test
  public void testAuthorSearch() {
    assertEquals(Arrays.asList(becoming), filled.search((Author) michelle));
    assertEquals(Arrays.asList(educated), filled.search((Author) tara));
  }

  @Test
  public void testArtistSearch() {
    assertEquals(Arrays.asList(carousel, carryIt), filled.search((RecordingArtist) travisBarker));
    assertEquals(Arrays.asList(runTheWorld), filled.search((RecordingArtist) beyonce));
  }

  @Test
  public void addItem() {
    empty.addItem(becoming);
    assertEquals(Arrays.asList(becoming), empty.search("becoming"));
    empty.addItem(institute);
    assertEquals(Arrays.asList(institute), empty.search("institute"));
  }

  @Test
  public void removeItem() {
    filledItems.remove(nineToFive);
    assertEquals(Arrays.asList(becoming, institute, likeAVirgin),
        filled.search("in"));
    filledItems.remove(likeAVirgin);
    assertEquals(Arrays.asList(becoming, institute), filled.search("in"));
  }

  @Test (expected = IllegalArgumentException.class)
  public void incorrectRemove() {
    empty.removeItem(superAmerica);
  }

  @Test
  public void testEquals() {
    assertTrue(filled.equals(filled));
    assertNotEquals(null, filled);
    assertFalse(filled.equals(wrong));
    assertTrue(empty.equals(sameEmpty));
    assertFalse(empty.equals(filled));
  }

  @Test
  public void testHashCode() {
    assertTrue(empty.hashCode() == sameEmpty.hashCode());
    assertFalse(empty.hashCode() == filled.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Collection Contains: 0 items.", empty.toString());
    assertEquals("Collection Contains: 10 items.", filled.toString());
  }
}