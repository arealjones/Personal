package Comparator;

import java.util.ArrayList;
import java.util.List;
/*Class Swimmer contains information about a swimmer, and the list of their swimming times,
when swimming 50m. Four swimming styles are considered: butterfly, backstroke, breaststroke,
and freestyle. */
public class Swimmer implements Comparable<Swimmer> {
  private String name;
  private List<Double> butterfly50mTimes;
  private List<Double> backstroke50mTimes;
  private List<Double> breaststroke50mTimes;
  private List<Double> freestyle50mTimes;

  public Swimmer(String name, List<Double> butterfly50mTimes, List<Double> backstroke50mTimes,
      List<Double> breaststroke50mTimes, List<Double> freestyle50mTimes) {
    this.name = name;
    this.butterfly50mTimes = butterfly50mTimes;
    this.backstroke50mTimes = backstroke50mTimes;
    this.breaststroke50mTimes = breaststroke50mTimes;
    this.freestyle50mTimes = freestyle50mTimes;
  }

  public String getName() {
    return name;
  }
  public List<Double> getButterfly50mTimes() {
    return butterfly50mTimes;
  }
  public List<Double> getBackstroke50mTimes() {
    return backstroke50mTimes;
  }
  public List<Double> getBreaststroke50mTimes() {
    return breaststroke50mTimes;
  }
  public List<Double> getFreestyle50mTimes() {
    return freestyle50mTimes;
  }

  // I created a helper method to make the code a bit cleaner.
  public int getAverage() {
    List<Double> freestyle = getFreestyle50mTimes();
    int length = freestyle.size();
    double count = 0;
    for (int i = 0; i < length; i++) {
      count += freestyle.get(i);
    }
    return ((int) count / length);
  }

  @Override
  public int compareTo(Swimmer otherSwimmer) {
    if (this.getAverage() < otherSwimmer.getAverage()) {
      return -1;
    } else if (this.getAverage() == otherSwimmer.getAverage()) {
      return 0;
    }
    return 1;
  }


  public static void main(String[] args) {
    List<Double> swimmerOneButter = new ArrayList<>();
    swimmerOneButter.add(7.8);
    List<Double> swimmerOneBack = new ArrayList<>();
    swimmerOneBack.add(4.7);
    List<Double> swimmerOneBreast = new ArrayList<>();
    swimmerOneBreast.add(9.5);
    List<Double> swimmerOneFree = new ArrayList<>();
    swimmerOneFree.add(5.3);
    swimmerOneFree.add(11.40);
    swimmerOneFree.add(8.1);
    swimmerOneFree.add(6.9);
    swimmerOneFree.add(4.4);
    Swimmer swimmerOne = new Swimmer("Krista", swimmerOneButter, swimmerOneBack,
        swimmerOneBreast, swimmerOneFree);
    List<Double> swimmerTwoButter = new ArrayList<>();
    swimmerTwoButter.add(7.8);
    List<Double> swimmerTwoBack = new ArrayList<>();
    swimmerTwoBack.add(4.7);
    List<Double> swimmerTwoBreast = new ArrayList<>();
    swimmerTwoBreast.add(9.5);
    List<Double> swimmerTwoFree = new ArrayList<>();
    swimmerTwoFree.add(5.3);
    swimmerTwoFree.add(11.40);
    swimmerTwoFree.add(8.1);
    swimmerTwoFree.add(6.9);
    swimmerTwoFree.add(4.4);
    Swimmer swimmerTwo = new Swimmer("Krista", swimmerTwoButter, swimmerTwoBack,
        swimmerTwoBreast, swimmerTwoFree);
    List<Double> swimmerThreeButter = new ArrayList<>();
    swimmerThreeButter.add(7.8);
    List<Double> swimmerThreeBack = new ArrayList<>();
    swimmerThreeBack.add(4.7);
    List<Double> swimmerThreeBreast = new ArrayList<>();
    swimmerThreeBreast.add(9.5);
    List<Double> swimmerThreeFree = new ArrayList<>();
    swimmerThreeFree.add(2.3);
    swimmerThreeFree.add(3.7);
    swimmerThreeFree.add(4.1);
    swimmerThreeFree.add(3.9);
    swimmerThreeFree.add(2.6);
    Swimmer swimmerThree = new Swimmer("Janis", swimmerThreeButter, swimmerThreeBack,
        swimmerThreeBreast, swimmerThreeFree);

    int compareSwimmerOneAndTwo = swimmerOne.compareTo(swimmerTwo);
    System.out.println(compareSwimmerOneAndTwo);
    int compareSwimmerTwoAndThree = swimmerTwo.compareTo(swimmerThree);
    System.out.println(compareSwimmerTwoAndThree);
  }
}
