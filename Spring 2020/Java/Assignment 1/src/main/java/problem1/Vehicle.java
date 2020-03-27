package problem1;
/**
 * Vehicle is a simple object that has a unique Vehicle Identification Number (VIN), and corresponding license plate.
 */
public class Vehicle {
    private int vin;
    private String licensePlate;
    private Owner owner;
    /**
     * Constructor that creates a new vehicle object with the specified VIN and license plate.
     * @param vin VIN of the new Vehicle object.
     * @param licensePlate license plate of the new Vehicle.
     * @param owner owner of the new Vehicle object.
     */
    public Vehicle(int vin, String licensePlate, Owner owner) {
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.owner = owner;
    }
    /**
     * Returns the VIN of the Vehicle.
     * @return the VIN of the Vehicle.
     */
    public int getVin() {
        return vin;
    }
    /**
     * Returns the licensePlate of the Vehicle.
     * @return the licensePlate of the Vehicle.
     */
    public String getLicensePlate() {
        return licensePlate;
    }
    /**
     * Returns the Owners full name.
     * @return the Owners full name.
     */
    public String getOwnerName() {
        return owner.getFullName();
    }
    /**
     * Returns the Owners phone number.
     * @return the Owners phone number.
     */
    public String getOwnerPhone() {
        return owner.getPhoneNumber();
    }
    /**
     * Sets the VIN of the Vehicle.
     * @param vin - Sets the VIN of the Vehicle.
     */
    public void setVin(int vin) {
        this.vin = vin;
    }
    /**
     * Sets the license plate.
     * @param licensePlate - Sets the license plate.
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
