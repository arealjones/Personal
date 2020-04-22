package Comparator.Runner;

import java.util.List;

public class ComparingAverageAndIterator {

  /**
   Consider the following class Runner. Notice that the given class implement interface Comparable.
   Implement method compareTo(Runner otherRunner), that compares two Runner objects based upon their
   average 5k race times, computed as a sum of all their 5k race times, and divided by the number of 5k races.
   */

  public class Runner implements Comparable<Runner>{
    private String name;
    private List<Double> fiveKRaceTimes;
    private List<Double> tenKRaceTimes;
    private List<Double> halfMarathonTimes;

    public Runner(String name, List<Double> fiveKRaceTimes, List<Double> tenKRaceTimes, List<Double> halfMarathonTimes) {
      this.name = name;
      this.fiveKRaceTimes = fiveKRaceTimes;
      this.tenKRaceTimes = tenKRaceTimes;
      this.halfMarathonTimes = halfMarathonTimes;
    }

    public String getName() { return name;
    }
    public List<Double> getFiveKRaceTimes() { return fiveKRaceTimes;
    }
    public List<Double> getTenKRaceTimes() { return tenKRaceTimes;
    }
    public List<Double> getHalfMarathonTimes() { return halfMarathonTimes;
    }

    //ADDED CODE
    private Double getAverageRaceTime(List<Double> raceTimes){
      Double avgRaceTime = null;
      Double raceTimesSum = new Double(0);
      if(raceTimes != null && raceTimes.size() !=0) {
        for(Double raceTime: raceTimes) {
          raceTimesSum = raceTimesSum + raceTime;
        }
        avgRaceTime = raceTimesSum/raceTimes.size();
      }
      return avgRaceTime;
    }

    @Override
    //ADDED CODE
    public int compareTo(Runner otherRunner) {
      Double difference = this.getAverageRaceTime(this.getFiveKRaceTimes()) - otherRunner.getAverageRaceTime(otherRunner.getFiveKRaceTimes());
      return difference.intValue();
    }
  }

  /**
   Given a list of runners,
   List<Runner> runners = new ArrayList<>();,
   with the interface List<E> defined in the appendix, implement an iterator RunnersIterator that
   iterates over the given list of runners, and returns those runners who have run at least five 5k
   races, and who have qualified for an upcoming half marathon race.
   To qualify for an upcoming half marathon race, a racer should have run at least one half marathon
   race in less than 100.00 minutes.
   Note: You do not have to implement method remove().
   */

//  public class RunnersIterator implements Iterator {
//    private List<Runner> runners;
//    private Integer internalCounter = 0;
//    private static final Integer NUM_RACES = 5;
//    private static final Double QUALIFYING_TIME = 100.00;
//
//    public RunnersIterator(List<Runner> runners) {
//      for (Runner runner: runners) {
//        if(check5kRacesCondition(runner)){
//          if(checkIfHalfMarathonQualified(runner)) {
//            this.runners.add(runner);
//          }
//        }
//      }
//    }
//
//    private Boolean check5kRacesCondition(Runner runner) {
//      return (runner.getFiveKRaceTimes().size() > NUM_RACES);
//    }
//
//    private Boolean checkIfHalfMarathonQualified(Runner runner) {
//      for(Double halfMarathonTime: runner.getHalfMarathonTimes()) {
//        if(halfMarathonTime < QUALIFYING_TIME){
//          return Boolean.TRUE;
//        }
//      }
//      return Boolean.FALSE;
//    }
//
//    @Override
//    public boolean hasNext() {
//      return (internalCounter < runners.size());
//    }
//
//    @Override
//    public Object next() {
//      return runners.get(internalCounter++);
//    }
//  }
}
