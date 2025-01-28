package student;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        welcome();
    }
    
    public static void welcome() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, how big do you want the group to be?");
        int size = scan.nextInt();
        scan.nextLine(); // Consume line break

        Group group = new Group(size);

        // Populate the group
        for (int i = 0; i < size; i++) {
            // Prompt the user for a name
            System.out.println("Enter the name of student " + (i + 1) + ":");
            String[] name = scan.nextLine().split(" ", 2);
            String fName = name[0];
            String lName = name.length > 1 ? name[1] : "";

            // Prompt the user for a student number
            System.out.println("Enter the student number of student " + (i + 1) + ":");
            int number = scan.nextInt();
            scan.nextLine(); // Consume line break

            // Create a new student and add it
            group.addStudent(new Student(fName, lName, number));
        }

        // Print students
        System.out.println(group.asString());

        // Prompt for changing student names
        while (true) {
            System.out.println("Student number and new given/family name:");
            String[] name = scan.nextLine().split(" ", 3);
            if (name.length > 2) {
                int number = Integer.parseInt(name[0]);

                if (number < 0) break; // Break at negative number

                String fName = name[1];
                String lName = name[2];

                group.changeStudentName(number, fName, lName);
                System.out.println("Changed name of student s" + number + " to " + fName + " " + lName);
            } else {
                System.out.println("Invalid input! Please enter the student number, followed by the new full name.");
            }
        }
        System.out.println("Bye!");
    }
}
