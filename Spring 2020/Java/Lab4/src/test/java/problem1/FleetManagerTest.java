package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FleetManagerTest {
  AbstractVehicle bus;
  AbstractVehicle boat;
  AbstractVehicle train;
  FleetManager trip1;
  FleetManager trip2;
  FleetManager trip3;

  @Before
  public void setUp() throws Exception {
    bus = new Bus("bus", 71, 130);
    boat = new Boat("boat", 34, 84);
    train = new Train("train", 177, 300);
    trip1 = new FleetManager(bus, 130, 1240, 0);
    trip2 = new FleetManager(boat, 51, 500, 0);
    trip3 = new FleetManager(train, 432, 7230, 0);
  }

  @Test
  public void testDrive() {
    assertEquals("TripReport for: bus. Speed: 71.0, Distance: 1240.0, "
        + "Trip Duration: 17.", trip1.drive1(1240, bus).toString());
    assertEquals("TripReport for: boat. Speed: 34.0, Distance: 500.0, "
        + "Trip Duration: 14.", trip2.drive1(500, boat).toString());
    assertEquals("TripReport for: train. Speed: 177.0, Distance: 7230.0, "
        + "Trip Duration: 40.", trip3.drive1(7230, train).toString());
  }

  @Test
  public void testDrive2() {
    assertEquals("TripReport for: bus. Speed: 130.0, Distance: 1240.0, "
        + "Trip Duration: 9.", trip1.drive2(200, 1240, bus).toString());
    assertEquals("TripReport for: boat. Speed: 84.0, Distance: 500.0, "
        + "Trip Duration: 5.", trip2.drive2(100,500, boat).toString());
    assertEquals("TripReport for: train. Speed: 300.0, Distance: 7230.0, "
        + "Trip Duration: 24.", trip3.drive2(350, 7230, train).toString());
  }

  @Test
  public void testDrive3() {
    assertEquals("TripReport for: bus. Speed: 60.0, Distance: 200.0, "
        + "Trip Duration: 3.", trip1.drive3(60, 200, bus).toString());
    assertEquals("TripReport for: boat. Speed: 111.0, Distance: 500.0, "
        + "Trip Duration: 4.", trip2.drive3(111,500, boat).toString());
    assertEquals("TripReport for: train. Speed: 900.0, Distance: 7230.0, "
        + "Trip Duration: 8.", trip3.drive3(900, 7230, train).toString());
  }

  @Test
  public void testDrive4() {
    assertEquals("TripReport for: bus. Speed: 71.0, Distance: 200.0, "
        + "Trip Duration: 2.", trip1.drive4(200, bus).toString());
    assertEquals("TripReport for: boat. Speed: 34.0, Distance: 500.0, "
        + "Trip Duration: 14.", trip2.drive4(500, boat).toString());
    assertEquals("TripReport for: train. Speed: 177.0, Distance: 7230.0, "
        + "Trip Duration: 40.", trip3.drive4(7230, train).toString());
  }
}