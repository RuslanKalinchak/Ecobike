import java.util.Comparator;

public class SortByColorComparator implements Comparator <Bike> {
    @Override
    public int compare(Bike o1, Bike o2) {
        return (o1.getColor()).compareTo(o2.getColor());
    }
}
