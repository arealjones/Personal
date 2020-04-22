import java.util.ArrayList;
import java.util.List;

public class FlattenedListPairs {

  /**
  You are asked to write a method that will consume a List<List<Pair>> and return the flattened
  list, e.g., List<Pair> that also does not contain duplicate Pairs. Two Pair instances are
  considered to be duplicates if they hold the same value for their x fields and the same values
  for their y fields.
   */

  public static List<Pair> flatten(List<List<Pair>> llp) {
    List<Pair> result = new ArrayList<>();
    for (List<Pair> lp : llp) {
      for (Pair p : lp) {
        // Checking if the list doesnt already contain it.
        if (!result.contains(p)) {
          result.add(p);
        }
      }
    }
    return result;
  }

  static class Pair {
    private Integer x;
    private Integer y;

    public Pair(Integer x, Integer y){
      this.x = x;
      this.y = y;
    }
    public Integer getX() {
      return this.x;
    }
    public Integer getY(){
      return this.y;
    }

    @Override
    public String toString() {
      return "Pair: " +
          "x is " + x +
          ", and y is " + y;
    }
  }

  public static void main(String[] args) {
    Pair one = new Pair(3, 5);
    Pair two = new Pair(1, 1);
    Pair three = new Pair(5, 10);
    List<Pair> first = new ArrayList<>();
    first.add(one);
    first.add(two);
    first.add(three);
    Pair four = new Pair(3, 3);
    Pair five = new Pair(7, 8);
    Pair six = new Pair(4, 11);
    List<Pair> second = new ArrayList<>();
    second.add(four);
    second.add(five);
    second.add(six);
    Pair seven = new Pair(31, 46);
    Pair eight = new Pair(29, 15);
    Pair nine = new Pair(67, 100);
    List<Pair> third = new ArrayList<>();
    third.add(seven);
    third.add(eight);
    third.add(nine);
    List<List<Pair>> listTestOne = new ArrayList<>();
    listTestOne.add(first);
    listTestOne.add(second);
    listTestOne.add(third);
    List<Pair> finished = flatten(listTestOne);
    //System.out.println(finished);
    for (Pair p : finished) {
      System.out.println(p);
    }
  }

}
