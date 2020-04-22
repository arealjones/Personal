package DesignPatterns.Builder.alarm;


import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Represents an alarm class with a number of default/optional parameters. This class does not use a builder pattern.
 */
public class BasicAlarm {
    private static final String DEFAULT_SOUND = "radar";
    private static final boolean DEFAULT_SNOOZE = false;
    private LocalTime time; // The only required parameter
    private DayOfWeek repeat;
    private String label;
    private String sound; // Default radar
    private boolean snooze; // Default false

    public BasicAlarm(LocalTime time) {
        this.time = time;
        this.sound = DEFAULT_SOUND;
        this.snooze = DEFAULT_SNOOZE;
    }

    public BasicAlarm(LocalTime time, DayOfWeek repeat) {
        this.time = time;
        this.repeat = repeat;
        this.sound = DEFAULT_SOUND;
        this.snooze = DEFAULT_SNOOZE;
    }

    public BasicAlarm(LocalTime time, String label) {
        this.time = time;
        this.label = label;
        this.sound = DEFAULT_SOUND;
        this.snooze = DEFAULT_SNOOZE;
    }

    public BasicAlarm(LocalTime time, boolean snooze) {
        this.time = time;
        this.sound = DEFAULT_SOUND;
        this.snooze = snooze;
    }

    public BasicAlarm(LocalTime time, DayOfWeek repeat, String label, String sound, boolean snooze) {
        this.time = time;
        this.repeat = repeat;
        this.label = label;
        this.sound = sound;
        this.snooze = snooze;
    }

    // MANY MORE CONSTRUCTORS WOULD BE POSSIBLE!

    public LocalTime getTime() {
        return this.time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public DayOfWeek getRepeat() {
        return this.repeat;
    }

    public void setRepeat(DayOfWeek repeat) {
        this.repeat = repeat;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSound() {
        return this.sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public boolean isSnooze() {
        return this.snooze;
    }

    public void setSnooze(boolean snooze) {
        this.snooze = snooze;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicAlarm that = (BasicAlarm) o;
        return isSnooze() == that.isSnooze() &&
                Objects.equals(getTime(), that.getTime()) &&
                getRepeat() == that.getRepeat() &&
                Objects.equals(getLabel(), that.getLabel()) &&
                Objects.equals(getSound(), that.getSound());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime(), getRepeat(), getLabel(), getSound(), isSnooze());
    }

    @Override
    public String toString() {
        return "BasicAlarm{" +
                "time=" + time +
                ", repeat=" + repeat +
                ", label='" + label + '\'' +
                ", sound='" + sound + '\'' +
                ", snooze=" + snooze +
                '}';
    }
}
