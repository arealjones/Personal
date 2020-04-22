package CommandLine.CountryCode;

public class CCMain {
    public static void main(String[] args) {
        CountryCodeProcessor processor = new CountryCodeProcessor(args);
        if (processor.getLog().isEmpty())
            System.out.println(processor.getCodes().toString());
        else
            System.out.println(processor.getLog().toString());
    }
}
