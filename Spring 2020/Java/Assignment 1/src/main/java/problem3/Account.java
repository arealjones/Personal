package problem3;
/**
 * Account is an object that includes the individuals first name, last name, and account balance. */
public class Account {
    private String firstName;
    private String lastName;
    private Amount balance;
    /**
     * Constructor that creates a new account with an individuals first name, last name, and account balance.
     * @param firstName The first name of the account holder.
     * @param lastName The last name of the account holder.
     * @param balance The balance of the account. */
    public Account(String firstName, String lastName, Amount balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }
    /**
     * Returns the first name of the account holder.
     * @return Returns the first name of the account holder. */
    public String getFirstName() {
        return this.firstName;
    }
    /**
     * Returns the last name of the account holder.
     * @return Returns the last name of the account holder. */
    public String getLastName() {
        return this.lastName;
    }
    /**
     * Returns the balance of the account.
     * @return Returns the balance of the account. */
    public Amount getBalance() {
        return this.balance;
    }
    /**
     * Adds any new deposits to the balance of the account.
     * @param deposit Money that is being added to the account.
     * @return The new account balance based on any deposits. */
    public Account deposit(Amount deposit) {
        balance = balance.addMoney(deposit);
        return new Account(firstName, lastName, new Amount(balance.getDollar(), balance.getCents()));
    }
    /**
     * Withdraws any amount from the balance of the account.
     * @param withdraw Money that is being withdrawn from the account.
     * @return The new account balance based on any withdraws. */
    public Account withdraw(Amount withdraw) {
        balance = balance.withdrawMoney(withdraw);
        return new Account(firstName, lastName, new Amount(balance.getDollar(), balance.getCents()));
    }
}
