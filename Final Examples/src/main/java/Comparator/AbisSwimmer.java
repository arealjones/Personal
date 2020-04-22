package Comparator;

import java.util.List;

/**
 * Class Swimmer contains information about a swimmer, and the list of their swimming times, when
 * swimming 50m. Four swimming styles are considered: butterfly, backstroke, breaststroke, and freestyle.
 */
public class AbisSwimmer implements Comparable<AbisSwimmer> {
    private String name;
    private List<Double> butterfly50mTimes;
    private List<Double> backstroke50mTimes;
    private List<Double> breaststroke50mTimes;
    private List<Double> freestyle50mTimes;

    public AbisSwimmer(String name, List<Double> butterfly50mTimes, List<Double> backstroke50mTimes,
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

    @Override
    public int compareTo(AbisSwimmer otherSwimmer) {
        // Use Streams to implement compareTo as described in lab 7: compare by average freestyle swimming times
        Double thisAverage = this.freestyle50mTimes.stream().mapToDouble(time -> time).average().getAsDouble();
        Double otherAverage = otherSwimmer.freestyle50mTimes.stream().mapToDouble(time -> time).average().getAsDouble();
        return thisAverage.compareTo(otherAverage);
    }

    @Override
    public String toString() {
        return "Swimmer{" +
                "name='" + name + '\'' +
                ", butterfly50mTimes=" + butterfly50mTimes +
                ", backstroke50mTimes=" + backstroke50mTimes +
                ", breaststroke50mTimes=" + breaststroke50mTimes +
                ", freestyle50mTimes=" + freestyle50mTimes +
                '}';
    }
}
