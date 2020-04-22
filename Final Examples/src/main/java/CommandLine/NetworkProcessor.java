package CommandLine;

public class NetworkProcessor {

  /**
   Write a program CmdLineProcessor.java, that takes up to three arguments from the command line,
   defined as follows:
   • port - an Integer, representing a port number. This parameter is required, and it can be
      anything in the range [1000, 65000]. If this parameter is not provided, your program should
      terminate with an appropriate exception.
   • hostname - a String, representing the name of the host server. This is an optional parameter,
      and if it is not provided, you should assume its value is localhost.
   • encrypted -a String, representing whether or not should the exchanged messages to the server
      beencrypted.Thisisanoptionalparameter,withpossiblevalues"--encrypt", "--plain".Ifthe parameter
      is not provided, you should assume its value is "--plain".

   The program processes the given command line arguments, and does the following:
   • If the provided arguments are valid, creates and returns an object CLData.java, that contains
      all of the relevant information provided in command line arguments. Please provide an
      interface, and an implemention for CLData.java.
   • If the provided arguments are not valid, throws an appropriate exception
      InvalidArgumentExeception.java. You can assume that exception InvalidArgumentException.java
      is already implemented. */

  /**
   * Interface.
   */
  public interface ICLData {
  }

  /**
   * CommandLine data options.
   */
  public static class CLData implements ICLData {
    private Integer port;
    private String hostname;
    private String encrypted;

    public CLData(){
      port = Integer.MIN_VALUE;
      hostname = "localhost";
      encrypted = "plain";
    }
    public CLData(Integer myPort){
      port = myPort;
      hostname = "localhost";
      encrypted = "plain";
    }
    public CLData(Integer myPort, String myHostname, String myEncy){
      port = myPort;
      hostname = myHostname;
      encrypted = myEncy;
    }
    public void setEncrypted(String encrypted) { this.encrypted = encrypted;
    }
    public void setPort(Integer port){ this.port = port;
    }
    public void setHostname(String hostname){ this.hostname = hostname;
    }
  }


  public static class cmdLineProcessor {
    public CLData myCLData;
    private final String LOCALHOST = "localhost";
    private final String PLAIN = "plain";

    public cmdLineProcessor() {
      myCLData = new CLData();
    }

    public void processArguments(String[] args) {
      try {
        Integer port = Integer.valueOf(args[0]);
        if (port < 1000 || port > 65000) {
          throw new CommandLineExceptions("Incorrect port number!");
        }
        myCLData.setPort(port);
      } catch (NumberFormatException e) {
        throw new CommandLineExceptions("Incorrect port format!");
      }

      if (args.length == 2) {
        try {
          if ((args[1].equals("--plain")) || (args[1].equals("--encrypt"))) {
            myCLData.setEncrypted(args[1]);
          } else
            myCLData.setHostname(args[1]); //fragile assumption that a user will always provide either a co
        } catch (Exception e) {
          throw new CommandLineExceptions(("Incorrect hostname or encryption flag!"));
        }
      }
      if (args.length == 3) {
        try {
          if ((args[1].equals("--plain")) || (args[1].equals("--encrypt"))) {
            myCLData.setEncrypted(args[1]);
            myCLData.setHostname(args[2]);
          } else {
            myCLData.setEncrypted(args[2]);
            myCLData.setHostname(args[1]);
          }
        } catch (Exception e) {
          throw new CommandLineExceptions("Incorrect hostname or encryption format!"); }
        }
    }


    public static class CommandLineExceptions extends RuntimeException {
      private static String[] flags;
      private static String[][] explanations;
      private static String usageHelp;

      public CommandLineExceptions(String msg) {
        super(msg + "\n" + usageHelp);
      }

      public static class MissingCommandException extends CommandLineExceptions {
        public MissingCommandException(String msg) {
          super(msg);
        }
      }

      public static class ExtraArgumentException extends CommandLineExceptions {
        public ExtraArgumentException(String msg) {
          super(msg);
        }
      }

      public static class IllegalFlagError extends CommandLineExceptions {
        public IllegalFlagError(String msg) {
          super(msg);
        }
      }

      public static class IllegalValueException extends CommandLineExceptions {
        public IllegalValueException(String msg) {
          super(msg);
        }
      }
      //Used for USAGE help generation
      static {
        flags = new String[]{ "port" };
        explanations = new String[][]{ {"EXPLANATION"}, {"Port number (number in the range 10000-65000"},
        };
      }
    }
    public static void main(String[] args) {
      if (args.length < 1 || args.length > 3)
        throw new CommandLineExceptions("Incorrect number of arguments!");
      cmdLineProcessor clProcessor = new cmdLineProcessor();
      clProcessor.processArguments(args);
    }
  }
}

