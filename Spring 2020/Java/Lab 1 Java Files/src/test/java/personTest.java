import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class personTest {
    person janis;

    @Before
    public void setUp() throws Exception {
        janis = new person("Janis", "Baron");
    }

    @Test
    public void setFirstName() {
        janis.setFirstName("Janis");
        assertEquals("Janis", janis.getFirstName());
    }

    @Test
    public void setLastName() {
        janis.setLastName("Baron");
        assertEquals("Baron", janis.getLastName());
    }

    @Test
    public void getFirstName() { assertEquals("Janis", janis.getFirstName());
    }

    @Test
    public void getLastName() { assertEquals("Baron", janis.getLastName());
    }
}