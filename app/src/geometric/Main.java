package geometric;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// For this assignment, you have to create all the required files yourself.
	// Tests are available in the test directory.
	private static final int NO_SHAPES = 10;
	private static Geometric[] shapes = new Geometric[NO_SHAPES];
	private static int index = 0;

	public static void main(String[] args) {
		System.out.println("Loading command line...");
		commands();
		System.out.println("Goodbye!");
	}

	public static void commands() {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.print("> ");
			String[] input = scan.nextLine().split(" ");

			if (input[0].isEmpty())      continue;
			if (input[0].equals("quit")) break;

			switch (input[0]) {
				case "show": {
					if (input.length == 1) { // Expected input: show
						if (index == 0) {
							System.out.println("There are currently no geometric shapes!");
							break;
						}

						System.out.println("Showing all shapes: ");
						for (Geometric shape : shapes) {
							if (shape == null) continue;
							System.out.println(shape);
						}
						break;
					}
					System.out.println("Usage: \nshow \n");
					break;
				}
				case "circle": {
					if (input.length == 4) { // Expected input: circle x y r
						double x, y, z;
						try {
							x = Double.parseDouble(input[1]);
							y = Double.parseDouble(input[2]);
							z = Double.parseDouble(input[3]);
						} catch (Exception e) {
							System.out.println("Invalid inputs!\n");
							break;
						}

						shapes[index] = new Circle(x, y, z);
						index++;
						System.out.println("Successfully added circle!");
						break;
					}
					System.out.println("Usage: \ncircle <x> <y> <r> \n");
					break;
				}
				case "rectangle": {
					if (input.length == 5) { // Expected input: rectangle x y w h
						// TODO functionality
						break;
					}
					System.out.println("Usage: \ncircle <x> <y> <width> <height> \n");
					break;
				}
				case "move": {
					if (input.length == 4) { // Expected input: move i x y
						// TODO functionality
						break;
					}
					System.out.println("Usage: \nmove <index> <horizontal> <vertical> \n");
					break;
				}
				case "remove": {
					System.out.println("Entered remove command");
					break;
				}
				case "filter": {
					if (input.length == 1 || input.length == 2) { // Expected input: filter c n
						Arrays.sort(shapes, new GeometricComparator());
					}
					System.out.println("Usage: \nfilter <criterion> <threshold>\n");
					break;
				}
				case "sort": {
					if (input.length == 1 || input.length == 2) { // Expected input: sort [c]

					}
					System.out.println("Usage: \nsort [criterion] \n");
					break;
				}
				default: System.out.println("Unknown command: '" + input[0] + "'! Please try again.");
			}

//			System.out.println("Got: " + Arrays.toString(input));
		}
	}
}
