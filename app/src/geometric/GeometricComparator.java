package geometric;

import java.util.Comparator;

public class GeometricComparator implements Comparator<Geometric> {
    @Override
    public int compare(Geometric o1, Geometric o2) {
        double area1 = o1.getArea();
        double area2 = o2.getArea();
        return Double.compare(area1, area2);
    }
}
