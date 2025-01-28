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

        Group group = new Group(size);

        for (int i = 0; i < size; i++) {
            // Prompt the user for a name
            System.out.println("Enter the name of student " + i);
            String[] name = scan.toString().split(" ", 2);
            String fName = name[0];
            String lName = name[1];

            // Prompt the user for a student number
            System.out.println("Enter the student number of student " + i);
            int number = scan.nextInt();

            // Create a new student and add it
            Student student = new Student(fName, lName, number);
            group.addStudent(student, i);
        }
    }
}
