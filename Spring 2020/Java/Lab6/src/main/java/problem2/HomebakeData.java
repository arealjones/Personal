package problem2;

public class HomebakeData {
  public String warning;
  public String verbose;
  public String debug;

  public HomebakeData(String warning, String verbose, String debug) {
    this.warning = warning;
    this.verbose = verbose;
    this.debug = debug;
  }

  public String getTotalMessage() {
    StringBuilder msg = new StringBuilder();
    msg.append("The choosen flags are").append(warning).append(" and ").append(verbose).append(" and ").append(debug).append(".");
    return msg.toString();
  }
}
