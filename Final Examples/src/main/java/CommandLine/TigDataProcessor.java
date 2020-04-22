package CommandLine;

public class TigDataProcessor {

  /**
   You are working on the development of a new distributed version control system, called tig.
   tig operates similar to other distributed version control systems - in performs an operation on
   some files under control based upon passed command line arguments.

   Your task it to design and implement class TigProcessor.java, that takes up to four arguments
   from the command line, defined as follows:

   • operation - a String, representing an operation that tig should execute. tig can perform
      several operations, but for now, we want to focus on these three:
      – --commit - an argument that initiates commit operation on tig
      – -add - an argument that initiates add operation on tig
      – --push - an argument that initiates push operation on tig
      This parameter is required, and if it is not provided, your program should terminate with an
      appropriate exception.

   • messageFlag - a String , with value --m, signaling that the next parameter is a message accompanying
      tig operation.

   • message - a String, representing the message that accompanies tig operation. This is a required
      parameter, that always follows message flag -m.

   • verboseFlag - a String , with value --v, representing the flag to denote that the operation should
      be executed in a verbose manner. This is a optional argument. If not provided, please assume
      that the tig operation should not be verbose.

   When processing the given command line arguments, class TigProcessor does the following:
   • If the provided arguments are valid, creates and returns an object TigData.java, that contains
   all of the relevant information provided in command line arguments. Please design and implement class TigData.java.
   • If the provided arguments are not valid,throws an appropriate exception InvalidArgumentExeception.java.
   You can assume that exception InvalidArgumentException.java is already implemented.
   */

  /** The tig data.
   -----------------------------------------------------------------------------------------------*/
  public static class TigData {

    private String operation;
    private String message;
    private Boolean verboseFlag;

    public TigData() {
      this.operation = null;
      this.message = null;
      this.verboseFlag = Boolean.FALSE;
    }

    public TigData(String operation, String message, Boolean verboseFlag) {
      this.operation = operation;
      this.message = message;
      this.verboseFlag = verboseFlag;
    }

    public void setOperation(String operation) {
      this.operation = operation;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public void setVerboseFlag(Boolean verboseFlag) {
      this.verboseFlag = verboseFlag;
    }
  }

  /** The Tig Processor.
   -----------------------------------------------------------------------------------------------*/
  public static class TigProcessor {

    private TigData myTigData;
    public static final Integer REQUIRED_ARGS = 3;
    public static final Integer MAX_ARGS = 5;

    public TigProcessor() {
      this.myTigData = new TigData();
    }

    public TigData processArguments(String[] args) {
      if (args.length < REQUIRED_ARGS || args.length > MAX_ARGS) {
        throw new InvalidArgumentException("Problem with arguments!");
      } else {
        if (checkOperationArgument(args[0])) {
          myTigData.setOperation(args[0]);
        }
        if (checkMessageFlag(args[1])) {
          myTigData.setMessage(args[2]);
        }
        if (checkVerboseFlag(args)) {
          myTigData.setVerboseFlag(Boolean.TRUE);
        }
      }
      return myTigData;
    }

    private Boolean checkOperationArgument(String operation) {
      return (operation.equals("--commit") || operation.equals("--add") || operation
          .equals("--push"));
    }

    private Boolean checkMessageFlag(String messageFlag) {
      return messageFlag.equals("--m");
    }

    private Boolean checkVerboseFlag(String[] args) {
      return ((args.length == 4) && args[3].equals("--v"));
    }
  }

  /** Main.
  -----------------------------------------------------------------------------------------------*/
  public static void main(String[] args) {
    TigProcessor myTigProcessor = new TigProcessor();
    myTigProcessor.processArguments(args);
  }

  /** The Invalid Argument Exception.
   -----------------------------------------------------------------------------------------------*/
  public static class InvalidArgumentException extends RuntimeException {

    private static String[] flags;
    private static String[][] explanations;
    private static String usageHelp;

    public InvalidArgumentException(String msg) {
      super(msg + "\n" + usageHelp);
    }

    public static class MissingCommandException extends InvalidArgumentException {

      public MissingCommandException(String msg) {
        super(msg);
      }
    }

    public static class ExtraArgumentException extends InvalidArgumentException {

      public ExtraArgumentException(String msg) {
        super(msg);
      }
    }

    public static class IllegalFlagError extends InvalidArgumentException {

      public IllegalFlagError(String msg) {
        super(msg);
      }
    }

    public static class IllegalValueException extends InvalidArgumentException {

      public IllegalValueException(String msg) {
        super(msg);
      }
    }

    static {
      flags = new String[]{
          "port"};
      explanations = new String[][]{{"EXPLANATION"},
      };
    }
  }
}
