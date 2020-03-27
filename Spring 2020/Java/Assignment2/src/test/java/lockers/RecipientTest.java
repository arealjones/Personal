package lockers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecipientTest {
  Recipient gary;

  @Before
  public void setUp() throws Exception {
    gary = new Recipient("Gary", "Gergich", "gary.gergich@aol.com");
  }

  @Test
  public void setFirstName() {
    gary.setFirstName("Gary");
    assertEquals("Gary", gary.getFirstName());
  }

  @Test
  public void getFirstName() { assertEquals("Gary", gary.getFirstName());
  }

  @Test
  public void setLastName() {
    gary.setLastName("Gergich");
    assertEquals("Gergich", gary.getLastName());
  }

  @Test
  public void getLastName() { assertEquals("Gergich", gary.getLastName());
  }

  @Test
  public void setEmail() {
    gary.setEmail("gary.gergich@aol.com");
    assertEquals("gary.gergich@aol.com", gary.getEmail());
  }

  @Test
  public void getEmail() { assertEquals("gary.gergich@aol.com", gary.getEmail());
  }
}