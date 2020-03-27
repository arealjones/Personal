import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class authorTest {
    public author author1;
    public author author2;

    @Before
    public void setUp() throws Exception {
        author1 = new author(new person("Jim", "Carrey"), "jim.carrey@aol.com", "111 Funny Way");
        author2 = new author(new person("Michelle", "Obama"), "michelle.obama@ruler.com",
                "911 Save The Country Ave");
    }

    @Test
    public void getName() { assertEquals("Jim Carrey", author1.getName());
    }

    @Test
    public void getEmail() { assertEquals("michelle.obama@ruler.com", author2.getEmail());
    }

    @Test
    public void getAddress() { assertEquals("911 Save The Country Ave", author2.getAddress());
    }
}