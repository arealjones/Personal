package problem1;

public class TripReport {
  private AbstractVehicle vehicle;
  private float speed;
  private float distance;
  private int tripDuration;

  public TripReport(AbstractVehicle vehicle, float speed, float distance, int tripDuration) {
    this.vehicle = vehicle;
    this.speed = speed;
    this.distance = distance;
    this.tripDuration = tripDuration;
  }

  @Override
  public String toString() {
    return "TripReport for: " + vehicle.getiD() + "." +
        " Speed: " + speed + ", Distance: " + distance +
        ", Trip Duration: " + tripDuration +
        '.';
  }

  public void setTripDuration(int distance, int speed) {
    this.tripDuration = (distance/speed);
  }

  public int getTripDuration(int distance, int speed) {
    return (distance/speed);
  }
}
