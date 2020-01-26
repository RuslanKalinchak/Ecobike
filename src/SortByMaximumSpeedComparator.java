import java.util.Comparator;

public class SortByMaximumSpeedComparator implements Comparator <Bike> {
    @Override
    public int compare(Bike o1, Bike o2) {
       if (o1.getClass().equals(Speedelec.class)&&o2.getClass().equals(Speedelec.class)) {
           if (((Speedelec)o1).getMaximumSpeed()>((Speedelec)o2).getMaximumSpeed()){
               return 1;
           } else if (((Speedelec)o1).getMaximumSpeed()<((Speedelec)o2).getMaximumSpeed()){
               return -1;
           } else return 0;
       } else if (o1.getClass().equals(EBike.class)&&o2.getClass().equals(EBike.class)) {
           if (((EBike)o1).getMaximumSpeed()>((EBike)o2).getMaximumSpeed()){
               return 1;
           } else if (((EBike)o1).getMaximumSpeed()<((EBike)o2).getMaximumSpeed()){
               return -1;
           } else return 0;
       } else return 0;


}}
