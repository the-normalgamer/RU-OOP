package geometric;

public class GeometricCriterionY implements GeometricPredicate {
    @Override
    public boolean predicate(Geometric shape, double threshold) {
        return shape == null || shape.getY() >= threshold;
    }
}
