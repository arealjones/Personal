package DesignPatterns.Builder.alarm;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        BasicAlarm allOptions = new BasicAlarm(LocalTime.NOON, DayOfWeek.MONDAY, "Eat lunch", "Bell", true);
        Alarm builderOptions = new Alarm.Builder(LocalTime.NOON)
                                    .addLabel("Eat lunch")
                                    .enableSnooze()
                                    .repeat(DayOfWeek.MONDAY)
                                    .useSound("Bell")
                                    .build();

        BasicAlarm basicSnooze = new BasicAlarm(LocalTime.NOON, true);
        Alarm builderSnooze = new Alarm.Builder(LocalTime.NOON).enableSnooze().build();


        BasicAlarm threeOptions = new BasicAlarm(LocalTime.NOON, DayOfWeek.THURSDAY,null, "Bell", false);
        Alarm builderThreeOptions = new Alarm.Builder(LocalTime.NOON)
                                                .repeat(DayOfWeek.THURSDAY)
                                                .useSound("Bell")
                                                .build();
    }
}
