package Iterator;

import java.util.ArrayList;
import java.util.List;
import Comparator.Swimmer;

public class SwimmerIterator {

  public static boolean hasFiveButter(Swimmer person) {
    if (person.getButterfly50mTimes().size() >= 5) {
      return true;
    }
    return false;
  }

  public static boolean hasQualifyingTime(Swimmer person) {
    Double qualifyingTime = 26.17;
    for (int i = 0; i < person.getFreestyle50mTimes().size(); i++) {
      if (person.getFreestyle50mTimes().get(i) <= qualifyingTime) {
        return true;
      }
    }
    return false;
  }

  public static List<Swimmer> getQualifying(List<Swimmer> runners) {
    List<Swimmer> qualifying = new ArrayList<>();
    for (int i = 0; i < runners.size(); i++) {
      if (hasFiveButter(runners.get(i)) && hasQualifyingTime(runners.get(i))) {
        qualifying.add(runners.get(i));
      }
    }
    return qualifying;
  }


  public static void main(String[] args) {
    // Has five butterfly swim times and qualifies.
    List<Double> swimmerOneButter = new ArrayList<>();
    swimmerOneButter.add(7.8);
    swimmerOneButter.add(5.3);
    swimmerOneButter.add(11.40);
    swimmerOneButter.add(8.1);
    swimmerOneButter.add(6.9);
    List<Double> swimmerOneBack = new ArrayList<>();
    swimmerOneBack.add(4.7);
    List<Double> swimmerOneBreast = new ArrayList<>();
    swimmerOneBreast.add(9.5);
    List<Double> swimmerOneFree = new ArrayList<>();
    swimmerOneFree.add(26.10);
    Swimmer swimmerOne = new Swimmer("Krista", swimmerOneButter, swimmerOneBack,
        swimmerOneBreast, swimmerOneFree);
    // Only has five butterfly swim times.
    List<Double> swimmerTwoButter = new ArrayList<>();
    swimmerTwoButter.add(7.8);
    swimmerTwoButter.add(11.40);
    swimmerTwoButter.add(8.1);
    swimmerTwoButter.add(6.9);
    swimmerTwoButter.add(4.4);
    List<Double> swimmerTwoBack = new ArrayList<>();
    swimmerTwoBack.add(4.7);
    List<Double> swimmerTwoBreast = new ArrayList<>();
    swimmerTwoBreast.add(9.5);
    List<Double> swimmerTwoFree = new ArrayList<>();
    swimmerTwoFree.add(50.6);
    Swimmer swimmerTwo = new Swimmer("Nancy", swimmerTwoButter, swimmerTwoBack,
        swimmerTwoBreast, swimmerTwoFree);
    // Only has the qualifying free time.
    List<Double> swimmerThreeButter = new ArrayList<>();
    swimmerThreeButter.add(7.8);
    List<Double> swimmerThreeBack = new ArrayList<>();
    swimmerThreeBack.add(4.7);
    List<Double> swimmerThreeBreast = new ArrayList<>();
    swimmerThreeBreast.add(9.5);
    List<Double> swimmerThreeFree = new ArrayList<>();
    swimmerThreeFree.add(25.4);
    Swimmer swimmerThree = new Swimmer("Janis", swimmerThreeButter, swimmerThreeBack,
        swimmerThreeBreast, swimmerThreeFree);
    List<Swimmer> runners = new ArrayList<>();
    runners.add(swimmerOne);
    runners.add(swimmerTwo);
    runners.add(swimmerThree);
    List<Swimmer> qualifying = getQualifying(runners);
    for (int i = 0; i < qualifying.size(); i++) {
      System.out.println(qualifying.get(i).getName());
    }
  }
}
