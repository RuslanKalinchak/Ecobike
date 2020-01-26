public class EBike extends Bike {
    private int maximumSpeed;
    private int batteryCapacity;

    public EBike (String brand, int maximumSpeed, int weight, boolean availabilityOfLights, int batteryCapacity, String color, int price) {
        super(brand, weight, availabilityOfLights, color, price);
        this.maximumSpeed = maximumSpeed;
        this.batteryCapacity = batteryCapacity;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}
