package CommandLine.Lab6Homebake;

public class HomebakeProcesser {
    public static final String INSTALL = "- install";
    public static final String UNINSTALL = "- uninstall";
    public static final String UPDATE = "- update";

    private String WARNING = "-q";
    private String VERBOSE = "-v";
    private String DEBUG = "-d";

    public HomebakeProcesser(String[] args) throws InvalidArgumentsException {
      if (!this.correctNumInput(args.length))
        throw new InvalidArgumentsException("Either missing arguments or dont have enough.");
      this.processArgs(args);
    }

    private boolean correctNumInput(int numArgs) {
      return ((numArgs >= 2) && (numArgs <= 5));
    }

    private void processArgs(String[] args) throws InvalidArgumentsException {
      for (int i = 0; i < args.length; i++) {
        try {
          switch (args[i]) {
            case INSTALL:
              this.WARNING = WARNING;
              break;
            case UNINSTALL:
              this.VERBOSE = VERBOSE;
              break;
            case UPDATE:
              this.DEBUG = DEBUG;
              break;
            default:
              throw new InvalidArgumentsException("Unknown command: " + args[i]);
          }
        } catch (NumberFormatException e) {
          throw new InvalidArgumentsException("Operation must be followed by a command.");
        }
      }
    }

  public String getWARNING() {
    return this.WARNING;
  }

  public String getVERBOSE() {
    return this.VERBOSE;
  }

  public String getDEBUG() {
    return this.DEBUG;
  }
}
