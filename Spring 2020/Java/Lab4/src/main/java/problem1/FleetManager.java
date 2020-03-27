package problem1;

public class FleetManager extends TripReport {


  public FleetManager(AbstractVehicle vehicle, float speed, float distance, int tripDuration) {
    super(vehicle, speed, distance, tripDuration);
  }

  public TripReport drive1 (float distance, AbstractVehicle vehicle) {
    return new TripReport(vehicle, vehicle.getAverageSpeed(), distance,
        (super.getTripDuration((int)distance, (int)vehicle.getAverageSpeed())));
  }

  public TripReport drive2 (float speed, float distance, AbstractVehicle vehicle) {
    if (speed > vehicle.getMaxSpeed()) {
      return new TripReport(vehicle, vehicle.getMaxSpeed(), distance,
          (super.getTripDuration((int)distance, (int)vehicle.getMaxSpeed())));
    } else {
      return new TripReport(vehicle, vehicle.getAverageSpeed(), distance,
          (super.getTripDuration((int)distance, (int)vehicle.getAverageSpeed())));
    }
  }

  public TripReport drive3 (int speed, int distance, AbstractVehicle vehicle) {
    return new TripReport(vehicle, speed, distance,
        (super.getTripDuration((int)distance, speed)));
  }

  public TripReport drive4 (double distance, AbstractVehicle vehicle) {
    return new TripReport(vehicle, vehicle.getAverageSpeed(), (float)distance,
        (super.getTripDuration((int)distance, (int)vehicle.getAverageSpeed())));
  }
}
