package problem1;

public abstract class AbstractVehicle {
  private String iD;
  private float averageSpeed;
  private float maxSpeed;

  public AbstractVehicle(String iD, float averageSpeed, float maxSpeed) {
    this.iD = iD;
    this.averageSpeed = averageSpeed;
    this.maxSpeed = maxSpeed;
  }

  public String getiD() {
    return this.iD;
  }

  public void setiD(String iD) {
    this.iD = iD;
  }

  public float getAverageSpeed() {
    return this.averageSpeed;
  }

  public void setAverageSpeed(float averageSpeed) throws IllegalArgumentException {
    if (averageSpeed < 0) {
      throw new IllegalArgumentException();
    }
    this.averageSpeed = averageSpeed;
  }

  public float getMaxSpeed() {
    return this.maxSpeed;
  }

  public void setMaxSpeed(float maxSpeed) throws IllegalArgumentException {
    if (maxSpeed < 0) {
      throw new IllegalArgumentException();
    }
    this.maxSpeed = maxSpeed;
  }
}
