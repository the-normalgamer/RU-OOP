package geometric;

import java.util.Comparator;

public class GeometricComparatorY implements Comparator<Geometric> {
    @Override
    public int compare(Geometric o1, Geometric o2) {
        if (o1 == null) return (o2 == null) ? 0 : 1;
        if (o2 == null) return -1;

        double area1 = o1.getY();
        double area2 = o2.getY();
        return Double.compare(area1, area2);
    }
}
