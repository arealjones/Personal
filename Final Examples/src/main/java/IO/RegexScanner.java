package IO;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Different data types can be entered when prompted.
 * Stops “scanning” when a space is reached.
 * Use to get user input while program is still running.
 */

/**
 * matches() – does the entire input string match the pattern exactly?
 * lookingAt() – does the pattern occur at the start of the input string?
 * find() – does the pattern occur anywhere in the input string?
 */

public class RegexScanner {

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);

    Pattern re = Pattern.compile("(a|b)b*");                                                        /** REGEX: An "a" or "b" followed by 0 or more "b." */

    System.out.println("Type something:");

    String input = console.nextLine();

    while(!input.equals("stop")) {
      System.out.println("Type something else");
      input = console.nextLine();

      System.out.println("Matches pattern? "
          + re.matcher(input).matches() + ", " + re.matcher(input).lookingAt() + ", " +
          re.matcher(input).find());
    }
  }
}
