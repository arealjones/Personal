package DesignPatterns.Factory.cookiefactory;

public class SamoaCookie extends Cookie {
    public static final int SERV = 2;
    /**
     * Constructor for the SamoaCookie class.
     *
     */
    public SamoaCookie() {
        super("Samoas", SERV, 150, 11);
    }
}
