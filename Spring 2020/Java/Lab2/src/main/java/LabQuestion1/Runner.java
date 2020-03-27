package LabQuestion1;

import java.util.Objects;

/**
 * LabQuestion1.Runner is an object that is apart of the LabQuestion1.Athlete.
 */
public class Runner extends Athlete {
  private Double best5K;
  private Double bestHalf;
  private String favoriteEvent;

  /**
   * Constructor that creates the runner object.
   * @param athletesName Is the name of the runner.
   * @param height Is the height of the runner.
   * @param weight Is the weight of the runner.
   * @param league Is the league that the runner is on.
   * @param best5K Is the time of the runners best5K.
   * @param bestHalf Is the time of the runners best half marathon.
   * @param favoriteEvent Is the runners favorite event.
   */
  public Runner(Name athletesName, Double height, Double weight, String league, Double best5K,
      Double bestHalf, String favoriteEvent) {
    super(athletesName, height, weight, league);
    this.best5K = best5K;
    this.bestHalf = bestHalf;
    this.favoriteEvent = favoriteEvent;
  }
  /**
   * Returns the best 5K time of the runner.
   * @return Returns the best 5K time of the runner.
   */
  public Double getBest5K() {
    return best5K;
  }
  /**
   * Return the best half marathon for the runner.
   * @return Return the best half marathon for the runner.
   */
  public Double getBestHalf() {
    return bestHalf;
  }
  /**
   * Returns the runners favorite event.
   * @return Returns the runners favorite event.
   */
  public String getFavoriteEvent() {
    return favoriteEvent;
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
    Runner runner = (Runner) o;
    return Objects.equals(best5K, runner.best5K) &&
        Objects.equals(bestHalf, runner.bestHalf) &&
        Objects.equals(favoriteEvent, runner.favoriteEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), best5K, bestHalf, favoriteEvent);
  }

  @Override
  public String toString() {
    return "LabQuestion1.Runner{" +
        "best5K=" + best5K +
        ", bestHalf=" + bestHalf +
        ", favoriteEvent='" + favoriteEvent + '\'' +
        '}';
  }

}
