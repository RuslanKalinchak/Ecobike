import java.util.Comparator;

public class SortByAvailabilityOfLightsComparator implements Comparator <Bike> {
    @Override
    public int compare(Bike o1, Bike o2) {
        return Boolean.compare(o1.isAvailabilityOfLights(), o2.isAvailabilityOfLights());
    }
}
