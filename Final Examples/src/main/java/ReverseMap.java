import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReverseMap {

  /**
   A friend of yours is trying to write a program for a book publisher. One of the tasks is to
   generate the index of a book. A book index holds each word in the book along with a list of
   page numbers were the word appears in the book. However your friend is running out of time and
   they just realized that they made a mistake and the code generates a reverse index, i.e., each
   page mapped to a list of words on that page. The current code generates a Map from Integer to
   List<String>. You are asked to take this Map as input and return the correct index for the book,
   i.e., a Map from String to List<Integer>. For example given

   1 = "a" , "b", "c"
   10 = "a" , "b", "c", "d"
   100 = "y" , "x", "c"

   you method should return

   "a" = 1, 10
   "b" = 1, 10
   "c" = 1, 10, 100
   "d" = 100
   "x" = 100
   "y" = 100

   */

  public static Map<String, List<Integer>> fixIndex(Map<Integer, List<String>> reverseIndex) {
    Map<String, List<Integer>> result = new HashMap<>();
    for (Map.Entry<Integer, List<String>> reverseEntry : reverseIndex.entrySet()) {                 // For every key, and value in the map.
      System.out.println("Entry: " + reverseEntry);
      for (String word : reverseEntry.getValue()) {                                                 // For every word in the list.
        System.out.println("The word is: " + word);
        if (result.containsKey(word)) {                                                             // If the new map contains it, then add the value of the key to the list.
          result.get(word).add(reverseEntry.getKey());
          System.out.println("The result has a key and currently looks like: " + result);
        } else {                                                                                    // Otherwise, start a new list for it and put the key and value in the new map.
          ArrayList<Integer> pages = new ArrayList<Integer>();
          pages.add(reverseEntry.getKey());
          System.out.println("Pages currently: " + pages);
          result.put(word, pages);
          System.out.println("Result currently: " + result);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> listTestOne = new ArrayList<>();
    listTestOne.add("a");
    listTestOne.add("b");
    listTestOne.add("c");
    List<String> listTestTwo = new ArrayList<>();
    listTestTwo.add("a");
    listTestTwo.add("b");
    listTestTwo.add("c");
    listTestTwo.add("d");
    List<String> listTestThree = new ArrayList<>();
    listTestThree.add("y");
    listTestThree.add("x");
    listTestThree.add("c");
    Map<Integer, List<String>> reverseIndex = new HashMap<>();
    reverseIndex.put(1, listTestOne);
    reverseIndex.put(10, listTestTwo);
    reverseIndex.put(100, listTestThree);
    fixIndex(reverseIndex);
  }

}
