package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    public Account jane;
    public Account bob;

    @Before
    public void setUp() throws Exception {
        jane = new Account("Jane", "Doe", new Amount(8, 15));
        bob = new Account("Bob", "Burger", new Amount(18, 104));
    }

    @Test
    public void getFirstName() {
        assertEquals("Jane", jane.getFirstName());
        assertEquals("Bob", bob.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Doe", jane.getLastName());
        assertEquals("Burger", bob.getLastName());
    }

    @Test
    public void getBalance() {
        assertEquals(8, jane.getBalance().getDollar());
        assertEquals(-1, bob.getBalance().getCents());
    }

    @Test
    public void deposit() {
        jane = jane.deposit(new Amount(24, 75));
        assertEquals(32, jane.getBalance().getDollar());
        assertEquals(90, jane.getBalance().getCents());
    }

    @Test
    public void withdraw() {
        jane = jane.withdraw(new Amount(4, 5));
        assertEquals(4, jane.getBalance().getDollar());
        assertEquals(10, jane.getBalance().getCents());
    }
}