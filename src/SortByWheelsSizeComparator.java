import java.util.Comparator;

public class SortByWheelsSizeComparator implements Comparator <Bike> {
    @Override
    public int compare(Bike o1, Bike o2) {
         if (o1.getClass().isInstance(FoldingBike.class)&&o2.getClass().isInstance(FoldingBike.class)){
            if (((FoldingBike)o1).getWheelsSize()>((FoldingBike)o2).getWheelsSize()){
                return 1;
            } else if (((FoldingBike)o1).getWheelsSize()<((FoldingBike)o2).getWheelsSize()){
                return -1;
            } else return 0;
        } else return 0;
    }
}
