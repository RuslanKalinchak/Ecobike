public abstract class Bike {

    private String brand;
    private int weight;
    private boolean availabilityOfLights;
    private String color;
    private int price;

    public Bike (String brand, int weight, boolean availabilityOfLights, String color, int price){
        this.brand = brand;
        this.weight = weight;
        this.availabilityOfLights = availabilityOfLights;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isAvailabilityOfLights() {
        return availabilityOfLights;
    }

    public void setAvailabilityOfLights(boolean availabilityOfLights) {
        this.availabilityOfLights = availabilityOfLights;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    }
