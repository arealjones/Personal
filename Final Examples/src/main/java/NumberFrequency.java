import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberFrequency {

  public NumberFrequency() {
  }


  // I only have the static so I can test in my main.
  public static Integer countNumber(Integer n, List<Integer> frequencyList) {
    int counter = 0;
    for (int i = 0; i < frequencyList.size(); i++) {
      if (frequencyList.get(i) == n) {
        counter++;
      }
    }
    return counter;
  }

  // I only have the static so I can test in my main.
  public static Map<Integer, Float> frequencyCount(List<Integer> frequencyList) {
    Map<Integer, Float> count = new HashMap<>();
    int listLength = frequencyList.size();
    for (Integer n: frequencyList) {
      if (count.containsKey(n)) {
        continue;
      }
      Integer amount = countNumber(n, frequencyList);
      Float frequency = ((float) amount / listLength);
      count.put(n, frequency);
    }
    return count;
  }


  public static void main(String[] args) {
    List<Integer> listTestOne = new ArrayList<>();
    listTestOne.add(1);
    listTestOne.add(1);
    listTestOne.add(1);
    listTestOne.add(2);
    listTestOne.add(2);
    listTestOne.add(3);
    listTestOne.add(3);
    listTestOne.add(4);
    listTestOne.add(4);
    listTestOne.add(4);
    Map<Integer, Float> frequency = frequencyCount(listTestOne);
    System.out.println(frequency.get(1));
    System.out.println(frequency.values());
  }
}
