package Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MoreJoining {

  public static <R> void main(String[] args) {
    List<Integer> listInts = new ArrayList<>();
    listInts.add(1);
    listInts.add(5);
    listInts.add(7);
    listInts.add(10);
    listInts.add(17);
    listInts.add(23);
    listInts.add(25);
    listInts.stream()
        .filter((Integer val) -> val % 5 == 0)
        .forEach(System.out::println);
    List<String> listChars = new ArrayList<>();
    listChars.add("D");
    listChars.add("D");
    listChars.add("E");
    listChars.add("T");
    listChars.add("B");
    List<String> result
        = listChars.stream()
        .map(s -> s.toLowerCase())
        .collect(Collectors.toList()); System.out.println("Results of the second stream: " + result);
    System.out.println("Results of the third stream: " +listChars.stream().collect(Collectors.joining("-")));
  }

}
