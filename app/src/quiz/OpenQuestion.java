package quiz;

import java.util.function.Function;

public class OpenQuestion extends Question {
    /**
     * Open question that allows any answer.
     * @param question The question to prompt the user with
     * @param exampleAnswer An example of a fully correct answer
     * @param evaluation Custom logic how to grade an answer
     */
    public OpenQuestion(String question, String exampleAnswer, Function<String, Integer> evaluation) {
        this.question = question;
        this.evaluation = evaluation;
        this.correctAnswer = exampleAnswer;
    }

    /**
     * Open question that allows any answer.
     * @param question The question to prompt the user with
     * @param answer The correct answer to the question
     * @param score The number of points to reward for a correct answer
     */
    public OpenQuestion(String question, String answer, int score) {
        this(question, answer, str -> str.equalsIgnoreCase(answer) ? score : 0);
    }

    /**
     * Open question that allows any answer. <br><br>
     * Will set default score of {@value DEFAULT_POINTS}
     * @param question The question to prompt the user with
     * @param answer The correct answer to the question
     */
    public OpenQuestion(String question, String answer) {
        this(question, answer, DEFAULT_POINTS);
    }

}
