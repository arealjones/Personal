package IO;

import java.util.Scanner;

/**
 * Different data types can be entered when prompted.
 * Stops “scanning” when a space is reached.
 * Use to get user input while program is still running.
 */

public class InteractiveScanner {

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);

    System.out.println("Enter a number");
    int num = console.nextInt();

    System.out.println("Doubled: " + num * 2);
  }
}
