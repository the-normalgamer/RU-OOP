package quiz;

import java.util.Objects;

public class ThisThatQuestion extends MultipleChoiceQuestion{
    /**
     * Multiple choice question with only two options.
     * @param question The question to prompt the user with.
     * @param answerA Second possible answer.
     * @param answerB Second possible answer.
     * @param correctIndex Which of the two answers is correct, 0 or 1.
     *                      If negative, every answer is considered correct.
     * @param score The number of points to award when the correct answer is chosen.
     */
    ThisThatQuestion(String question, String answerA, String answerB, int correctIndex, int score) {
        super(question, new String[]{answerA, answerB}, correctIndex, score);
        this.evaluation = str -> (Objects.equals(str, this.correctAnswer) ? score : 0);
    }

    /**
     * Multiple choice question with only two options.<br><br>
     * Will set default score of {@value DEFAULT_POINTS}
     * @param question The question to prompt the user with.
     * @param answerA Second possible answer.
     * @param answerB Second possible answer.
     * @param correctAnswer Which of the two answers is correct, 0 or 1.
     *                      If negative, every answer is considered correct.
     */
    ThisThatQuestion(String question, String answerA, String answerB, int correctAnswer) {
        this(question, answerA, answerB, correctAnswer, DEFAULT_POINTS);
    }

    @Override
    public String toString() {
        // "<answerA> or <answerB>: <question>"
        return this.answers[0] + " or " + this.answers[1] + ": " + this.question;
    }
}
