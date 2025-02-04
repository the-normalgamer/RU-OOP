package geometric;

public class GeometricCriterionArea implements GeometricPredicate {
    @Override
    public boolean predicate(Geometric shape, double threshold) {
        return shape == null || shape.getArea() >= threshold;
    }
}
