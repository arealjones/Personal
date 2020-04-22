package Functional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntegerFrequency {

  // You are asked to implement a method that consumes a List<Integer> and returns a histogram of
  // the numbers in the input list as a Map. A histogram contains each number n in the list and the
  // number of times that n appears in the list.

  //For example when given the following list of numbers
  //( 1 , 2, -3, 0, 2, 6, 7, 1, 2, 7 )
  //The histogram should contain the following information
  //1=2 2=3 -3=1 0=1 6=1 7=2

  public static Map<Integer, Long> countTopics(List<Integer> lines) {
    return lines.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  /**
   * The solutions on the practice exam. */
  public Map<Integer, Integer> histogram(List<Integer> nums) {
    Map<Integer, Integer> result = new HashMap<>();
    for (Integer n : nums) {
      if (result.containsKey(n)) { result.put(n, result.get(n) + 1);
      } else { result.put(n, 1);
      } }
    return result; }


  public static void main(String[] args) {
    List<Integer> listTestOne = new ArrayList<>();
    listTestOne.add(1);
    listTestOne.add(2);
    listTestOne.add(-3);
    listTestOne.add(0);
    listTestOne.add(2);
    listTestOne.add(6);
    listTestOne.add(7);
    listTestOne.add(1);
    listTestOne.add(2);
    listTestOne.add(7);
    Map<Integer, Long> frequency = countTopics(listTestOne);
    System.out.println(frequency.get(1));
    System.out.println(frequency);
  }

}
