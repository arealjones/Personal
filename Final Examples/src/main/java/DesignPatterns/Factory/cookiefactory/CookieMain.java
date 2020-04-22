package DesignPatterns.Factory.cookiefactory;

public class CookieMain {
    public static void main(String[] args) {
        try {
            CommandLineParser parser = new CommandLineParser(args);
            CookieStash myCookies = new CookieStash(parser.getItems());
            System.out.println(myCookies.toString());
        } catch (InvalidArgumentsException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }
}
