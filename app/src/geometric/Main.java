package geometric;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// For this assignment, you have to create all the required files yourself.
	// Tests are available in the test directory.


	public static void main(String[] args) {
		manipulate();
	}

	public static void manipulate() {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.print("> ");
			String[] input = scan.nextLine().split(" ");

			if (input[0].isEmpty())      continue;
			if (input[0].equals("quit")) break;

			switch (input[0]) {
				case "show": {
					System.out.println("Entered show command");
					break;
				}
				case "circle": {
					System.out.println("Entered circle command");
					break;
				}
				case "rectangle": {
					System.out.println("Entered rectangle command");
					break;
				}
				case "move": {
					System.out.println("Entered move command");
					break;
				}
				case "remove": {
					System.out.println("Entered remove command");
					break;
				}
				case "filter": {
					System.out.println("Entered filter command");
					break;
				}
				case "sort": {
					System.out.println("Entered sort command");
					break;
				}
				default: System.out.println("Unknown command: '" + input[0] + "'! Please try again.");
			}

//			System.out.println("Got: " + Arrays.toString(input));
		}
	}
}
