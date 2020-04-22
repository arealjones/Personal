package DesignPatterns.Builder.alarm;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

/**
 *  * Represents an alarm class with a number of default/optional parameters. Uses the builder pattern to handle
 *  construction.
 */
public class Alarm {
    private static final String DEFAULT_SOUND = "radar";
    private static final boolean DEFAULT_SNOOZE = false;
    private LocalTime time; // The only required parameter
    private DayOfWeek repeat;
    private String label;
    private String sound; // Default radar
    private boolean snooze; // Default false

    private Alarm(Builder builder) {
        this.time = builder.time;
        this.repeat = builder.repeat;
        this.label = builder.label;
        this.sound = builder.sound;
        this.snooze = builder.snooze;
    }

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
        Alarm alarm = (Alarm) o;
        return isSnooze() == alarm.isSnooze() &&
                Objects.equals(getTime(), alarm.getTime()) &&
                getRepeat() == alarm.getRepeat() &&
                Objects.equals(getLabel(), alarm.getLabel()) &&
                Objects.equals(getSound(), alarm.getSound());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime(), getRepeat(), getLabel(), getSound(), isSnooze());
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "time=" + time +
                ", repeat=" + repeat +
                ", label='" + label + '\'' +
                ", sound='" + sound + '\'' +
                ", snooze=" + snooze +
                '}';
    }

    public static class Builder {
        private LocalTime time; // The only required parameter
        private DayOfWeek repeat;
        private String label;
        private String sound; // Default radar
        private boolean snooze; // Default false

        public Builder(LocalTime time) {
            this.time = time;
            this.sound = DEFAULT_SOUND;
            this.snooze = DEFAULT_SNOOZE;
        }

        public Builder repeat(DayOfWeek repeat) {
            this.repeat = repeat;
            return this;
        }

        public Builder addLabel(String label) {
            this.label = label;
            return this;
        }

        public Builder useSound(String sound) {
            this.sound = sound;
            return this;
        }

        public Builder enableSnooze() {
            this.snooze = true;
            return this;
        }

        public Alarm build() {
            return new Alarm(this);
        }
    }
}
