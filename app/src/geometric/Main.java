package geometric;

import java.util.Arrays;
import java.util.Comparator;
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

	static Geometric[] filter(Geometric[] shapes, GeometricPredicate criterion, double threshold) {
		return Arrays.stream(shapes)
				.filter(x -> {
					boolean result = criterion.predicate(x, threshold);
					if (!result) index--;
					return result;
				})
				.toArray(size -> new Geometric[size]);
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
						if (index == NO_SHAPES) {
							System.out.println("There is no room for more shapes!");
							break;
						}

						double x, y, r;
						try {
							x = Double.parseDouble(input[1]);
							y = Double.parseDouble(input[2]);
							r = Double.parseDouble(input[3]);
						} catch (Exception e) {
							System.out.println("Invalid inputs!\n");
							break;
						}

						shapes[index] = new Circle(x, y, r);
						index++;
						System.out.println("Successfully added circle!");
						break;
					}
					System.out.println("Usage: \ncircle <x> <y> <r> \n");
					break;
				}

				case "rectangle": {
					if (input.length == 5) { // Expected input: rectangle x y w h
						if (index == NO_SHAPES) {
							System.out.println("There is no room for more shapes!");
							break;
						}

						double x, y, w, h;
						try {
							x = Double.parseDouble(input[1]);
							y = Double.parseDouble(input[2]);
							w = Double.parseDouble(input[3]);
							h = Double.parseDouble(input[4]);
						} catch (Exception e) {
							System.out.println("Invalid inputs!\n");
							break;
						}

						shapes[index] = new Rectangle(x, y, w, h);
						index++;
						System.out.println("Successfully added rectangle!");
						break;
					}
					System.out.println("Usage: \nrectangle <x> <y> <width> <height>\n");
					break;
				}

				case "move": {
					if (input.length == 4) { // Expected input: move i x y
						try {
							shapes[Integer.parseInt(input[1])].moveObject(
									Integer.parseInt(input[2]),
									Integer.parseInt(input[3])
							);
						} catch (Exception e) {
							System.out.println("Invalid inputs!\n");
							break;
						}
						break;
					}
					System.out.println("Usage: \nmove <index> <horizontal> <vertical> \n");
					break;
				}

				case "remove": {
					if (input.length == 2) { // Expected input: remove i
						try {
							int inputIndex = Integer.parseInt(input[1]);
							if (shapes[inputIndex] == null) {
								System.out.println("Index " + inputIndex + " is already empty!");
								break;
							}
							System.out.println("Successfully removed " + shapes[inputIndex]);

							// Move all elements down (overrides the element at i)
							for (int i = inputIndex; i < NO_SHAPES - 1; i++) shapes[i] = shapes[i + 1];
							shapes[NO_SHAPES - 1] = null;
							index--;
						} catch (Exception e) {
							System.out.println("Invalid input!\n");
							break;
						}
						break;
					}
					System.out.println("Usage: \nremove <index> \n");
					break;
				}

				case "filter": {
					if (input.length == 3) { // Expected input: filter c n
						double n;
						GeometricPredicate criterion;

						try {
							n = Double.parseDouble(input[2]);

							switch (input[1]) {
								case "x": criterion = new GeometricCriterionX(); break;
								case "y": criterion = new GeometricCriterionY(); break;
								case "a": criterion = new GeometricCriterionArea(); break;
								default:  throw new Exception("THAT'S NOT A CRITERION YOU DONUT");
							}
						} catch (Exception e) {
							System.out.println("Invalid inputs!\n");
							break;
						}
						shapes = filter(shapes, criterion, n);
						System.out.println("Successfully filtered shapes!");
						break;
					}
					System.out.println("Usage: \nfilter <criterion> <threshold>\n");
					break;
				}

				case "sort": {
					if (input.length == 1 || input.length == 2) { // Expected input: sort [c]

						Comparator<Geometric> comparator = new GeometricComparatorArea();
						if (input.length == 2) {
							try {
								switch (input[1]) {
									case "x": comparator = new GeometricComparatorX(); break;
									case "y": comparator = new GeometricComparatorY(); break;
								}
							} catch (Exception e) {
								System.out.println("Invalid inputs!\n");
								break;
							}
						}
						Arrays.sort(shapes, comparator);
						System.out.println("Successfully sorted shapes!");
						break;
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
