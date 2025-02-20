package quiz;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	// You need to create the question classes yourself.
	// You can use the tests in the `test` directory to check your implementation.

	// In the tutorials, we were told we were allowed to alter the assignments a bit, given that we covered the original
	// assignment questions. This is why we added a custom evaluation system for open questions.
	public static void main(String[] args) {
		int totalPoints = 0;

		List<Question> questions = new LinkedList<>();

		questions.add(new OpenQuestion("What is the big O complexity of binary search?", "O(log N)"));
		questions.add(new OpenQuestion("How would you read an integer i from scanner s in Java?", "i = s.nextInt();", 2));
		questions.add(new OpenQuestion("What is the minimum amount of constructors you have to define for a class in Java?", "0", 2));

		questions.add(new MultipleChoiceQuestion("What is the best achievable complexity of in situ sorting?", new String[] { "O(N^2)", "O(N log N)", "O(N)", "O(log N)" }, 1, 4));
		questions.add(new MultipleChoiceQuestion("How do you print \"Hello world\" on a line in Java?", new String[] { "System.out.print(\"Hello world\");", "System.out.println(\"Hello world\");", "cout << \"Hello world\";" }, 1));
		questions.add(new MultipleChoiceQuestion("How do you read a non-empty word in Java using scanner s?", new String[] { "s.nextline()", "s.next(\"\\S+\")", "s.next(\"\\a*\")", "s.next(\"\\S*\")", "s.next(\"\\\\s+\")", "s.next(\"\\s+\")", "s.nextString(\"\\s*\")", "s.next(\"\\\\S+\")", "s.nextString()" }, 7, 1));

		questions.add(new ThisThatQuestion("Every class must have a constructor", "Right", "Wrong", 1));
		questions.add(new ThisThatQuestion("Is there a difference between an interface and an abstract class?", "Yes", "No", 0, 5));
		questions.add(new ThisThatQuestion("Is there a maximum to the amount of constructors a class can have in Java?", "Yes", "No", 1));

		// This is an example question of custom answer evaluation
		questions.add(new OpenQuestion("How many A's can you type? You get 1 point per A", "AAA",
				str -> Math.toIntExact(str.chars().filter(c -> c == 'a' || c == 'A').count())));

		Scanner scanner = new Scanner(System.in);
		for (Question question : questions){
			System.out.print(question + "\n");
			String answer = scanner.next();
			if (question.isCorrect(answer)){
				int pointsEarned = question.getPointReward(answer);
				totalPoints += pointsEarned;
				System.out.println("Correct! you earned "+pointsEarned+" points!\n Your total amount of points is now "+totalPoints+"!\n");
			} else {
				System.out.println("Incorrect, the answer was \""+question.correctAnswer +"\".\n you stay at "+totalPoints+" points.\n");
			}
		}

		System.out.println("Congrats! You finished with " + totalPoints + " points!");
	}
}