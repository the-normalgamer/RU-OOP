package geometric;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Assignment02Tester {
	private ArrayList<Geometric> shapes = new ArrayList<Geometric>();

	public Assignment02Tester() {
	}

	public void createCircle(double x, double y, double r) {
		shapes.add(new Circle(x, y, r));
	}

	public void createRectangle(double x, double y, double width, double height) {
		shapes.add(new Rectangle(x,y,width,height));
	}

	public double topBorder(int index) {
		return shapes.get(index).getBorder(Geometric.Side.TOP);
	}

	public double rightBorder(int index) {
		return shapes.get(index).getBorder(Geometric.Side.RIGHT);
	}

	public double bottomBorder(int index) {
		return shapes.get(index).getBorder(Geometric.Side.BOTTOM);
	}

	public double leftBorder(int index) {
		return shapes.get(index).getBorder(Geometric.Side.LEFT);
	}

	public double area(int index) {
		return shapes.get(index).getArea();
	}

	public void move(int index, double dx, double dy) {
		shapes.get(index).moveObject(dx,dy);
	}

	//TODO
	public void sortByArea() {
		Geometric.sort(shapes, new )
	}

	//TODO
	public void sortByX() {
	}

	//TODO
	public void sortByY() {
	}

	public void filterByArea(double threshold) {
		Geometric.filter(shapes, new CriterionArea(), threshold);
	}

	public void filterByX(double threshold) {
		Geometric.filter(shapes, new CriterionX(), threshold);
	}

	public void filterByY(double threshold) {
		Geometric.filter(shapes, new CriterionY(), threshold);
	}

	public int getShapeCount() {
		return shapes.size();
	}
}
