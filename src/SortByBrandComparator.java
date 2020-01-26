import java.util.Comparator;

public class SortByBrandComparator implements Comparator <Bike> {

    @Override
    public int compare(Bike o1, Bike o2) {
        return (o1.getBrand().compareTo(o2.getBrand()));
    }
}
