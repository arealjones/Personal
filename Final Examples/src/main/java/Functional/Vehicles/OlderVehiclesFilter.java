package Functional.Vehicles;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehiclesFilter {
  private List<Vehicle> vehicles = new ArrayList<>();

  /**
   * Contructor for if they pass a list of vehicles.
   * @param vehicles A list of vehicles. */
  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  /**
   * Constructor for if they pass in three different vehicles.
   * @param vehicle1 Vehicle 1.
   * @param vehicle2 Vehicle 2.
   * @param vehicle3 Vehicle 3. */
  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3) {
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle2);
  }

  /**
   * Helper method to filter the list of vehicles by year.
   * @return The filtered list. */
  public List<Vehicle> filterByYear() {
    return this.vehicles.stream().filter(vehicle -> vehicle.getYear() > 1999)
        .collect(Collectors.toList());
  }

  /**
   * Method to filter by year and then convert each vehicle to a string to add to a list.
   * @return A list of strings containing the vehicles make, model, and year. */
  public List<String> filterOlderVehicles() {
    List<Vehicle> properYear = this.filterByYear();
    List<String> result = properYear.stream().map(car -> car.getMake() + " " + car.getModel() + " " + car.getYear()).collect(Collectors.toList());
    System.out.println(result);
    return result;
  }

  // Ignore this, I just used it for testing.
  public static void main(String[] args) {
    Vehicle one = new Vehicle("Ford", "Focus", 2001, Color.red);
    Vehicle two = new Vehicle("Ford", "Fiesta", 1998, Color.black);
    Vehicle three = new Vehicle("Ford", "Flex", 2015, Color.blue);
    Vehicle four = new Vehicle("Ford", "Fusion", 2006, Color.pink);
    List<Vehicle> listTestOne = new ArrayList<>();
    listTestOne.add(one);
    listTestOne.add(two);
    listTestOne.add(three);
    listTestOne.add(four);
    OlderVehiclesFilter old = new OlderVehiclesFilter(listTestOne);
    old.filterOlderVehicles();
  }
}
