package CommandLine.CookieCounter;

public class Main {
    public static void main(String[] args) {
        try {
            CommandLineParser parser = new CommandLineParser(args);
            Calculator calculator = new Calculator(parser.getNumSamoas(), parser.getNumDosidos(),
                    parser.getNumThinMints());
            System.out.println(calculator.getTotalMessage());
        } catch (InvalidArgumentsException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }
}
