package geometric;

public class CriterionArea implements GeometricPredicate {
    @Override
    public boolean predicate(Geometric shape, double threshold) {
        return shape.getArea() >= threshold;
    }
}
