package geometric;

public interface Geometric {

    /**
     * @return The area of the geometric shape.
     */
    double getArea();

    /**
     * @return X coordinate of the geometric shape.
     */
    default double getX() {
        return getBorder(Side.LEFT);
    }

    /**
     * @return Y coordinate of the geometric shape.
     */
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
}
