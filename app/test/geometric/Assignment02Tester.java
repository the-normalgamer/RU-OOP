package geometric;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static geometric.Main.filter;

public class Assignment02Tester {
	private  Geometric[] shapes = new Geometric[10];
	private  int shapeAmount = 0;

	public Assignment02Tester() {
	}

	public void createCircle(double x, double y, double r) {
		shapes[shapeAmount] = new Circle(x, y, r);
		shapeAmount++;
	}

	public void createRectangle(double x, double y, double width, double height) {
		shapes[shapeAmount] =new Rectangle(x,y,width,height);
		shapeAmount++;
	}

	public double topBorder(int index) {
		return shapes[index].getBorder(Geometric.Side.TOP);
	}

	public double rightBorder(int index) {
		return shapes[index].getBorder(Geometric.Side.RIGHT);
	}

	public double bottomBorder(int index) {
		return shapes[index].getBorder(Geometric.Side.BOTTOM);
	}

	public double leftBorder(int index) {
		return shapes[index].getBorder(Geometric.Side.LEFT);
	}

	public double area(int index) {
		return shapes[index].getArea();
	}

	public void move(int index, double dx, double dy) {
		shapes[index].moveObject(dx,dy);
	}


	public void sortByArea() {
		Arrays.sort(shapes, new GeometricComparatorArea());
	}


	public void sortByX() {
		Arrays.sort(shapes, new GeometricComparatorX());
	}


	public void sortByY() {
		Arrays.sort(shapes, new GeometricComparatorY());
	}

	public void filterByArea(double threshold) {
		shapes = filter(shapes, new GeometricCriterionArea(), threshold);
	}

	public void filterByX(double threshold) {
		shapes = filter(shapes, new GeometricCriterionX(), threshold);
	}

	public void filterByY(double threshold) {
		shapes = filter(shapes, new GeometricCriterionY(), threshold);
	}

	public int getShapeCount() {
		return shapeAmount;
	}
}
