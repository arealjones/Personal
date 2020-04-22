package CommandLine.CountryCode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ErrorLoggerTest {
    ErrorLogger logger;

    @Before
    public void setUp() throws Exception {
        logger = new ErrorLogger();
    }

    @Test
    public void log() {
        assertEquals("Empty log", logger.toString());
        logger.log("A message");
        assertEquals("A message" + System.lineSeparator(), logger.toString());
    }

    @Test
    public void isEmpty() {
        assertTrue(logger.isEmpty());
        logger.log("A message");
        assertFalse(logger.isEmpty());
    }

    @Test
    public void equalsSelf() {
        assertTrue(logger.equals(logger));
    }

    @Test
    public void equalsOtherObject() {
        assertFalse(logger.equals("A string"));
        assertFalse(logger.equals(null));
    }

    @Test
    public void equalsLog() {
        ErrorLogger copy = new ErrorLogger();
        assertTrue(logger.equals(copy));
        logger.log("A message");
        assertFalse(logger.equals(copy));
        copy.log("A message");
        assertTrue(logger.equals(copy));
    }
}