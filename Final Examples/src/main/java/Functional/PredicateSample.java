package Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class PredicateSample {

  public static void main(String[] args) {
    List<Integer> grades = new ArrayList<>();
    Map<Integer, String> m;
    grades.add(60);
    grades.add(70);
    grades.add(80);
    grades.add(90);
    grades.add(100);
    Predicate<Integer> p = new Predicate<Integer>() {                                               /** Predicate Docs: https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html */
      @Override                                                                                     /** Filters the vals to be greater than 70. */
      public boolean test(Integer val) {
        return val > 70;
      }
    };
    grades.stream().filter(p).forEach(v -> System.out.println(v));

    System.out.println("-----------------------");

    grades.stream().filter(new Predicate<Integer>() {
      @Override
      public boolean test(Integer val) {
        return (val % 3) == 0;
      }
    }).forEach(v -> System.out.println(v));
  }
}
