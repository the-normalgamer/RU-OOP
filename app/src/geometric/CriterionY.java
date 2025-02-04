package geometric;

public class CriterionY implements GeometricPredicate {
    @Override
    public boolean predicate(Geometric shape, double threshold) {
        return shape.getY() >= threshold;
    }
}
