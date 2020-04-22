package Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopicsFrequency {

  public static Map<String, Long> countTopics(List<String> lines) {
    return lines.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  // Ignore this, I just used it for testing.
  public static void main(String[] args) {
    List<String> listTestOne = new ArrayList<>();
    listTestOne.add("Seattle");
    listTestOne.add("wildfires");
    listTestOne.add("DEFCON26");
    listTestOne.add("NEU");
    listTestOne.add("NEU");
    listTestOne.add("Seattle");
    listTestOne.add("Seattle");
    listTestOne.add("NEU");
    listTestOne.add("DEFCON26");
    listTestOne.add("wildfires");
    Map<String, Long> frequency = countTopics(listTestOne);
    System.out.println(frequency.get("Seattle"));
    System.out.println(frequency.values());
  }
}
