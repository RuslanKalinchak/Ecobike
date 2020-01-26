import java.util.Comparator;

public class SortByPriceComparator implements Comparator <Bike> {
    @Override
    public int compare(Bike o1, Bike o2) {
        if (o1.getPrice()>o2.getPrice()){
            return 1;
        } else if (o1.getPrice()<o2.getPrice()){
            return -1;
        } else return 0;
    }
}
