package geometric;

import java.util.Arrays;

public interface Geometric {

    /**
     * @return The area of the geometric shape.
     */
    double getArea();

    // TODO documentation
    default double getX() {
        return getBorder(Side.LEFT);
    }

    // TODO documentation
    default double getY() {
        return getBorder(Side.BOTTOM);
    }

    enum Side {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
    }

    /**
     * @param side Which side to return.
     * @return The x or y value of the border of the smallest rectangle surrounding the geometric shape.
     */
    double getBorder(Side side);

    /**
     * Moves the geometric shape on the x- and y-axis.
     * @param dx How much to move horizontally.
     * @param dy How much to move vertically.
     */
    void moveObject(double dx, double dy);

    // TODO documentation
    default Geometric[] filter(Geometric[] shapes, GeometricPredicate criterion, double threshold) {
        return (Geometric[]) Arrays.stream(shapes)
                .filter(x -> criterion.predicate(x, threshold))
                .toArray();
    }
}
