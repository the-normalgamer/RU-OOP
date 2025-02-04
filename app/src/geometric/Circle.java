package geometric;

import static java.lang.Math.PI;

public class Circle implements Geometric {
    double centerX;
    double centerY;
    double radius;

    public Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius  = radius;
    }

    public Circle() {
        this.centerX = 0.0;
        this.centerY = 0.0;
        this.radius  = 1.0;
    }

    @Override
    public double getArea() {
        return this.radius * this.radius * PI; // A = π⋅r²
    }

    @Override
    public double getBorder(Side side) {
        return switch (side) {
            case TOP ->    this.centerY + this.radius;
            case BOTTOM -> this.centerY - this.radius;
            case RIGHT ->  this.centerX + this.radius;
            case LEFT ->   this.centerX - this.radius;
        };
    }

    @Override
    public void moveObject(double dx, double dy) {
        this.centerX += dx;
        this.centerY += dy;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "centerX=" + centerX +
                ", centerY=" + centerY +
                ", radius=" + radius +
                '}';
    }
}
