package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneNumbers {

  public PhoneNumbers() {
  }

  public static String[] convertPhone(List<String> list) {
    List<String> individuals = null;
    String[] numbers = new String[list.size()];
    // Looking at every string in the list.
    int counter = 0;
    for (String s : list) {
      // Separate the string into four parts.
      String[] each = s.split(":");
      // Pulling the phone number and adding it to the list of numbers.
      each[2].replace("(", "");
      each[2].replace(") ", ".");
      each[2].replace("-", ".");
      System.out.println(each[2]);
      numbers[counter] = each[2];
      counter++;
    }
    return numbers;
  }

  public static void main(String[] args) {
    String bill = "Bill Gates:1 Infinite Loop:(425) 524-1234:Redmond";
    String bonnie = "Bonnie Dunbar:Museum of Flight:206.764.5720:Seattle";
    String ichiro = "Ichiro:Seattle Mariners:206-346-4000:Seattle";
    List<String> people = new ArrayList<>();
    people.add(bill);
    people.add(bonnie);
    people.add(ichiro);
    convertPhone(people);
  }
}
