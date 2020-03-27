package problem2;
/**
 * Runner is an object that includes the individuals name, team, start time, and end time. */
public class Runner {
    private String name;
    private String team;
    private Time startTime;
    private Time endTime;
    /**
     * Constructor that creates a new runner object with their name, team, start time, and end time.
     * @param name The runners name.
     * @param team The team that the runner is on.
     * @param startTime The start time of the runner.
     * @param endTime The end time of the runner. */
    public Runner(String name, String team, Time startTime, Time endTime) {
        this.name = name;
        this.team = team;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    /**
     * Sets the name of the runner.
     * @param name Sets the name of the runner. */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Sets the team for the runner.
     * @param team Sets the team for the runner. */
    public void setTeam(String team) {
        this.team = team;
    }
    /**
     * Returns the name of the runner.
     * @return the name of the runner. */
    public String getName() {
        return name;
    }
    /**
     * Returns the team of the runner.
     * @return Returns the team of the runner. */
    public String getTeam() {
        return team;
    }
    /**
     * Returns the start time of the runner.
     * @return Returns the start time of the runner. */
    public String getStartTime() {
        return startTime.getFullTime();
    }
    /**
     * Returns the end time of the runner.
     * @return Returns the end time of the runner. */
    public String getEndTime() {
        return endTime.getFullTime();
    }
    /**
     * Returns the duration of the runners run.
     * @return Returns the duration of the runners run. */
    public Time getDuration() {
        int secondsInHour = 3600;
        int newHour = (endTime.getFullSeconds() - startTime.getFullSeconds()) / secondsInHour;
        int newMinutes = (((endTime.getFullSeconds() - startTime.getFullSeconds()) % secondsInHour) / 60);
        int remainingSeconds = (((endTime.getFullSeconds() - startTime.getFullSeconds()) % secondsInHour) % 60);
        return new Time(newHour, newMinutes, remainingSeconds);
    }
}
