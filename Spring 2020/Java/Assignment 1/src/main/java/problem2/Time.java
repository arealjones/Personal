package problem2;
/**
 * Time is an object that contains the hours, minutes, and seconds of a run. */
public class Time {
    private int hour;
    private int minutes;
    private int seconds;
    /**
     * Constructor that creates the hours, minutes, and seconds of a run.
     * @param hour Hours of the run.
     * @param minutes Minutes of the run.
     * @param seconds Seconds of the run. */
    public Time(int hour, int minutes, int seconds) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    /**
     * Sets the hours of a run.
     * @param hour Sets the hours of a run. */
    public void setHour(int hour) {
        this.hour = hour;
    }
    /**
     * Sets the minutes of a run.
     * @param minutes Sets the minutes of a run. */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    /**
     * Sets the seconds of a run.
     * @param seconds Sets the seconds of a run. */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
    /**
     * Returns the hours of a run.
     * @return Returns the hours of a run. */
    public int getHour() {
        int minHour = 0;
        int maxHour = 23;
        int none = -1;
        if ((minHour <= hour) && (hour <= maxHour)) {
            return hour;
        }
        else {
            return none;
        }
    }
    /**
     * Returns the minutes of a run.
     * @return Returns the minutes of a run. */
    public int getMinutes() {
        int minMinute = 0;
        int maxMinute = 59;
        int none = -1;
        if ((minMinute <= minutes) && (minutes <= maxMinute)) {
            return minutes;
        }
        else {
            return none;
        }
    }
    /**
     * Returns the seconds of a run.
     * @return Returns the seconds of a run. */
    public int getSeconds() {
        int minSeconds = 0;
        int maxSeconds = 59;
        int none = -1;
        if ((minSeconds <= seconds) && (seconds <= maxSeconds)) {
            return seconds;
        }
        else {
            return none;
        }
    }
    /**
     * Returns the total number of seconds for the run. It breaks down the hours and minutes.
     * @return Returns the total number of seconds for the run. It breaks down the hours and minutes. */
    public int getFullSeconds() {
        int newMinutes = ((hour * 60) + minutes);
        int newSeconds = ((newMinutes * 60) + seconds);
        return newSeconds;
    }
    /**
     * Returns a string of the full time it takes to run.
     * @return Returns a string of the full time it takes to run. */
    public String getFullTime() {
        int none = -1;
        if (getHour() != none) {
            if (getMinutes() != none) {
                if (getSeconds() != none) {
                    return (hour + " hours, " + minutes + " minutes, and " + seconds + " seconds.");
                }
            }
        }
        return "The time is out of range.";
    }
}
