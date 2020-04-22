package Comparator.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Vehicle {
  private String make;
  private String model;
  private Integer year;
  private String licensePlate;

  public Vehicle(String make, String model, Integer year, String licensePlate) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.licensePlate = licensePlate;
  }

  public String getMake() {
    return make;
  }

  public String getMakeModel() {
    return make + " " +model;
  }

  public String getModel() {
    return model;
  }

  public Integer getYear() {
    return year;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  @Override
  public String toString() {
    return make + " " + model + " " + year;
  }

  public static void main(String[] args) {
    List<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Vehicle("Tesla", "Model S", 2017, "ABC1234"));
    vehicles.add(new Vehicle("Honda", "CRV", 2018, "BCD4567"));
    vehicles.add(new Vehicle("Audi", "A8", 2019, "MYRIDE8"));
    vehicles.add(new Vehicle("Toyota", "Prius", 2014, "CLEANCAR5"));
    vehicles.add(new Vehicle("BMW", "i3", 2016, "CZ56A56"));

    Comparator<Vehicle> make = new Comparator<Vehicle>() {
      @Override
      public int compare(Vehicle v1, Vehicle v2){
        return v1.getMake().compareTo(v2.getMake());
      }
    };
    System.out.println("Vehicles:" + vehicles);
    vehicles.sort(make);
    System.out.println("Vehicles again:" + vehicles.stream().filter(vehicle -> vehicle.getYear() > 2015)
        .map(Vehicle::getMakeModel).collect(Collectors.toList()));

    Comparator<Vehicle> newModel = new Comparator<Vehicle>() {
      @Override
      public int compare(Vehicle v1, Vehicle v2) {
        return v1.getModel().compareTo(v2.getModel()); }
    };
    Comparator<Vehicle> newLicensePlate = new Comparator<Vehicle>(){
      @Override
      public int compare(Vehicle v1, Vehicle v2) {
        return v1.getLicensePlate().compareTo(v2.getLicensePlate());
      }
    };
  //YOUR CODE HERE
  System.out.println("Vehicles yet again: " + vehicles.stream()
      .filter(vehicle -> vehicle.getMake() == "Honda" || vehicle.getMake() == "Toyota") .filter(vehicle -> vehicle.getYear() > 2015)
      .count());
  }
}




