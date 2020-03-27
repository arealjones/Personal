package problem2;

public class Main {
  public static void main(String[] args) {
    try {
      HomebakeProcesser parser = new HomebakeProcesser(args);
      HomebakeData calculator = new HomebakeData(parser.getWARNING(), parser.getVERBOSE(), parser.getDEBUG());
      System.out.println(calculator.getTotalMessage());
    } catch (InvalidArgumentsException e) {
      System.out.println("ERROR, Incorrect input." + e.getMessage());
    }
  }
}
