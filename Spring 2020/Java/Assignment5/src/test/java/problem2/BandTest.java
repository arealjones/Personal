package problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import problem1.AbstractDonations;

public class BandTest {
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
  AbstractCreator sameKerry;
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
    kerryAlexander = new RecordingArtist("Kerry", "Alexander");
    chrisHoge = new RecordingArtist("Chris", "Hoge");
    connorDavison = new RecordingArtist("Connor", "Davison");
    badBadHatsMembers = new ArrayList<>();
    badBadHatsMembers.add(kerryAlexander);
    badBadHatsMembers.add(chrisHoge);
    badBadHatsMembers.add(connorDavison);
    blink182 = new Band("Blink 182", blink182Members);
    badBadHats = new Band("Bad Bad Hats", badBadHatsMembers);
    sameKerry = new RecordingArtist("Kerry", "Alexander");
    name = "Wrong name";
  }

  @Test
  public void getBandName() {
    assertEquals("Blink 182", blink182.getBandName());
    assertEquals("Bad Bad Hats", badBadHats.getBandName());
  }

  @Test
  public void testEquals() {
    assertTrue(travisBarker.equals(travisBarker));
    assertNotEquals(null, travisBarker);
    assertFalse(kerryAlexander.equals(name));
    assertTrue(kerryAlexander.equals(sameKerry));
    assertFalse(mattSkiba.equals(markHoppus));
    assertFalse(connorDavison.equals(chrisHoge));
  }

  @Test
  public void testHashCode() {
    assertTrue(kerryAlexander.hashCode() == sameKerry.hashCode());
    assertFalse(kerryAlexander.hashCode() == connorDavison.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Band: Blink 182.", blink182.toString());
    assertEquals("Band: Bad Bad Hats.", badBadHats.toString());
  }
}