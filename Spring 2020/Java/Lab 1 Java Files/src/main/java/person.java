/**
 * Represents a persons first and last name. */
public class person {
    private String firstName;
    private String lastName;
    /**
     * Creates a new person given their first and last name.
     * @param firstName The persons first name.
     * @param lastName The persons last name. */
    public person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /**
     * @param firstName The first name. */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName The last name. */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the first name. */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the last name. */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the full name. */
    public String getFullName() {
        return firstName + " " + lastName;
    }
}