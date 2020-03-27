package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
    public Time correctTime;
    public Time wrongTime;
    public Time wrongMinute;
    public Time wrongSecond;
    public Time negative;

    @Before
    public void setUp() throws Exception {
        correctTime = new Time(3, 24, 15);
        wrongTime = new Time(24, 61, 84);
        wrongMinute = new Time(4, 78, 14);
        wrongSecond = new Time(4, 12, 65);
        negative = new Time(0, -18, -18);
    }

    @Test
    public void setHour() {
        correctTime.setHour(3);
        assertEquals(3, correctTime.getHour());
        wrongTime.setHour(24);
        assertEquals(-1, wrongTime.getHour());
    }

    @Test
    public void setMinutes() {
        correctTime.setMinutes(24);
        assertEquals(24, correctTime.getMinutes());
        wrongTime.setMinutes(61);
        assertEquals(-1, wrongTime.getMinutes());
    }

    @Test
    public void setSeconds() {
        correctTime.setSeconds(15);
        assertEquals(15, correctTime.getSeconds());
        wrongTime.setSeconds(84);
        assertEquals(-1, wrongTime.getSeconds());
    }

    @Test
    public void getHour() { assertEquals(3, correctTime.getHour());
    assertEquals(-1, wrongTime.getHour());
    }

    @Test
    public void getMinutes() { assertEquals(24, correctTime.getMinutes());
    assertEquals(-1, wrongTime.getMinutes());
    assertEquals(-1, negative.getMinutes());
    }

    @Test
    public void getSeconds() { assertEquals(15, correctTime.getSeconds());
    assertEquals(-1, wrongTime.getSeconds());
    assertEquals(-1, negative.getSeconds());
    }

    @Test
    public void getFullSeconds() { assertEquals(12255, correctTime.getFullSeconds());
    }

    @Test
    public void getFullTime() { assertEquals("3 hours, 24 minutes, and 15 seconds.",
            correctTime.getFullTime());
    assertEquals("The time is out of range.", wrongTime.getFullTime());
    assertEquals("The time is out of range.", wrongMinute.getFullTime());
    assertEquals("The time is out of range.", wrongSecond.getFullTime());
    }
}