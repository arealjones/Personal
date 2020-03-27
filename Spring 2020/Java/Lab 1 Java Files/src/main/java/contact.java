public class contact {
    private String name;
    private String domain;

    public contact(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public String getFullEmail() {
        return name + "@" + domain;
    }
}
