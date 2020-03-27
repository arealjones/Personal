package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RunnerTest {
    public Runner batman;
    public Runner joker;
    public Runner startAfterEnd;

    @Before
    public void setUp() throws Exception {
        batman = new Runner("Batman", "Good Guys", new Time(4, 32, 56),
                new Time(6, 14, 33));
        joker = new Runner("Joker", "Bad Guys", new Time(4,32, 56),
                new Time(7, 2, 8));
        startAfterEnd = new Runner("Start After End Time", "Bad Guys",
                new Time(20, 52, 19), new Time(14, 38, 11));
    }

    @Test
    public void setName() {
        batman.setName("Batman");
        assertEquals("Batman", batman.getName());
        joker.setName("Joker");
        assertEquals("Joker", joker.getName());
    }

    @Test
    public void setTeam() {
        batman.setTeam("Good Guys");
        assertEquals("Good Guys", batman.getTeam());
        joker.setTeam("Bad Guys");
        assertEquals("Bad Guys", joker.getTeam());
    }

    @Test
    public void getName() { assertEquals("Batman", batman.getName());
    assertEquals("Joker", joker.getName());
    }

    @Test
    public void getTeam() { assertEquals("Bad Guys", joker.getTeam());
    assertEquals("Good Guys", batman.getTeam());
    }

    @Test
    public void getStartTime() { assertEquals("4 hours, 32 minutes, and 56 seconds.", batman.getStartTime());
    assertEquals("4 hours, 32 minutes, and 56 seconds.", joker.getStartTime());
    }

    @Test
    public void getEndTime() { assertEquals("6 hours, 14 minutes, and 33 seconds.", batman.getEndTime());
    assertEquals("7 hours, 2 minutes, and 8 seconds.", joker.getEndTime());
    }

    @Test
    public void getDuration() {assertEquals("1 hours, 41 minutes, and 37 seconds.",
            batman.getDuration().getFullTime());
    assertEquals("2 hours, 29 minutes, and 12 seconds.", joker.getDuration().getFullTime());
    assertEquals("The time is out of range.", startAfterEnd.getDuration().getFullTime());
    }
}