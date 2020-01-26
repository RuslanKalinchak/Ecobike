import java.util.Comparator;

public class SortByTypeComparator implements Comparator <Bike> {
    @Override
    public int compare(Bike o1, Bike o2) {

        return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());

    }
}
