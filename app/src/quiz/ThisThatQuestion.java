package quiz;

public class ThisThatQuestion extends MultipleChoiceQuestion{
    /**
     * Multiple choice question with only two options.
     * @param question The question to prompt the user with.
     * @param answerA Second possible answer.
     * @param answerB Second possible answer.
     * @param correctAnswer Which of the two answers is correct, 0 or 1.
     *                      If negative, every answer is considered correct.
     * @param score The number of points to award when the correct answer is chosen.
     */
    ThisThatQuestion(String question, String answerA, String answerB, int correctAnswer, int score) {
        super(question, new String[]{answerA, answerB}, correctAnswer, score);
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
}
