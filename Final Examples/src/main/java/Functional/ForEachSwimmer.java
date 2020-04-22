package Functional;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForEachSwimmer {
    public static void main(String[] args) {
        int MAX_TIME = 100;
        int MIN_RECORDED_TIMES = 5;
        double OLYMPIC_QUAL = 27.17;

        /**
         * Randomly generates a list of numTimes Doubles between 0 and 100. */
        Function<Integer, List<Double>> makeSwimTimes = numTimes ->
                new Random().doubles(numTimes).map(time -> time * MAX_TIME)
                        .boxed().collect(Collectors.toList());
        /**
         * Complete each of the following tasks using only Streams, function objects and lambda expressions.
         * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html */
        /**
         * Task 1: Complete the compareTo method in the Swimmer class. A comment in the method explains how to compare
         * swimmers. */
        // This swimmer should qualify IF their freestyle times include an olympic qualifying time.
        Swimmer s1 = new Swimmer("6 butterfly times", makeSwimTimes.apply(6), makeSwimTimes.apply(1),
                makeSwimTimes.apply(4), makeSwimTimes.apply(10));
        // This swimmer should qualify IF their freestyle times include an olympic qualifying time.
        Swimmer s2 = new Swimmer("10 butterfly times", makeSwimTimes.apply(10), makeSwimTimes.apply(2),
                makeSwimTimes.apply(0), makeSwimTimes.apply(10));
        // This swimmer should not qualify.
        Swimmer s3 = new Swimmer("3 butterfly times", makeSwimTimes.apply(3), makeSwimTimes.apply(0),
                makeSwimTimes.apply(0), makeSwimTimes.apply(10));
        List<Swimmer> swimmers = Stream.of(s1, s2, s3).collect(Collectors.toList());
        System.out.println("The swimmers:");
        swimmers.forEach(System.out::println);

        /**
         * Task 2: Use forEach plus any other Stream methods to print out swimmers that meet the requirements for the
         * SwimmerIterator in Lab 7 - at least 5 butterfly times and at least 1 Olympic freestyle qualifying time. */
        System.out.println(System.lineSeparator() + "Swimmers with at least 5 butterfly times and at least one Olympic freestyle time");
        swimmers.stream().filter(swimmer -> swimmer.getButterfly50mTimes().size() > MIN_RECORDED_TIMES)
                .filter(swimmer -> swimmer.getFreestyle50mTimes().stream().filter(time -> time >= OLYMPIC_QUAL)
                        .count() > 0)
                .forEach(System.out::println);
    }
}
