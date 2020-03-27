package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {
    Owner jackSparrow;
    Owner incorrectPhone;
    Owner emptyPhone;
    Owner spacePhone;

    @Before
    public void setUp() throws Exception {
        jackSparrow = new Owner("Jack", "Sparrow", "4403335678");
        incorrectPhone = new Owner("Incorrect", "Phone", "440333567");
        emptyPhone = new Owner("Empty", "Phone", "");
        spacePhone = new Owner("Space", "Phone", " ");
    }

    @Test
    public void setFirstName() {
        jackSparrow.setFirstName("Jack");
        assertEquals("Jack", jackSparrow.getFirstName());
    }

    @Test
    public void setLastName() {
        jackSparrow.setLastName("Sparrow");
        assertEquals("Sparrow", jackSparrow.getLastName());
    }

    @Test
    public void setPhoneNumber() {
        jackSparrow.setPhoneNumber("4403335678");
        assertEquals("4403335678", jackSparrow.getPhoneNumber());
    }

    @Test
    public void getFirstName() { assertEquals("Jack", jackSparrow.getFirstName());
    }

    @Test
    public void getLastName() { assertEquals("Sparrow", jackSparrow.getLastName());
    }

    @Test
    public void getPhoneNumber() { assertEquals("4403335678", jackSparrow.getPhoneNumber());
        assertEquals("Not the correct amount of digits for the phone number.",
                incorrectPhone.getPhoneNumber());
        assertEquals("Not the correct amount of digits for the phone number.", emptyPhone.getPhoneNumber());
        assertEquals("Not the correct amount of digits for the phone number.", spacePhone.getPhoneNumber());
    }

    @Test
    public void getFullName() { assertEquals("Jack Sparrow", jackSparrow.getFullName());
    }
}