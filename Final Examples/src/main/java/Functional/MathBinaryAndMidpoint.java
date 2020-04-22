package Functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class MathBinaryAndMidpoint {

  /**
   Using the math library.
   */

  public static class Pair<X,Y> {

    private X first;
    private Y second;

    public static <X, Y> Pair<X, Y> create(X first, Y second) {
      return new Pair(first, second);
    }

    public static <X, Y> List<Pair<X, Y>> createListOfPairs(List<X> xs, List<Y> ys) {
      if (xs.size() != ys.size()) {
        throw new IllegalArgumentException("Size of input lists must be the same.");
      }
      List<Pair<X, Y>> result = new ArrayList<>();
      for (int i = 0; i < xs.size(); i++) {
        result.add(Pair.create(xs.get(i), ys.get(i)));
      }
      return result;
    }

    private Pair(X first, Y second) {
      this.first = first;
      this.second = second;
    }

    public X getFirst() {
      return first;
    }

    public void setFirst(X first) {
      this.first = first;
    }

    public Y getSecond() {
      return second;
    }

    public void setSecond(Y second) {
      this.second = second;
    }

    public static Double distance(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
//      System.out.println(a.getFirst() - b.getFirst());
//      System.out.println(a.getSecond() - b.getSecond());
//      System.out.println("Pow for the first: " + Math.pow((a.getFirst() - b.getFirst()), 2));
//      System.out.println("Pow for the second: " + Math.pow(a.getSecond() - b.getSecond(), 2));
//      System.out.println(
//          "Adding them together: " + (Math.pow((a.getFirst() - b.getFirst()), 2) + Math
//              .pow(a.getSecond() - b.getSecond(), 2)));
//      System.out.println("Squaring it: " + Math.sqrt(
//          Math.pow((a.getFirst() - b.getFirst()), 2) + Math.pow(a.getSecond() - b.getSecond(), 2)));
      return Math.sqrt(
          Math.pow((a.getFirst() - b.getFirst()), 2) + Math.pow(a.getSecond() - b.getSecond(), 2));
    }

    @Override
    public String toString() {
      return "(" + first + "," + second + ')';
    }
  }

  public static void main(String[] args) {
    Pair<Integer, Integer> origin = Pair.create(0, 0);
    Pair<Integer, Integer> top = Pair.create(0, 3);
    Pair<Integer, Integer> bottom = Pair.create(4, 0);
    System.out.println(Pair.distance(top, bottom));
  }


   /**
    Finding the sum and then dividing it by the size.
    */

//  public static void main(String[] args) {
//    List<Pair<String, Integer>> hws = Pair.createListOfPairs(Arrays.asList("a", "b", "c", "d", "e"), Arrays.asList(50, 60, 70, 80, 90));
//    System.out.println(hws);
//    System.out.println(hws.stream().map(p -> p.getSecond()).reduce(0, new BinaryOperator<Integer>() {
//      @Override
//      public Integer apply(Integer a, Integer b) {
//        System.out.println("A is: " + a);
//        System.out.println("B is: " + b);
//        System.out.println("Adding them together: " + (a+b));
//        return a + b;
//      }
//    }) / hws.size());
//  }

  /**
   Getting the sum with an outside method.
   */

//  public static void main(String[] args) {
//    List<Pair<String, List<Integer>>> hws = Pair.createListOfPairs(
//        Arrays.asList("a", "b", "c", "d"),
//        Arrays.asList(
//            Arrays.asList(1, 2, 3, 4, 5),
//            Arrays.asList(10, 20, 30, 40, 50),
//            Arrays.asList(5, 4, 5),
//            Arrays.asList(20, 10, 20, 10)
//        ));
//    System.out.println(hws.stream().
//        map(p ->
//            Pair.create(
//                p.getFirst(),
//                p.getSecond().stream().reduce(0, new Adder()) / p.getSecond().size()))
//        .map(p -> p.getSecond())
//        .reduce(0, new Adder()));
//  }
//
//    static class Adder implements BinaryOperator<Integer> {
//      @Override
//      public Integer apply(Integer a, Integer b) {
//        return a + b;
//      }
//    }

  /**
   Finds the midpoint of two pairs.
   // "a", Pair(1,1)
   // "b", Pair(3,3)
   // "c", Pair(5,5)
   */

//  public static void main(String[] args) {
//    List<Pair<String, Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>>> points = Pair
//        .createListOfPairs(
//            Arrays.asList("a", "b", "c"),
//            Arrays.asList(
//                Pair.create(Pair.create(0, 0), Pair.create(2, 2)),
//                Pair.create(Pair.create(1, 1), Pair.create(5, 5)),
//                Pair.create(Pair.create(2, 2), Pair.create(8, 8))
//            ));
//    points.stream().
//        map(p -> Pair.create(p.getFirst(), midpoint(p.getSecond()))).forEach(System.out::println);
//  }
//
//  private static Pair<Integer, Integer> midpoint(Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> nPair) {
//    return Pair.create(
//        (nPair.getFirst().getFirst() + nPair.getSecond().getFirst()) / 2,
//        (nPair.getFirst().getSecond() + nPair.getSecond().getSecond()) / 2);
//  }
}
