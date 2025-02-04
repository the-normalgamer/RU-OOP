package geometric;

public class GeometricCriterionX implements GeometricPredicate {
    @Override
    public boolean predicate(Geometric shape, double threshold) {
        return shape == null || shape.getX() >= threshold;
    }
}
