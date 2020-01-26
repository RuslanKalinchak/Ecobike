public class FoldingBike extends Bike {

    private int wheelsSize;
    private int gearsNumber;


    public FoldingBike (String brand, int wheelsSize, int gearsNumber, int weight, boolean availabilityOfLights, String color, int price) {
        super(brand, weight, availabilityOfLights, color, price);
        this.wheelsSize = wheelsSize;
        this.gearsNumber = gearsNumber;
    }

    public int getWheelsSize() {
        return wheelsSize;
    }

    public void setWheelsSize(int wheelsSize) {
        this.wheelsSize = wheelsSize;
    }

    public int getGearsNumber() {
        return gearsNumber;
    }

    public void setGearsNumber(int gearsNumber) {
        this.gearsNumber = gearsNumber;
    }

}

