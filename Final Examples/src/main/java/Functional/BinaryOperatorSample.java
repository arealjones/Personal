package Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

public class BinaryOperatorSample {

  public static void main(String[] args) {
    List<Integer> grades = new ArrayList<>();
    Map<Integer, String> m;
    grades.add(60);
    grades.add(70);
    grades.add(80);
    grades.add(90);
    grades.add(100);
    // the method reduce is similar to Racket’s fold
    System.out.println(grades.stream().reduce(0, new BinaryOperator<Integer>() {                 /** Breaks it down to the sum. Binary Operator Docs: https://docs.oracle.com/javase/8/docs/api/java/util/function/BinaryOperator.html */
      @Override
      public Integer apply(Integer t, Integer u) {
        return t + u;
      }
    }));
  }
}
