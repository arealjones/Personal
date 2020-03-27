package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {
    Vehicle toyotaCamry;

    @Before
    public void setUp() throws Exception {
        toyotaCamry = new Vehicle(7834, "6SAM123", new Owner("Dr.", "Evil",
                "1234567891"));
    }

    @Test
    public void getVin() { assertEquals(7834, toyotaCamry.getVin());
    }

    @Test
    public void getLicensePlate() { assertEquals("6SAM123", toyotaCamry.getLicensePlate());
    }

    @Test
    public void setVin() {
        toyotaCamry.setVin(7834);
        assertEquals(7834, toyotaCamry.getVin());
    }

    @Test
    public void setLicensePlate() {
        toyotaCamry.setLicensePlate("6SAM123");
        assertEquals("6SAM123", toyotaCamry.getLicensePlate());
    }

    @Test
    public void getOwnerName() { assertEquals("Dr. Evil", toyotaCamry.getOwnerName());
    }

    @Test
    public void getOwnerPhone() { assertEquals("1234567891", toyotaCamry.getOwnerPhone());
    }
}