package problem3;
/**
 * Amount is an object that contains dollar and cents. */
public class Amount {
    private int dollar;
    private int cents;
    /**
     * Constructor that creates a new amount of dollar and cents.
     * @param dollar Dollar amount.
     * @param cents Cent amount.*/
    public Amount(int dollar, int cents) {
        this.dollar = dollar;
        this.cents = cents;
    }
    /**
     * Returns the dollar amount after checking that it is valid.
     * @return Returns the dollar amount after checking that it is valid. */
    public int getDollar() {
        int none = -1;
        int positiveAmount = 0;
        if (dollar >= positiveAmount) {
            return dollar;
        }
        else {
            return none;
        }
    }
    /**
     * Returns the cent amount after checking that it is valid.
     * @return Returns the cent amount after checking that it is valid. */
    public int getCents() {
        int none = -1;
        int minCents = 0;
        int maxCents = 99;
        if ((minCents <= cents) && (cents <= maxCents)) {
            return cents;
        }
        else {
            return none;
        }
    }
    /**
     * Adds amounts of dollars and cents.
     * @param money Is the dollars and cents being added.
     * @return A new amount after the dollars and cents have been added together. */
    public Amount addMoney(Amount money) {
        return new Amount((this.dollar + money.dollar),
                (this.cents + money.cents));
    }
    /**
     * Subtracts amounts of dollars and cents.
     * @param money Is the dollars and cents being subtracted.
     * @return A new amount after the dollars and cents have been subtracted. */
    public Amount withdrawMoney(Amount money) {
        return new Amount((this.dollar - money.dollar),
                (this.cents - money.cents));
    }
}
