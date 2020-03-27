package problem1;
/**
 * Owner is an object that has the persons first and last name as well as phone number.
 */
public class Owner {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    /**
     * Constructor that creates a new owner object with their name and phone number.
     * @param firstName The first name of the owner.
     * @param lastName The last name of the owner.
     * @param phoneNumber The phone number of the owner.
     */
    public Owner(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    /**
     * Sets the first name of the owner.
     * @param firstName Sets the first name of the owner.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Sets the last name of the owner.
     * @param lastName Sets the last name of the owner.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Sets the phone number of the owner.
     * @param phoneNumber Sets the phone number of the owner.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * Returns the first name of the owner.
     * @return the first name of the owner.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Returns the last name of the owner.
     * @return the last name of the owner.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Returns the phone number of the owner.
     * @return the phone number of the owner.
     */
    public String getPhoneNumber() {
        int phoneLength = 10;
        if (phoneNumber.length() != phoneLength) {
            return "Not the correct amount of digits for the phone number."; }
        else {
            return phoneNumber; }
    }
    /**
     * Returns the full name of the owner.
     * @return the full name of the owner.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
