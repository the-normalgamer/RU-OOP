package geometric;

public class Rectangle implements Geometric {
    double originX;
    double originY;
    double width;
    double height;

    public Rectangle(double originX, double originY, double width, double height) {
        this.originX = originX;
        this.originY = originY;
        this.width   = width;
        this.height  = height;
    }

    public Rectangle() {
        this.originX = 0.0;
        this.originY = 0.0;
        this.width   = 1.0;
        this.height  = 1.0;
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public double getBorder(Side side) {
        return switch (side) {
            case TOP ->    this.originY + this.height;
            case BOTTOM -> this.originY;
            case RIGHT ->  this.originX + this.width;
            case LEFT ->   this.originX;
        };
    }

    @Override
    public void moveObject(double dx, double dy) {
        this.originX += dx;
        this.originY += dy;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "originX=" + originX +
                ", originY=" + originY +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
