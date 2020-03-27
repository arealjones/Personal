/**
 * Represents an Author with their details--name, email and physical address *
 * @author therapon
 *
 */
public class author {
    private person name;
    private contact email;
    private location address;
    /**
     * Creates a new author given the author's name, email and address as strings. *
     * @param name the author's name
     * @param email the author's email address
     * @param address the authors physical address */
    public author(person name, contact email, location address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
    /**
     * @return the name */
    public String getName() {
        return name.getFullName();
    }
    /**
     * @return the email */
    public String getEmail() {
        return email.getFullEmail();
    }
    /**
     * @return the address */
    public String getAddress() {
        return address.getFullAddress;
    }
}