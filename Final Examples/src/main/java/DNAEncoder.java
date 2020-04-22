import java.util.ArrayList;
import java.util.List;

public class DNAEncoder {

  /**
  You are asked to design a method that will consume a DNA sequence as a List<String>.
  All ele- mentsofthelistareaonecharactercapitalizedletterstring,e.g.,"A", "B", "C",....
  The steps taken to encode a DNA sequence is to take identical characters that are in sequence
  and replace them with the character and the number of times that the character appears in
  sequence. For example the following DNA sequence AABBCCABDDDDDE gets encoded into A2B2C2A1B1D5E1.
  Your method should consume a DNA sequence as a List<String> and return the encoded DNA sequence as a String.
   */

  public static String encoder(List<String> dna) {
    String result = "";
    String current = null;
    int counter = 0;
    // Checking if the list is empty.
    if (dna.isEmpty()) {
      return result;
    } else {
      // Pulling the current letter.
      current = dna.remove(0);
      //System.out.println("Current is: " + current);
      counter = 1;
    }
    for (String s : dna) {
      //System.out.println("The string being reviewed is: " + s);
      if (s.equals(current)) {
        counter++;
      } else {
        //System.out.println("The count for the current letter is: " + counter);
        result += current + counter;
        //System.out.println("The result is: " + result);
        counter = 1;
        current = s;
      }
    }
    return result + current + counter;
  }


  public static void main(String[] args) {
    List<String> listTestOne = new ArrayList<>();
    listTestOne.add("A");
    listTestOne.add("A");
    listTestOne.add("B");
    listTestOne.add("B");
    listTestOne.add("C");
    listTestOne.add("C");
    listTestOne.add("A");
    listTestOne.add("B");
    listTestOne.add("D");
    listTestOne.add("D");
    listTestOne.add("D");
    listTestOne.add("D");
    listTestOne.add("D");
    listTestOne.add("E");
    String answer = encoder(listTestOne);
    System.out.println(answer);
  }

}
