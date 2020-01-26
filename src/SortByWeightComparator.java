import java.util.Comparator;

public class SortByWeightComparator implements Comparator <Bike> {

    @Override
    public int compare(Bike o1, Bike o2) {
        if (o1.getWeight()>o2.getWeight()){
            return 1;
        } else if (o1.getWeight()<o2.getWeight()){
            return -1;
        } else return 0;
    }
}
