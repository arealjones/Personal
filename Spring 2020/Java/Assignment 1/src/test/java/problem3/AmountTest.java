package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {
    public Amount correctAmount;
    public Amount incorrectAmount;
    public Amount negativeAmount;

    @Before
    public void setUp() throws Exception {
        correctAmount = new Amount(3, 56);
        incorrectAmount = new Amount(-18, 104);
        negativeAmount = new Amount(-1, -2);
    }

    @Test
    public void getDollar() { assertEquals(3, correctAmount.getDollar());
    assertEquals(-1, incorrectAmount.getDollar());
    }

    @Test
    public void getCents() { assertEquals(56, correctAmount.getCents());
    assertEquals(-1, incorrectAmount.getCents());
    assertEquals(-1, negativeAmount.getCents());
    }

    @Test
    public void addMoney() {
        correctAmount = correctAmount.addMoney(new Amount(6, 4));
        assertEquals(9, correctAmount.getDollar());
        assertEquals(60, correctAmount.getCents());
    }

    @Test
    public void withdrawMoney() {
        correctAmount = correctAmount.withdrawMoney(new Amount(1, 6));
        assertEquals(2, correctAmount.getDollar());
        assertEquals(50, correctAmount.getCents());
    }
}