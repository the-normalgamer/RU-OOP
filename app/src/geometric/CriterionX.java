package geometric;

public class CriterionX implements GeometricPredicate {
    @Override
    public boolean predicate(Geometric shape, double threshold) {
        return shape.getX() >= threshold;
    }
}
