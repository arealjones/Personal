package LabQuestion1;

import java.util.Objects;

/**
 * LabQuestion1.BaseballPlayer is an object of an athlete on a team.
 */
public class BaseballPlayer extends Athlete {
  private String team;
  private Double averageBat;
  private Integer homeRuns;
  /**
   * Constructor that creates the baseballplayer object.
   * @param athletesName Is the baseball players name.
   * @param height Is the baseball players height.
   * @param weight Is the baseball players weight.
   * @param league Is the baseball players league.
   * @param team Is the team that the baseball player is on.
   * @param averageBat Is the average bat of the baseball player.
   * @param homeRuns Is the amount of home runs that the baseball player has received.
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league,
      String team, Double averageBat, Integer homeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.averageBat = averageBat;
    this.homeRuns = homeRuns;
  }
  /**
   * Returns the team that the baseball player is on.
   * @return Returns the team that the baseball player is on.
   */
  public String getTeam() {
    return team;
  }
  /**
   * Returns the average bat of the baseball player.
   * @return Returns the average bat of the baseball player.
   */
  public Double getAverageBat() {
    return averageBat;
  }
  /**
   * Returns the home runs of the baseball player.
   * @return Returns the home runs of the baseball player.
   */
  public Integer getHomeRuns() {
    return homeRuns;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    BaseballPlayer that = (BaseballPlayer) o;
    return Objects.equals(team, that.team) &&
        Objects.equals(averageBat, that.averageBat) &&
        Objects.equals(homeRuns, that.homeRuns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), team, averageBat, homeRuns);
  }

  @Override
  public String toString() {
    return "LabQuestion1.BaseballPlayer{" +
        "team='" + team + '\'' +
        ", averageBat=" + averageBat +
        ", homeRuns=" + homeRuns +
        '}';
  }

}
