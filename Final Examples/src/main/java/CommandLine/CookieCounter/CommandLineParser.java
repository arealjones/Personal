package CommandLine.CookieCounter;

/**
 * Processes and validates command line arguments. This class doesn't *do* anything with the values provided by the user
 * beyond initial validation. It is another class' responsibility to determine what to do with the user input.
 */
public class CommandLineParser {
    public static final String SAMOA = "--samoas";
    public static final String DOSIDOS = "--dosidos";
    public static final String THIN_MINTS = "--thin-mints";

    private int numSamoas = 0;
    private int numDosidos = 0;
    private int numThinMints = 0;

    /**
     * Constructor for the CommandLineParser class
     * @param args The arguments provided by the user.
     * @throws InvalidArgumentsException If the arguments supplied are invalid.
     */
    public CommandLineParser(String[] args) throws InvalidArgumentsException {
        if (!this.isEven(args.length))
            throw new InvalidArgumentsException("Even number of arguments expected");
        this.processArgs(args);
    }

    /**
     * Helper method to check that an even number of arguments are provided.
     * @param numArgs Number of arguments.
     * @return true if the number is even, false otherwise.
     */
    private boolean isEven(int numArgs) {
        return numArgs % 2 == 0;
    }

    /**
     * Helper method to populate the instance variables.
     * @param args The args supplied by the user.
     * @throws InvalidArgumentsException If an invalid argument is provided at the command line.
     */
    private void processArgs(String[] args) throws InvalidArgumentsException {
        for (int i = 0; i < args.length; i+=2) {
            try {
                int numCookies = Integer.parseInt(args[i + 1]);
                switch (args[i]) {
                    case SAMOA:
                        this.numSamoas = numCookies;
                        break;
                    case DOSIDOS:
                        this.numDosidos = numCookies;
                        break;
                    case THIN_MINTS:
                        this.numThinMints = numCookies;
                        break;
                    default:
                        throw new InvalidArgumentsException("Unknown cookie: " + args[i]);
                }
            } catch (NumberFormatException e) {
                throw new InvalidArgumentsException("Cookie type must be followed by an integer.");
            }
        }
    }

    public int getNumSamoas() {
        return this.numSamoas;
    }

    public int getNumDosidos() {
        return this.numDosidos;
    }

    public int getNumThinMints() {
        return this.numThinMints;
    }
}
